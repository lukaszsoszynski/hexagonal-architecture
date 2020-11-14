package com.impaqgroup.training.architecture.hexagonalarchitecture.restprimaryport;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.ForumService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.User;
import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.RestUserService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.RestUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestUserPrimaryAdapter implements RestUserService {

    private final ForumService forumService;
    private final ConversionService conversionService;

    @Override
    @Transactional
    public void createUser(RestUserDto userDto) {
        forumService.registerUser(conversionService.convert(userDto, User.class));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<RestUserDto> findUserByEmail(String email) {
        return forumService.findUserByEmail(email)
                .map(user -> conversionService.convert(user, RestUserDto.class));
    }
}