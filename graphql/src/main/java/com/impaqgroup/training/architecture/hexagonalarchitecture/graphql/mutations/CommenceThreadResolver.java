package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.GraphThreadService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphCommenceThreadRequest;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphThreadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class CommenceThreadResolver implements GraphQLMutationResolver {

    private final GraphThreadService graphThreadService;

    public GraphThreadDto commenceThread(GraphCommenceThreadRequest request) {
        return graphThreadService.commenceThread(request).get();
    }

}
