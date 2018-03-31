package com.impaqgroup.training.architecture.hexagonalarchitecture.rest;

import java.util.List;

import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.PostDto;

public interface RestPostService {

    List<PostDto> findAll(String forum);

    void create(PostDto postDto);

    void remove(String forum, Long postId);

    void update(PostDto postDto);
}
