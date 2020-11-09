package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.primaryadapter.converters;

import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphCreateNewPostRequest;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.CurrentUserFactor;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static com.impaqgroup.training.architecture.hexagonalarchitecture.model.Post.createNewPost;

@Component
@RequiredArgsConstructor
public class GraphCreateNewPostRequestToPostConverter implements Converter<GraphCreateNewPostRequest, Post> {

    private final CurrentUserFactor currentUserFactor;

    @Override
    public Post convert(GraphCreateNewPostRequest request) {
        return createNewPost(request.getTitle(), request.getContent(), currentUserFactor.getLoggedUser());
    }
}
