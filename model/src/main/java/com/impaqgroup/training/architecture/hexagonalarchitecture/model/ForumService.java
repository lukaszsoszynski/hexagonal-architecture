package com.impaqgroup.training.architecture.hexagonalarchitecture.model;

import java.util.List;

public interface ForumService {

    void commenceThread(String forumName, String threadName, Post post);

    List<Thread> listThreadsInForum(String forumName);

    void create(String forumName, Long threadId, Post post);

    List<Post> findAll(String forum, Long threadId);

    void remove(String forumName, Long threadId, Long postId);

    void update(String forumName, Long threadId, Post post);
}
