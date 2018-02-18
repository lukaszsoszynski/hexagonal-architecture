package com.impaqgroup.training.architecture.hexagonalarchitecture.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Forum;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Post;
import com.impaqgroup.training.architecture.hexagonalarchitecture.repository.ForumRepository;
import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.PostDto;

@Service
public class PostService {

    private final ForumRepository forumRepository;

    private final ConversionService conversionService;

    @Autowired
    public PostService(ForumRepository forumRepository, ConversionService conversionService) {
        this.forumRepository = forumRepository;
        this.conversionService = conversionService;
    }

    @Transactional
    public void create(PostDto postDto) {
        Post post = conversionService.convert(postDto, Post.class);
        Forum forum = forumRepository.getOne(postDto.getForumName());
        forum.addPost(post);
    }

    @Transactional(readOnly = true)
    public List<PostDto> findAll(String forum) {
        return forumRepository
                .getOne(forum)
                .getPosts()
                .stream()
                .map(post -> conversionService.convert(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public void remove(String forumName, Long postId) {
        Forum forum = forumRepository.getOne(forumName);
        forum.remove(postId);
    }

    @Transactional
    public void update(PostDto postDto) {
        Forum forum = forumRepository.getOne(Objects.requireNonNull(postDto.getForumName()));
        forum.updatePost(postDto.getPostId(), postDto.getTitle(), postDto.getContent());
    }
}
