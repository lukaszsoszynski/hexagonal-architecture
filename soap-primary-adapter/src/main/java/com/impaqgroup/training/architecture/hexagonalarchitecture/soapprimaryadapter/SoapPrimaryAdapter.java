package com.impaqgroup.training.architecture.hexagonalarchitecture.soapprimaryadapter;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.ForumService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Post;
import com.impaqgroup.training.architecture.hexagonalarchitecture.soap.*;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
class SoapPrimaryAdapter implements SoapForumService {

    private final ForumService forumService;

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
        forumService.create(postType.getForumName(), null, conversionService.convert(postType, Post.class));
    }

    @Override
    @Transactional
    public void removePost(RemovePostRequest removePostRequest) {
        forumService.remove(removePostRequest.getForumName(), null, removePostRequest.getPostId());
    }

    @Override
    @Transactional
    public void updatePost(PersistentPostType persistentPostType) {
        forumService.update(persistentPostType.getForumName(), null, conversionService.convert(persistentPostType, Post.class));
    }

    private List<PersistentPostType> findAllPost(String forumName) {
        return forumService
                .findAll(forumName, null)
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
