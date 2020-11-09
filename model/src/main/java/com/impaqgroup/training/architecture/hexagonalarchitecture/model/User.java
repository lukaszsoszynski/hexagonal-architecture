package com.impaqgroup.training.architecture.hexagonalarchitecture.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static lombok.AccessLevel.NONE;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class User {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private LocalDateTime registeredDate;
    private LocalDateTime dateOfBirth;
    @Getter(NONE)
    private List<Thread> createdThreads;
    @Getter(NONE)
    private List<Post> authorOfPosts;

    public static User createNewUser(@NonNull String email,
                                     String firstName,
                                     String lastName,
                                     @NonNull String password,
                                     LocalDateTime dateOfBirth) {
        return new User(email, firstName, lastName, password, LocalDateTime.now(), dateOfBirth, null, null);
    }

    public List<Thread> getCreatedThreads() {
        return notNullableList(createdThreads);
    }

    public List<Post> getAuthorOfPosts() {
        return notNullableList(authorOfPosts);
    }

    private <T> List<T> notNullableList(List<T> list) {
        return Optional
                .ofNullable(list)
                .orElse(new ArrayList<>());
    }
}
