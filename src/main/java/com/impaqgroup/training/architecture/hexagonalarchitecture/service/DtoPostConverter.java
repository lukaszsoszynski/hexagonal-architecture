package com.impaqgroup.training.architecture.hexagonalarchitecture.service;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Post;
import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.PostDto;

@Component
public class DtoPostConverter implements Converter<PostDto, Post> {

    @Override
    public Post convert(PostDto postDto) {
        return new Post(postDto.getTitle(), postDto.getContent());
    }
}
