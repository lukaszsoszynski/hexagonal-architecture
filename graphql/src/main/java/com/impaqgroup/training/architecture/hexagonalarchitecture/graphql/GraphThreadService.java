package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql;

import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphCommenceThreadRequest;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphThreadDto;

import java.util.Optional;
import java.util.function.Supplier;

public interface GraphThreadService {
    Optional<GraphThreadDto> findThreadById(Long threadId);

    Supplier<GraphThreadDto> commenceThread(GraphCommenceThreadRequest request);
}
