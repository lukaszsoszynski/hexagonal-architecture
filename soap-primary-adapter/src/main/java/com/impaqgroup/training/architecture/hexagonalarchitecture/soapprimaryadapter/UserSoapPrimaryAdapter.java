package com.impaqgroup.training.architecture.hexagonalarchitecture.soapprimaryadapter;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.ForumService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.soap.FindUserByEmail;
import com.impaqgroup.training.architecture.hexagonalarchitecture.soap.FindUserByEmailResponse;
import com.impaqgroup.training.architecture.hexagonalarchitecture.soap.SoapUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
class UserSoapPrimaryAdapter implements SoapUserService {

    private final ForumService forumService;
    private final ConversionService conversionService;

    @Override
    public Optional<FindUserByEmailResponse> findUserByEmail(FindUserByEmail request) {
        return forumService
                .findUserByEmail(request.getEmail())
                .map(user -> conversionService.convert(user, FindUserByEmailResponse.class));
    }
}
