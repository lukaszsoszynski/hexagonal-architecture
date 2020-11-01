package com.impaqgroup.training.architecture.hexagonalarchitecture.soapprimaryadapter.converter;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.User;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.xml.datatype.XMLGregorianCalendar;

@Component
@RequiredArgsConstructor
class ModelUserToSoapUserConverter implements Converter<User, com.impaqgroup.training.architecture.hexagonalarchitecture.soap.User> {

    private final ConversionService conversionService;

    @Override
    @SneakyThrows
    public com.impaqgroup.training.architecture.hexagonalarchitecture.soap.User convert(User user) {
        com.impaqgroup.training.architecture.hexagonalarchitecture.soap.User result = new com.impaqgroup.training.architecture.hexagonalarchitecture.soap.User();
        result.setEmail(user.getEmail());
        result.setFirstName(user.getFirstName());
        result.setSurname(user.getLastName());
        result.setDateOfBirth(conversionService.convert(user.getDateOfBirth(), XMLGregorianCalendar.class));
        result.setRegistrationDate(conversionService.convert(user.getRegisteredDate(), XMLGregorianCalendar.class));
        return result;
    }
}
