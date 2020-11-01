package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.primaryadapter;

import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.GraphForumService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphForumDto;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.ForumService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
class GraphForumPrimaryAdapter implements GraphForumService {

    private final ForumService forumService;

    private final ConversionService conversionService;

    @Override
    @Transactional(readOnly = true)
    public List<GraphForumDto> listSubForums() {
        return forumService
                .listAllForums()
                .stream()
                .map(forum -> conversionService.convert(forum, GraphForumDto.class))
                .collect(toList());
    }
}
