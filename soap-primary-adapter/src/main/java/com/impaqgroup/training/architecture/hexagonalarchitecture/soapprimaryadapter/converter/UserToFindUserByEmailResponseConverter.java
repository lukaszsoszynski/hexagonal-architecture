package com.impaqgroup.training.architecture.hexagonalarchitecture.soapprimaryadapter.converter;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.User;
import com.impaqgroup.training.architecture.hexagonalarchitecture.soap.FindUserByEmailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class UserToFindUserByEmailResponseConverter implements Converter<User, FindUserByEmailResponse> {

    private final ConversionService conversionService;

    @Override
    public FindUserByEmailResponse convert(User user) {
        FindUserByEmailResponse findUserByEmailResponse = new FindUserByEmailResponse();
        findUserByEmailResponse.setUser(
                conversionService.convert(
                        user, com.impaqgroup.training.architecture.hexagonalarchitecture.soap.User.class));
        return findUserByEmailResponse;
    }
}
