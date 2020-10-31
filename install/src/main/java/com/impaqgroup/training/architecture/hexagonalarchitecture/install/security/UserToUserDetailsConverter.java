package com.impaqgroup.training.architecture.hexagonalarchitecture.install.security;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
class UserToUserDetailsConverter implements Converter<User, UserDetails> {

    @Override
    public UserDetails convert(User user) {
        return new ForumUserDetails(user);
    }
}
