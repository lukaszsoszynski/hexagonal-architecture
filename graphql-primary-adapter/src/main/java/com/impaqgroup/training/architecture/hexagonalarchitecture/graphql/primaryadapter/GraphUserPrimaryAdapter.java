package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.primaryadapter;

import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.GraphUserService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphRegisterUserRequest;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphUserDto;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.ForumModelService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@RequiredArgsConstructor
class GraphUserPrimaryAdapter implements GraphUserService {

    private final ForumModelService forumModelService;

    private final ConversionService conversionService;

    @Override
    @Transactional(readOnly = true)
    public Optional<GraphUserDto> findUserByEmail(String email) {
        return forumModelService
                .findUserByEmail(email)
                .map(user -> conversionService.convert(user, GraphUserDto.class));
    }

    @Override
    @Transactional
    public GraphUserDto registerUser(GraphRegisterUserRequest request) {
        forumModelService.registerUser(conversionService.convert(request, User.class));
        return conversionService.convert(forumModelService.findUserByEmail(request.getEmail()).orElse(null), GraphUserDto.class);
    }
}
