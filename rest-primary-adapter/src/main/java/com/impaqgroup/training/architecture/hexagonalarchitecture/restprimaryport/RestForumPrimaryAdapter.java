package com.impaqgroup.training.architecture.hexagonalarchitecture.restprimaryport;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.ForumService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.RestForumService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.RestSubForumDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
class RestForumPrimaryAdapter implements RestForumService {

    private final ForumService forumService;
    private final ConversionService conversionService;

    @Override
    @Transactional(readOnly = true)
    public List<RestSubForumDto> listAllSubForums() {
        return forumService
                .listAllForums()
                .stream()
                .map(forum -> conversionService.convert(forum, RestSubForumDto.class))
                .collect(Collectors.toList());
    }
}
