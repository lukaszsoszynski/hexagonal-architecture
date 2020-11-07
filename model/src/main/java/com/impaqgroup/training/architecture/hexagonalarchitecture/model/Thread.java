package com.impaqgroup.training.architecture.hexagonalarchitecture.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Thread {

    private Long id;

    private String threadName;

    @Setter(AccessLevel.PACKAGE)
    private Forum forum;

    @Getter
    @Setter(AccessLevel.PACKAGE)
    private User creator;

    @Getter
    private List<Post> posts;

    Thread(String name, Forum forum, Post post, User creator){
        this.threadName = requireNonNull(name, "Thread name is mandatory");
        this.forum = requireNonNull(forum, "Thread must be assigned to forum");
        this.creator = requireNonNull(creator, "Thread creator is required");
        this.posts = new ArrayList<>();
        posts.add(requireNonNull(post, "New thread have to contain one post"));
        post.setThread(this);
    }

    void appendPost(Post post) {
        posts.add(requireNonNull(post, "Cannot append null post to thread"));
        post.setThread(this);
    }

    public void updatePost(Post updatedPost) {
        getPost(requireNonNull(updatedPost, "Cannot update null post").getId()).update(updatedPost);
    }

    private Post getPost(Long postId) {
        return posts
                .stream()
                .filter(post -> post.containSameId(postId))
                .findAny()
                .orElseThrow(() -> new ForumException(String.format("Post with id %d not found.", postId)));
    }

    public void removePost(Long postId) {
        posts.removeIf(post -> post.containSameId(postId));
    }

    public String getCreatorEmail() {
        return creator.getEmail();
    }

    public String getForumName() {
        return forum.getName();
    }
}
