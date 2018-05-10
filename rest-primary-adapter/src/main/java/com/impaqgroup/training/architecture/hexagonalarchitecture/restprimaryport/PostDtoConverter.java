package com.impaqgroup.training.architecture.hexagonalarchitecture.restprimaryport;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Post;
import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.PostDto;

@Component
public class PostDtoConverter implements Converter<Post, PostDto> {

    @Override
    public PostDto convert(Post post) {
        return new PostDto(post.getId(), post.getForumName(), post.getTitle(), post.getContent());
    }
}
