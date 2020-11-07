package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.primaryadapter;

import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.GraphUserService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphUserDto;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.ForumModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
class UserPrimaryAdapter implements GraphUserService {

    private final ForumModelService forumModelService;

    private final ConversionService conversionService;

    @Override
    public Optional<GraphUserDto> findUserByEmail(String email) {
        return forumModelService
                .findUserByEmail(email)
                .map(user -> conversionService.convert(user, GraphUserDto.class));
    }
}
