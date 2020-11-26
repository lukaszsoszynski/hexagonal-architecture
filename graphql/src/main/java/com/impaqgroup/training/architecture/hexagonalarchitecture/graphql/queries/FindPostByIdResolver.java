package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.queries;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.GraphPostService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphPostDto;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class FindPostByIdResolver implements GraphQLQueryResolver {

    private final GraphPostService graphPostService;

    public GraphPostDto findPostById(String forumName, Long threadId, Long postId, DataFetchingEnvironment environment) {
        //DataFetchingEnvironment can be omitted
        return graphPostService.findPostById(forumName, threadId, postId).orElse(null);
    }
}
