package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphUserDto;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class FindUserByEmailResolver implements GraphQLQueryResolver {

    private final GraphUserService graphUserService;

    public GraphUserDto findUserByEmail(String email, DataFetchingEnvironment environment) {
        return graphUserService
                .findUserByEmail(email)
                .orElse(null);
    }
}
