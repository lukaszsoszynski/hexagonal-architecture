package com.impaqgroup.training.architecture.hexagonalarchitecture.install.security;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.CurrentUserFactor;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static org.springframework.security.core.context.SecurityContextHolder.getContext;

@Component
class SpringSecurityCurrentUserFactory implements CurrentUserFactor {

    @Override
    public Optional<User> findLoggedUser() {
        return Optional.ofNullable(getContext())
                .map(SecurityContext::getAuthentication)
                .map(Authentication::getPrincipal)
                .filter(ForumUserDetails.class::isInstance)
                .map(ForumUserDetails.class::cast)
                .map(ForumUserDetails::getUser);
    }
}
