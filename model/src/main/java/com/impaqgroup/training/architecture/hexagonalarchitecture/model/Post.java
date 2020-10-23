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

    public Post(Long id, String title, String content){
        this.id = id;
        this.title = requireNonNull(title);
        this.content = requireNonNull(content);
    }

    public boolean hasId(Long postId){
        return id.equals(postId);
    }

    public void update(Post post) {
        this.title = requireNonNull(post.getTitle());
        this.content = requireNonNull(post.getContent());
    }

//    public String getForumName(){
//        return forum.getName();
//    }
}
