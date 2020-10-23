package com.impaqgroup.training.architecture.hexagonalarchitecture.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Forum {

    @Getter
    private String name;

    private String title;

    @Getter
    private List<Thread> threads;

    public void addPost(Post post) {
//        requireNonNull(post).setForum(this);
//        posts.add(post);
    }

    public void remove(Long postId) {
//        posts.removeIf(post -> post.hasId(postId));
    }

    public void updatePost(Post updatedPost) {
//        posts
//                .stream()
//                .filter(post -> post.hasId(updatedPost.getId()))
//                .findAny()
//                .ifPresent(post -> post.update(updatedPost));
    }
}
