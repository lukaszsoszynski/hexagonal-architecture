package com.impaqgroup.training.architecture.hexagonalarchitecture.soapprimaryadapter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Post;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.PostService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.soap.*;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class SoapPrimaryAdapter implements SoapForumService {

    private final PostService postService;

    private final ConversionService conversionService;

    @Override
    @Transactional(readOnly = true)
    public GetAllPostResponse getAllPost(GetAllPostRequest request) {
        List<PersistentPostType> listOfPosts = findAllPost(request.getForumName());
        return createGetAllPostResponse(listOfPosts);
    }

    @Override
    @Transactional
    public void createPost(PostType postType) {
        postService.create(postType.getForumName(), conversionService.convert(postType, Post.class));
    }

    @Override
    @Transactional
    public void removePost(RemovePostRequest removePostRequest) {
        postService.remove(removePostRequest.getForumName(), removePostRequest.getPostId());
    }

    @Override
    @Transactional
    public void updatePost(PersistentPostType persistentPostType) {
        postService.update(persistentPostType.getForumName(), conversionService.convert(persistentPostType, Post.class));
    }

    private List<PersistentPostType> findAllPost(String forumName) {
        return postService
                .findAll(forumName)
                .stream()
                .map(post -> conversionService.convert(post, PersistentPostType.class))
                .collect(Collectors.toList());
    }

    private GetAllPostResponse createGetAllPostResponse(List<PersistentPostType> listOfPosts) {
        GetAllPostResponse response = new GetAllPostResponse();
        response
                .getPost()
                .addAll(listOfPosts);
        return response;
    }
}
