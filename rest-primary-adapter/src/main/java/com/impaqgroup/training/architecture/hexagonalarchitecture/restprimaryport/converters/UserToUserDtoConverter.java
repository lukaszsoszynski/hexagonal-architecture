package com.impaqgroup.training.architecture.hexagonalarchitecture.restprimaryport.converters;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.User;
import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.RestUserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class UserToUserDtoConverter implements Converter<User, RestUserDto> {
    @Override
    public RestUserDto convert(User user) {
        return new RestUserDto(user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                null,
                user.getDateOfBirth(),
                user.getRegisteredDate());
    }
}
