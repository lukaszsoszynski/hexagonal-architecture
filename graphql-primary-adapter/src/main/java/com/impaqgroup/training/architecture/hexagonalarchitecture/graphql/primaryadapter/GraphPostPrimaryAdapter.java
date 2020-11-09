package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.primaryadapter;

import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.GraphPostService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphCreateNewPostRequest;
import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphPostDto;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.ForumModelService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.function.Supplier;

@Component
@RequiredArgsConstructor
class GraphPostPrimaryAdapter implements GraphPostService {

    private final ForumModelService forumModelService;

    private final ConversionService conversionService;

    @Override
    @Transactional(readOnly = true)
    public Optional<GraphPostDto> findPostById(String forumName, Long threadId, Long postId) {
        return forumModelService.findPostById(forumName, threadId, postId)
                .map(post -> conversionService.convert(post, GraphPostDto.class));
    }

    @Override
    @Transactional
    public Supplier<GraphPostDto> createNewPost(GraphCreateNewPostRequest request) {
        Post post = conversionService.convert(request, Post.class);
        forumModelService.create(request.getForumName(), request.getThreadId(), post);
        return () -> conversionService.convert(post, GraphPostDto.class);
    }
}
