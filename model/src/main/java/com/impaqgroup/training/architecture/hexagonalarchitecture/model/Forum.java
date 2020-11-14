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

    public Thread addThread(String threadName, Post post, User user) {
        Thread thread = new Thread(threadName, this, post, user);
        threads.add(thread);
        return thread;
    }

    public void remove(Long threadId, Long postId) {
            getThreadById(threadId).removePost(postId);
    }

    public Post updatePost(Long threadId, Post updatedPost) {
        return getThreadById(threadId).updatePost(updatedPost);
    }

    public List<Post> findPostsFromThread(Long threadId) {
        return findThreadById(threadId)
                .map(Thread::getPosts)
                .orElse(Collections.emptyList());
    }

    public Optional<Thread> findThreadById(Long threadId) {
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

    public Optional<Post> findPostsFromThread(Long threadId, Long postId) {
        return findThreadById(threadId).flatMap(thread -> thread.findPostById(postId));
    }
}
