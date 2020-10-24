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
class PostSoapPrimaryAdapter implements SoapPostService {

    private final ForumService forumService;

    private final ConversionService conversionService;

    @Override
    @Transactional(readOnly = true)
    public GetAllPostResponse getAllPost(GetAllPostRequest request) {
        List<PersistentPostType> listOfPosts = findAllPost(request.getForumName(), request.getThreadId());
        return createGetAllPostResponse(listOfPosts);
    }

    @Override
    @Transactional
    public void createPost(PostType postType) {
        forumService.create(postType.getForumName(), postType.getThreadId(), conversionService.convert(postType, Post.class));
    }

    @Override
    @Transactional
    public void removePost(RemovePostRequest removePostRequest) {
        forumService.remove(removePostRequest.getForumName(), removePostRequest.getThreadId(), removePostRequest.getPostId());
    }

    @Override
    @Transactional
    public void updatePost(PersistentPostType persistentPostType) {
        forumService.update(persistentPostType.getForumName(), persistentPostType.getThreadId(), conversionService.convert(persistentPostType, Post.class));
    }

    private List<PersistentPostType> findAllPost(String forumName, Long threadId) {
        return forumService
                .findAll(forumName, threadId)
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
