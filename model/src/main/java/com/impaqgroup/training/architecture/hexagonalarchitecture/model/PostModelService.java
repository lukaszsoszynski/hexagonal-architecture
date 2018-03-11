package com.impaqgroup.training.architecture.hexagonalarchitecture.model;

import static com.impaqgroup.training.architecture.hexagonalarchitecture.model.notification.ForumNotification.*;
import static java.util.Objects.requireNonNull;

import java.util.List;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.notification.NotificationSender;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.repository.ForumDao;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.stereotype.OutputPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@OutputPort
class PostModelService implements PostService {

    private final ForumDao forumRepository;

    private final NotificationSender notificationSender;

    @Override
    public void create(String forumName, Post post) {
        Forum forum = forumRepository.findForumByName(forumName);
        forum.addPost(post);
        notificationSender.sendNotification(postAdded(forumName));
    }

    @Override
    public List<Post> findAll(String forum) {
        return forumRepository
                .findForumByName(forum)
                .getPosts();
    }

    @Override
    public void remove(String forumName, Long postId) {
        Forum forum = forumRepository.findForumByName(forumName);
        forum.remove(postId);
        notificationSender.sendNotification(postRemoved(forumName));
    }

    @Override
    public void update(String forumName, Post post) {
        Forum forum = forumRepository.findForumByName(requireNonNull(forumName));
        forum.updatePost(post);
        notificationSender.sendNotification(postUpdated(forumName));
    }

}
