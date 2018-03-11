package com.impaqgroup.training.architecture.hexagonalarchitecture.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Post;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.PostService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.RestPostService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.PostDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostApplicationService implements RestPostService{

    private final PostService postService;

    private final ConversionService conversionService;

    @Transactional
    public void create(PostDto postDto) {
        Post post = conversionService.convert(postDto, Post.class);
        postService.create(postDto.getForumName(), post);
    }

    @Transactional(readOnly = true)
    public List<PostDto> findAll(String forum) {
        return postService.findAll(forum)
                .stream()
                .map(post -> conversionService.convert(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public void remove(String forumName, Long postId) {
        postService.remove(forumName, postId);
    }

    @Transactional
    public void update(PostDto postDto) {
        Post post = conversionService.convert(postDto, Post.class);
        postService.update(postDto.getForumName(), post);
    }
}
