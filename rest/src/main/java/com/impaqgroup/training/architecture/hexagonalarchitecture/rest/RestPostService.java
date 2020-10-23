package com.impaqgroup.training.architecture.hexagonalarchitecture.rest;

import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.PostDto;

import java.util.List;

public interface RestPostService {

    List<PostDto> listPostInForumAndThread(String forum, Long threadId);

    void create(String forum, Long threadId, PostDto postDto);

    void remove(String forum, Long threadId, Long postId);

    void update(String forum, Long threadId, PostDto postDto);
}
