package com.impaqgroup.training.architecture.hexagonalarchitecture.restprimaryport;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.ForumService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.User;
import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.RestUserService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserPrimaryAdapter implements RestUserService {

    private final ForumService forumService;
    private final ConversionService conversionService;

    @Override
    @Transactional
    public void createUser(UserDto userDto) {
        forumService.registerUser(conversionService.convert(userDto, User.class));
    }
}
