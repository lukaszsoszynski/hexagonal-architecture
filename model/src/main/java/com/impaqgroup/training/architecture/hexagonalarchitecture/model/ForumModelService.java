package com.impaqgroup.training.architecture.hexagonalarchitecture.model;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.notification.NotificationSender;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.repository.ForumDao;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.repository.UserDao;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.stereotype.OutputPort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import static com.impaqgroup.training.architecture.hexagonalarchitecture.model.notification.ForumNotification.*;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

@RequiredArgsConstructor
@OutputPort
public class ForumModelService implements ForumService {

    private final ForumDao forumDao;

    private final UserDao userDao;

    private final NotificationSender notificationSender;

    private final CurrentUserFactor currentUserFactor;


    @Override
    public List<Forum> listAllForums() {
        return forumDao.findAll();
    }

    @Override
    public void commenceThread(String forumName, String threadName, Post post) {
        Forum forum = forumDao.findForumByName(forumName);
        forum.addThread(threadName, post, currentUserFactor.getLoggedUser());
        notificationSender.sendNotification(postAdded(forumName));
    }

    @Override
    public List<Thread> listThreadsInForum(String forumName) {
        Forum forum = forumDao.findForumByName(forumName);
        return forum.getThreads();
    }

    @Override
    public void create(String forumName, Long threadId, Post post) {
        Forum forum = forumDao.findForumByName(forumName);
        forum.appendPostToThread(threadId, post);
        notificationSender.sendNotification(postAdded(forumName));
    }

    @Override
    public List<Post> findAll(String forum, Long threadId) {
        return forumDao
                .findForumByName(requireNonNull(forum, "Forum name is mandatory"))
                .getPostsFromThread(requireNonNull(threadId, "Thread id is mandatory"));
    }

    @Override
    public void remove(String forumName, Long threadId, Long postId) {
        Forum forum = forumDao.findForumByName(forumName);
        forum.remove(threadId, postId);
        notificationSender.sendNotification(postRemoved(forumName));
    }

    @Override
    public void update(String forumName, Long threadId, Post post) {
        Forum forum = forumDao.findForumByName(requireNonNull(forumName));
        forum.updatePost(threadId, post);
        notificationSender.sendNotification(postUpdated(forumName));
    }

    @Override
    public void registerUser(User user) {
        String email = user.getEmail();
        userDao.findByEmail(email).ifPresent(this::throwUserAlreadyExists);
        userDao.create(user);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userDao.findByEmail(requireNonNull(email, "Cannot search for user by null email"));
    }

    @Override
    public Optional<Thread> findThread(Long threadId) {
        return forumDao
                .findForumByThreadId(threadId)
                .flatMap(forum -> forum.findThreadById(threadId));
    }

    private void throwUserAlreadyExists(User user){
        throw new ForumException(format("User with email '%s' already exists", user.getEmail()));
    }
}
