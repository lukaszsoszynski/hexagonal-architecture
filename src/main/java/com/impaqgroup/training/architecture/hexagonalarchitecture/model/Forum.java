package com.impaqgroup.training.architecture.hexagonalarchitecture.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Forum {

    @Getter
    private String name;

    private String title;

    @Getter
    private List<Post> posts;

    public void addPost(Post post) {
        requireNonNull(post).setForum(this);
        posts.add(post);
    }

    public void remove(Long postId) {
        posts.removeIf(post -> post.hasId(postId));
    }

    public void updatePost(Long postId, String title, String content) {
        posts
                .stream()
                .filter(post -> post.hasId(postId))
                .findAny()
                .ifPresent(post -> post.update(title, content));
    }
}
