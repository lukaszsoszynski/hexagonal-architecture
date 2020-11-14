package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.primaryadapter.converters;

import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphUpdatePostRequest;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Post;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class UpdatePostRequestToPostConverter implements Converter<GraphUpdatePostRequest, Post> {
    @Override
    public Post convert(GraphUpdatePostRequest request) {
        return Post.reconstructExistingPost(request.getPostId(), request.getTitle(), request.getContent());
    }
}
