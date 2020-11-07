package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphThreadDto;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class FindThreadByIdResolver implements GraphQLQueryResolver {

    private final GraphThreadService threadForumService;

    public GraphThreadDto findThreadById(Long threadId, DataFetchingEnvironment environment) {
        return threadForumService
                .findThreadById(threadId)
                .orElse(null);
    }
}
