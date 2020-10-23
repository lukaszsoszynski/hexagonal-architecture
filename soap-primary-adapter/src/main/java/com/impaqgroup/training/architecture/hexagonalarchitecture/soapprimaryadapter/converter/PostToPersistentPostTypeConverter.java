package com.impaqgroup.training.architecture.hexagonalarchitecture.soapprimaryadapter.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Post;
import com.impaqgroup.training.architecture.hexagonalarchitecture.soap.PersistentPostType;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class PostToPersistentPostTypeConverter implements Converter<Post, PersistentPostType>{

    @Override
    public PersistentPostType convert(Post post) {
        PersistentPostType persistentPostType = new PersistentPostType();
        persistentPostType.setContent(post.getContent());
//        persistentPostType.setForumName(post.getForumName());
        persistentPostType.setTitle(post.getTitle());
        persistentPostType.setPostId(post.getId());
        return persistentPostType;
    }
}
