package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.primaryadapter;

import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.GraphThreadService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphThreadDto;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.ForumService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
class ThreadPrimaryAdapter implements GraphThreadService {

    private final ForumService forumService;
    private final ConversionService conversionService;


    public Optional<GraphThreadDto> findThreadById(Long threadId) {
        return forumService
                .findThread(threadId)
                .map(thread -> conversionService.convert(thread, GraphThreadDto.class));
    }
}
