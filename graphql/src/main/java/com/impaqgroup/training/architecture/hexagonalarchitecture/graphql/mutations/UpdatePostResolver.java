package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.GraphPostService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphPostDto;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphUpdatePostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class UpdatePostResolver implements GraphQLMutationResolver {

    private final GraphPostService graphPostService;

    public GraphPostDto updatePost(GraphUpdatePostRequest updatePostRequest){
        return graphPostService.updatePost(updatePostRequest).get();
    }
}
