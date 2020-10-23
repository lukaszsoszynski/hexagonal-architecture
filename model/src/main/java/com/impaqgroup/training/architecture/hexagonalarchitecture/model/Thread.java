package com.impaqgroup.training.architecture.hexagonalarchitecture.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Thread {

    private Long id;

    private String threadName;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.PACKAGE)
    private Forum forum;

    @Getter
    private List<Post> posts;
}
