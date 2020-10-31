package com.impaqgroup.training.architecture.hexagonalarchitecture.install.security;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.repository.UserDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

//import org.springframework.core.convert.ConversionService;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
class ForumUserDetailService implements UserDetailsService {

    private final UserDao userDao;
    private final ConversionService conversionService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info("Loading user by email '{}'", email);
        return userDao
                .findByEmail(requireNonNull(email, "Email is required."))
                .map(user -> conversionService.convert(user, UserDetails.class))
                .orElseThrow(() -> new UsernameNotFoundException(format("User with email %s not found", email)));
    }
}
