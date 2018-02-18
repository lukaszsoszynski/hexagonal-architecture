package com.impaqgroup.training.architecture.hexagonalarchitecture.model;

import java.util.Objects;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Post {

    public static final String POST_SEQUENCE_GENERATOR = "post_sequence_generator";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = POST_SEQUENCE_GENERATOR)
    @SequenceGenerator(name = POST_SEQUENCE_GENERATOR, sequenceName = "seq_post", allocationSize = 1, initialValue = 1000)
    private Long id;

    private String title;

    private String content;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.PACKAGE)
    @ManyToOne
    @JoinColumn(name = "forum_name", updatable = false, nullable = false)
    private Forum forum;

    public Post(String title, String content){
        this.title = Objects.requireNonNull(title);
        this.content = Objects.requireNonNull(content);
    }

    public boolean hasId(Long postId){
        return id.equals(postId);
    }

    public void update(String title, String content) {
        this.title = Objects.requireNonNull(title);
        this.content = Objects.requireNonNull(content);
    }

    public String getForumName(){
        return forum.getName();
    }
}
