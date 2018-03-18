package com.impaqgroup.training.architecture.hexagonalarchitecture.service.rest.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Post;
import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.PostDto;

@Component
class DtoPostConverter implements Converter<PostDto, Post> {

    @Override
    public Post convert(PostDto postDto) {
        return new Post(postDto.getPostId(), postDto.getTitle(), postDto.getContent());
    }
}
