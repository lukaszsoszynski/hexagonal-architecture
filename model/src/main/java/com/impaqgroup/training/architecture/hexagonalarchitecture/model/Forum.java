package com.impaqgroup.training.architecture.hexagonalarchitecture.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Forum {

    @Getter
    private String name;

    @Getter
    private String title;

    @Getter
    private List<Thread> threads;

    public void addThread(String threadName, Post post, User user) {
        threads.add(new Thread(threadName, this, post, user));
    }

    public void remove(Long threadId, Long postId) {
            getThreadById(threadId).removePost(postId);
    }

    public void updatePost(Long threadId, Post updatedPost) {
        getThreadById(threadId).updatePost(updatedPost);
    }

    public List<Post> getPostsFromThread(Long threadId) {
        return findThreadById(threadId)
                .map(Thread::getPosts)
                .orElse(Collections.emptyList());
    }

    private Optional<Thread> findThreadById(Long threadId) {
        return threads
                .stream()
                .filter(thread -> thread.getId().equals(threadId))
                .findFirst();
    }

    private Thread getThreadById(Long threadId){
        return findThreadById(threadId)
                .orElseThrow(() -> new ForumException(String.format("Thread %d not found", threadId)));
    }

    public void appendPostToThread(Long threadId, Post post) {
        getThreadById(threadId).appendPost(post);
    }
}
