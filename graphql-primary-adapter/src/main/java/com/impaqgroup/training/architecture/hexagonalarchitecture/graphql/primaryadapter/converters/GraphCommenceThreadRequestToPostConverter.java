package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.primaryadapter.converters;

import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphCommenceThreadRequest;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.CurrentUserFactor;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static com.impaqgroup.training.architecture.hexagonalarchitecture.model.Post.createNewPost;

@Component
@RequiredArgsConstructor
class GraphCommenceThreadRequestToPostConverter implements Converter<GraphCommenceThreadRequest, Post> {

    private final CurrentUserFactor currentUserFactor;

    @Override
    public Post convert(GraphCommenceThreadRequest source) {
        return createNewPost(source.getPostTitle(), source.getPostContent(), currentUserFactor.getLoggedUser());
    }
}
