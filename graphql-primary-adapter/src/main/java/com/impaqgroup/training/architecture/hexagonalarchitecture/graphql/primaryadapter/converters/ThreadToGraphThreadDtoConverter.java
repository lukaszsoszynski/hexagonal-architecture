package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.primaryadapter.converters;

import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphForumDto;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphPostDto;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphThreadDto;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphUserDto;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Thread;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class ThreadToGraphThreadDtoConverter implements Converter<Thread, GraphThreadDto> {

    private final ConversionService conversionService;

    @Override
    public GraphThreadDto convert(Thread thread) {
        return new GraphThreadDto(thread.getId(),
                thread.getThreadName(),
                () -> conversionService.convert(thread.getCreator(), GraphUserDto.class),
                () -> conversionService.convert(thread.getForum(), GraphForumDto.class),
                thread
                        .getPosts()
                        .stream()
                        .map(post -> conversionService.convert(post, GraphPostDto.class)));
    }
}
