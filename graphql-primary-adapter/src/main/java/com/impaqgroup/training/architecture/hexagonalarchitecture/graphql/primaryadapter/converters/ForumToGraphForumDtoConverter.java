package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.primaryadapter.converters;

import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphForumDto;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphThreadDto;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Forum;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
class ForumToGraphForumDtoConverter implements Converter<Forum, GraphForumDto> {

    private final ConversionService conversionService;

    @Override
    public GraphForumDto convert(Forum forum) {
        Stream<GraphThreadDto> threads = forum
                .getThreads()
                .stream()
                .map(thread -> conversionService.convert(thread, GraphThreadDto.class));
        return new GraphForumDto(forum.getName(), forum.getTitle(), threads);
    }
}
