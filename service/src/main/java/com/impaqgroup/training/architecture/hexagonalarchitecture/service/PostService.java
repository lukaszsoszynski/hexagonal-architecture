package com.impaqgroup.training.architecture.hexagonalarchitecture.service;

import static com.impaqgroup.training.architecture.hexagonalarchitecture.notification.ForumNotification.postAdded;
import static com.impaqgroup.training.architecture.hexagonalarchitecture.notification.ForumNotification.postRemoved;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Forum;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Post;
import com.impaqgroup.training.architecture.hexagonalarchitecture.notification.ForumNotification;
import com.impaqgroup.training.architecture.hexagonalarchitecture.notification.NotificationSender;
import com.impaqgroup.training.architecture.hexagonalarchitecture.repository.ForumDao;
import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.RestPostService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.PostDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService implements RestPostService{

    private final ForumDao forumRepository;

    private final NotificationSender notificationSender;

    private final ConversionService conversionService;

    @Transactional
    public void create(PostDto postDto) {
        Post post = conversionService.convert(postDto, Post.class);
        Forum forum = forumRepository.findForumByName(postDto.getForumName());
        forum.addPost(post);
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void afterCommit() {
                notificationSender.sendNotification(postAdded(postDto.getForumName()));
            }
        });
    }

    @Transactional(readOnly = true)
    public List<PostDto> findAll(String forum) {
        return forumRepository
                .findForumByName(forum)
                .getPosts()
                .stream()
                .map(post -> conversionService.convert(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public void remove(String forumName, Long postId) {
        Forum forum = forumRepository.findForumByName(forumName);
        forum.remove(postId);
        notificationSender.sendNotification(postRemoved(forumName));
    }

    @Transactional
    public void update(PostDto postDto) {
        Forum forum = forumRepository.findForumByName(Objects.requireNonNull(postDto.getForumName()));
        forum.updatePost(postDto.getPostId(), postDto.getTitle(), postDto.getContent());
        notificationSender.sendNotification(ForumNotification.postUpdated(postDto.getForumName()));
    }
}
