package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.GraphPostService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphCreateNewPostRequest;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphPostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class CreateNewPostResolver implements GraphQLMutationResolver {

    private final GraphPostService graphPostService;

    public GraphPostDto createNewPost(GraphCreateNewPostRequest request) {
        return graphPostService.createNewPost(request).get();
    }
}
