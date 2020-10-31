package com.impaqgroup.training.architecture.hexagonalarchitecture.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

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
    private List<Thread> createdThreads;
    private List<Post> authorOfPosts;

    public static User createNewUser(@NonNull String email,
                                     String firstName,
                                     String lastName,
                                     @NonNull String password,
                                     LocalDateTime dateOfBirth) {
        return new User(email, firstName, lastName, password, LocalDateTime.now(), dateOfBirth, null, null);
    }
}
