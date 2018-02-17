package com.impaqgroup.training.architecture.hexagonalarchitecture.model;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    public static final String POST_SEQUENCE_GENERATOR = "post_sequence_generator";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = POST_SEQUENCE_GENERATOR)
    @SequenceGenerator(name = POST_SEQUENCE_GENERATOR, sequenceName = "seq_post", allocationSize = 1, initialValue = 1000)
    private Long id;

    private String title;

    private String content;
}
