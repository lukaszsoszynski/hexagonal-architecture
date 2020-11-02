package com.impaqgroup.training.architecture.hexagonalarchitecture.restprimaryport.converters;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.User;
import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.RestUserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static com.impaqgroup.training.architecture.hexagonalarchitecture.model.User.createNewUser;

@Component
class UserDtoToUserConverter implements Converter<RestUserDto, User> {
    @Override
    public User convert(RestUserDto userDto) {
        return createNewUser(userDto.getEmail(),
                userDto.getFirstName(),
                userDto.getSurname(),
                userDto.getPassword(),
                userDto.getDateOfBirth());
    }
}
