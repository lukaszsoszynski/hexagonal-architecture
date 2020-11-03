package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.primaryadapter.converters;

import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphPostDto;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphUserDto;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class PostToGraphPostDtoConverter implements Converter<Post, GraphPostDto> {

    private final ConversionService conversionService;

    @Override
    public GraphPostDto convert(Post source) {
        return new GraphPostDto(source.getId(),
                source.getTitle(),
                source.getContent(),
                () -> conversionService.convert(source.getAuthor(), GraphUserDto.class));
    }
}
