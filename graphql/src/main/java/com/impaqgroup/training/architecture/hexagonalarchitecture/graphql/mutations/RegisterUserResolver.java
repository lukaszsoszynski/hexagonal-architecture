package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.GraphUserService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphRegisterUserRequest;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class RegisterUserResolver implements GraphQLMutationResolver {

    private final GraphUserService graphUserService;

    public GraphUserDto registerUser(GraphRegisterUserRequest request){
        return graphUserService.registerUser(request);
    }
}
