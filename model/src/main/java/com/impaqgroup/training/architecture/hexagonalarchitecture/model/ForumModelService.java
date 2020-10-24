package com.impaqgroup.training.architecture.hexagonalarchitecture.model;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.notification.NotificationSender;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.repository.ForumDao;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.stereotype.OutputPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.impaqgroup.training.architecture.hexagonalarchitecture.model.notification.ForumNotification.*;
import static java.util.Objects.requireNonNull;

@RequiredArgsConstructor
@OutputPort
public class ForumModelService implements ForumService {

    private final ForumDao forumRepository;

    private final NotificationSender notificationSender;


    @Override
    public void commenceThread(String forumName, String threadName, Post post) {
        Forum forum = forumRepository.findForumByName(forumName);
        forum.addThread(threadName, post);
        notificationSender.sendNotification(postAdded(forumName));
    }

    @Override
    public List<Thread> listThreadsInForum(String forumName) {
        Forum forum = forumRepository.findForumByName(forumName);
        return forum.getThreads();
    }

    @Override
    public void create(String forumName, Long threadId, Post post) {
        Forum forum = forumRepository.findForumByName(forumName);
        forum.appendPostToThread(threadId, post);
        notificationSender.sendNotification(postAdded(forumName));
    }

    @Override
    public List<Post> findAll(String forum, Long threadId) {
        return forumRepository
                .findForumByName(requireNonNull(forum, "Forum name is mandatory"))
                .getPostsFromThread(requireNonNull(threadId, "Thread id is mandatory"));
    }

    @Override
    public void remove(String forumName, Long threadId, Long postId) {
        Forum forum = forumRepository.findForumByName(forumName);
        forum.remove(threadId, postId);
        notificationSender.sendNotification(postRemoved(forumName));
    }

    @Override
    public void update(String forumName, Long threadId, Post post) {
        Forum forum = forumRepository.findForumByName(requireNonNull(forumName));
        forum.updatePost(threadId, post);
        notificationSender.sendNotification(postUpdated(forumName));
    }

}
