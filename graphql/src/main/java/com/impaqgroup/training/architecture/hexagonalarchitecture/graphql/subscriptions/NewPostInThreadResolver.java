package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.subscriptions;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphPostDto;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphUserDto;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@Slf4j
@Component
class NewPostInThreadResolver implements GraphQLSubscriptionResolver {

    private final BehaviorSubject<GraphPostDto> publishSubject;

    public NewPostInThreadResolver() {
        log.info("NewPostInThreadResolver created.");
        this.publishSubject = BehaviorSubject.create();
        Thread thread = new Thread(() -> {
            int counter = 0;
            while (true) {
                try {
                    long postId = counter++;
                    LocalDateTime now = LocalDateTime.now();
                    GraphUserDto user = new GraphUserDto("james@gov.uk", "James", "Bond", now, now, emptyStreamFormList(), emptyStreamFormList());
                    GraphPostDto post = new GraphPostDto(postId, "Post " + postId, "Content od post " + postId, () -> user);
                    publishSubject.onNext(post);
                    log.info("Post " + post + " was send...");
                } catch (Exception e) {
                    log.warn("Oops, sth went wrong!", e);
                } finally {
                    wait(4);
                }
            }
        });
        thread.setName("EventGeneratingThread");
        thread.start();
    }

    private <T> Stream<T> emptyStreamFormList() {
        return new ArrayList<T>().stream();
    }

    @SneakyThrows
    private void wait(int timeout)  {
        TimeUnit.SECONDS.sleep(timeout);
    }

    public Publisher<GraphPostDto> newPostInThread(String forumName, Long threadId) {
        log.info(String.format("Subscription for forum %s and thread %d", forumName, threadId));
        return publishSubject
                .toFlowable(BackpressureStrategy.DROP)
                .doOnSubscribe(subscription -> log.info("New subscription {}", subscription))
                .doOnNext(post -> log.info("Next post {}", post))
                .doOnComplete(() -> log.info("Subscription complete"))
                .doOnRequest(request -> log.info("Number of requested events"))
                .doOnError(ex -> log.error("Oops! Sth went wrong...", ex));
    }
}
