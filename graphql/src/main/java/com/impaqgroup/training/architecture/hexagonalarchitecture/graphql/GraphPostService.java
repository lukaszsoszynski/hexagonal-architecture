package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql;

import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphCreateNewPostRequest;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphPostDto;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphUpdatePostRequest;

import java.util.Optional;
import java.util.function.Supplier;

public interface GraphPostService {
    Optional<GraphPostDto> findPostById(String forumName, Long threadId, Long postId);
    Supplier<GraphPostDto> createNewPost(GraphCreateNewPostRequest request);
    Supplier<GraphPostDto> updatePost(GraphUpdatePostRequest updatePostRequest);
}
