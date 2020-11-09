package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.primaryadapter.converters;

import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphRegisterUserRequest;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;

@Component
public class GraphRegisterUserRequestToUserConverter implements Converter<GraphRegisterUserRequest, User> {

    @Override
    public User convert(GraphRegisterUserRequest source) {
        LocalDateTime dateOfBirth = LocalDateTime.parse(source.getDateOfBirth(), ISO_DATE_TIME);
        return User
                .createNewUser(source.getEmail(),
                        source.getFirstName(),
                        source.getSurname(),
                        source.getPassword(),
                        dateOfBirth);
    }
}
