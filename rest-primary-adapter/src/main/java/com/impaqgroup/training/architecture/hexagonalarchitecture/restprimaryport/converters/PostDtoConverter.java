package com.impaqgroup.training.architecture.hexagonalarchitecture.restprimaryport.converters;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Post;
import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.RestPostDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class PostDtoConverter implements Converter<Post, RestPostDto> {

    @Override
    public RestPostDto convert(Post post) {
        return new RestPostDto(post.getId(), post.getTitle(), post.getContent(), post.getAuthorEmail(), post.getThreadId());
    }
}
