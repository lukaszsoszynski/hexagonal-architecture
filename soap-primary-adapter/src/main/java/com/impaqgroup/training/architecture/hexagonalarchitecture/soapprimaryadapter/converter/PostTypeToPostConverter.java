package com.impaqgroup.training.architecture.hexagonalarchitecture.soapprimaryadapter.converter;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.CurrentUserFactor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Post;
import com.impaqgroup.training.architecture.hexagonalarchitecture.soap.PersistentPostType;
import com.impaqgroup.training.architecture.hexagonalarchitecture.soap.PostType;

@Component
class PostTypeToPostConverter implements Converter<PostType, Post>{

    CurrentUserFactor currentUserFactor;

    @Override
    public Post convert(PostType postType) {
        if(postType instanceof PersistentPostType){
            PersistentPostType persistentPostType = (PersistentPostType) postType;
            Long id = persistentPostType.getPostId();
            return Post.reconstructExistingPost(id, postType.getTitle(), postType.getContent());
        }
        return Post.createNewPost(postType.getTitle(), postType.getContent(), currentUserFactor.getLoggedUser());
    }
}
