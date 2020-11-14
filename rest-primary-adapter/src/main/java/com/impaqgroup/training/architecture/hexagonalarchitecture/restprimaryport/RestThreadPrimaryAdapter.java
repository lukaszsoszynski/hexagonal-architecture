package com.impaqgroup.training.architecture.hexagonalarchitecture.restprimaryport;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Post;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.ForumService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.RestThreadService;
import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.RestCommenceThreadDto;
import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.RestThreadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestThreadPrimaryAdapter implements RestThreadService {

    private final ForumService forumService;
    private final ConversionService conversionService;

    @Override
    @Transactional
    public void commenceThread(String forumName, RestCommenceThreadDto commenceThreadDto) {
        Post post = conversionService.convert(commenceThreadDto.getPost(), Post.class);
        forumService.commenceThread(forumName, commenceThreadDto.getThreadName(), post);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RestThreadDto> listThreadsInForum(String forum) {
        return forumService.listThreadsInForum(forum)
                .stream()
                .map(thread -> conversionService.convert(thread, RestThreadDto.class))
                .collect(Collectors.toList());
    }
}