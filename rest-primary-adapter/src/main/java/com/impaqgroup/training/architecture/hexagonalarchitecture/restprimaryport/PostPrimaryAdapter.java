package com.impaqgroup.training.architecture.hexagonalarchitecture.restprimaryport;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Post;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.ForumService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.RestPostService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostPrimaryAdapter implements RestPostService{

    private final ForumService forumService;

    private final ConversionService conversionService;

    @Transactional
    public void create(String forum, Long threadId, PostDto postDto) {
        Post post = conversionService.convert(postDto, Post.class);
        forumService.create(forum, threadId, post);
    }

    @Transactional(readOnly = true)
    public List<PostDto> listPostInForumAndThread(String forum, Long threadId) {
        return forumService.findAll(forum, threadId)
                .stream()
                .map(post -> conversionService.convert(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public void remove(String forumName, Long threadId, Long postId) {
        forumService.remove(forumName, threadId, postId);
    }

    @Transactional
    public void update(String forum, Long threadId, PostDto postDto) {
        Post post = conversionService.convert(postDto, Post.class);
        forumService.update(forum, threadId, post);
    }
}
