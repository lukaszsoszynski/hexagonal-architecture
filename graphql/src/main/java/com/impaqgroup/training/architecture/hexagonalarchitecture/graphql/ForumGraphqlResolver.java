package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphForumDto;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ForumGraphqlResolver implements GraphQLQueryResolver {

    private final GraphForumService graphForumService;

    public List<GraphForumDto> listSubForums(DataFetchingEnvironment environment) {
        return graphForumService.listSubForums();
    }
}