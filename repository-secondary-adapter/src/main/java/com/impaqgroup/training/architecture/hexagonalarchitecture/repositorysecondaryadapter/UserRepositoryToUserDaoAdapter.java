package com.impaqgroup.training.architecture.hexagonalarchitecture.repositorysecondaryadapter;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.User;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.repository.UserDao;
import com.impaqgroup.training.architecture.hexagonalarchitecture.repository.jpa.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static java.util.Objects.requireNonNull;

@RequiredArgsConstructor
@Repository
class UserRepositoryToUserDaoAdapter implements UserDao {

    private final UserRepository userRepository;

    @Override
    public void create(User user) {
        userRepository.save(requireNonNull(user, "Cannot store in db user which is null."));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findById(requireNonNull(email, "Cannot find user by null email."));
    }
}
