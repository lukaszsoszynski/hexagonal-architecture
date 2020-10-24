package com.impaqgroup.training.architecture.hexagonalarchitecture.soapprimaryadapter;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.ForumService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Post;
import com.impaqgroup.training.architecture.hexagonalarchitecture.soap.CommenceNewThread;
import com.impaqgroup.training.architecture.hexagonalarchitecture.soap.ListAllThreads;
import com.impaqgroup.training.architecture.hexagonalarchitecture.soap.ListAllThreadsResponse;
import com.impaqgroup.training.architecture.hexagonalarchitecture.soap.SoapThreadService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.soap.Thread;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ThreadSoapPrimaryAdapter implements SoapThreadService {

    private final ForumService forumService;

    private final ConversionService conversionService;

    @Override
    @Transactional
    public void commenceNewThread(CommenceNewThread commenceNewThread) {
        Post post = conversionService.convert(commenceNewThread.getPost(), Post.class);
        forumService.commenceThread(commenceNewThread.getForumName(), commenceNewThread.getThreadName(), post);
    }

    @Override
    @Transactional(readOnly = true)
    public ListAllThreadsResponse listAllThread(ListAllThreads listAllThreads) {
        List<Thread> threads = forumService
                .listThreadsInForum(listAllThreads.getForumName())
                .stream()
                .map(thread -> conversionService.convert(thread, Thread.class))
                .collect(Collectors.toList());
        ListAllThreadsResponse listAllThreadsResponse = new ListAllThreadsResponse();
        listAllThreadsResponse.getThread().addAll(threads);
        return listAllThreadsResponse;
    }
}
