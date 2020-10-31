package com.impaqgroup.training.architecture.hexagonalarchitecture.model;

import java.util.Optional;

@FunctionalInterface
public interface CurrentUserFactor {
    default User getLoggedUser() throws ForumException {
        return findLoggedUser().orElseThrow(() -> new ForumException("Current user is not available"));
    }
    Optional<User> findLoggedUser();
}
