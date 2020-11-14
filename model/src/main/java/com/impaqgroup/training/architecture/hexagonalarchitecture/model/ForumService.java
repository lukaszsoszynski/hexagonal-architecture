package com.impaqgroup.training.architecture.hexagonalarchitecture.model;

import java.util.List;
import java.util.Optional;

public interface ForumService {

    List<Forum> listAllForums();

    Thread commenceThread(String forumName, String threadName, Post post);

    List<Thread> listThreadsInForum(String forumName);

    void create(String forumName, Long threadId, Post post);

    List<Post> findAll(String forum, Long threadId);

    Optional<Post> findPostById(String forum, Long threadId, Long postId);

    void remove(String forumName, Long threadId, Long postId);

    Post update(String forumName, Long threadId, Post post);

    void registerUser(User user);

    Optional<User> findUserByEmail(String email);

    Optional<Thread> findThread(Long threadId);
}
