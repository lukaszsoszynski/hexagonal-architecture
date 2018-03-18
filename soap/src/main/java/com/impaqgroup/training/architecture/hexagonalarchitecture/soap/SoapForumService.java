package com.impaqgroup.training.architecture.hexagonalarchitecture.soap;

public interface SoapForumService {

    GetAllPostResponse getAllPost(GetAllPostRequest getAllPostRequest);

    void createPost(PostType createPostRequest);

    void removePost(RemovePostRequest removePostRequest);

    void updatePost(PersistentPostType updatePostRequest);

}
