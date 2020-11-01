package com.impaqgroup.training.architecture.hexagonalarchitecture.restprimaryport.converters;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.CurrentUserFactor;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Post;
import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static com.impaqgroup.training.architecture.hexagonalarchitecture.model.Post.createNewPost;
import static com.impaqgroup.training.architecture.hexagonalarchitecture.model.Post.reconstructExistingPost;

@Component
@RequiredArgsConstructor
class DtoPostConverter implements Converter<PostDto, Post> {

    private final CurrentUserFactor currentUserFactor;

    @Override
    public Post convert(PostDto postDto) {
        return postDto.isUserIdPresent() ?
                reconstructExistingPost(postDto.getPostId(), postDto.getTitle(), postDto.getContent()) :
                createNewPost(postDto.getTitle(), postDto.getContent(), currentUserFactor.getLoggedUser());
    }
}
