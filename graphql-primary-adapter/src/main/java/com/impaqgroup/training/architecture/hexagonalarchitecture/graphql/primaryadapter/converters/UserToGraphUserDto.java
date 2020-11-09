package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.primaryadapter.converters;

import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphPostDto;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphThreadDto;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphUserDto;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class UserToGraphUserDto implements Converter<User, GraphUserDto> {

    private final ConversionService conversionService;

    @Override
    public GraphUserDto convert(User user) {
        return new GraphUserDto(user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getRegisteredDate(),
                user.getDateOfBirth(),
                user.getCreatedThreads().stream().map(thread -> conversionService.convert(thread, GraphThreadDto.class)),
                user.getAuthorOfPosts().stream().map(post -> conversionService.convert(post, GraphPostDto.class)));
    }
}
