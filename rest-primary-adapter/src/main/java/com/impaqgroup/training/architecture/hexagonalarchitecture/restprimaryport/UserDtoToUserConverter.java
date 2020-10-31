package com.impaqgroup.training.architecture.hexagonalarchitecture.restprimaryport;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.User;
import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.UserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static com.impaqgroup.training.architecture.hexagonalarchitecture.model.User.createNewUser;

@Component
public class UserDtoToUserConverter implements Converter<UserDto, User> {
    @Override
    public User convert(UserDto userDto) {
        return createNewUser(userDto.getEmail(),
                userDto.getFirstName(),
                userDto.getSurname(),
                userDto.getPassword(),
                userDto.getDateOfBirth());
    }
}
