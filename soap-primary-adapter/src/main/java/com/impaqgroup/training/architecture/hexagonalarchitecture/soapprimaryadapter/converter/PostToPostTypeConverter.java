package com.impaqgroup.training.architecture.hexagonalarchitecture.soapprimaryadapter.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Post;
import com.impaqgroup.training.architecture.hexagonalarchitecture.soap.PostType;

@Component
class PostToPostTypeConverter implements Converter<Post, PostType>{

    @Override
    public PostType convert(Post post) {
        PostType postType = new PostType();
        postType.setContent(post.getContent());
        postType.setForumName(post.getForumName());
        postType.setTitle(post.getTitle());
        return postType;
    }
}
