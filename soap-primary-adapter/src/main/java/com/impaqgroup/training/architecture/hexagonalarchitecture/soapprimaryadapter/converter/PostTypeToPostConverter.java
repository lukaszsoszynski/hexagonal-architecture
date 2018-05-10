package com.impaqgroup.training.architecture.hexagonalarchitecture.soapprimaryadapter.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Post;
import com.impaqgroup.training.architecture.hexagonalarchitecture.soap.PersistentPostType;
import com.impaqgroup.training.architecture.hexagonalarchitecture.soap.PostType;

@Component
class PostTypeToPostConverter implements Converter<PostType, Post>{

    @Override
    public Post convert(PostType postType) {
        Long id = null;
        if(postType instanceof PersistentPostType){
            PersistentPostType persistentPostType = (PersistentPostType) postType;
            id = persistentPostType.getPostId();
        }
        return new Post(id, postType.getTitle(), postType.getContent());
    }
}
