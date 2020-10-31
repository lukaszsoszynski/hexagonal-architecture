package com.impaqgroup.training.architecture.hexagonalarchitecture.model;

import lombok.*;

import static java.util.Objects.requireNonNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString(exclude = "forum")
public class Post {

//    public static final String POST_SEQUENCE_GENERATOR = "post_sequence_generator";

    private Long id;

    private String title;

    private String content;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.PACKAGE)
    private Thread thread;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.PACKAGE)
    private User author;

    public static Post reconstructExistingPost(Long id, String title, String content) {
        return new Post(requireNonNull(id, "Id is required for post reconstruction"),
                title,
                content,
                null);
    }

    public static Post createNewPost(String title, String content, User author) {
        return new Post(null, title, content, author);
    }


    private Post(Long id, String title, String content, User user) {
        this.id = id;
        this.title = requireNonNull(title, "Title for post is required.");
        this.content = requireNonNull(content, "Content for post is required.");
        this.author = user;
    }

    public boolean hasId(Long postId) {
        return id.equals(postId);
    }

    public void update(Post post) {
        this.title = requireNonNull(post.getTitle());
        this.content = requireNonNull(post.getContent());
    }

    public boolean containSameId(Long postId) {
        return (id != null) && id.equals(requireNonNull(postId, "Post id is null."));
    }

//    public String getForumName(){
//        return forum.getName();
//    }
}
