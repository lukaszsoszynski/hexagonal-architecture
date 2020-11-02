package com.impaqgroup.training.architecture.hexagonalarchitecture.rest;

import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.RestPostDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.requireNonNull;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
class PostController {

    private final RestPostService restPostService;

    public PostController(RestPostService restPostService) {
        log.info("PostController created");
        this.restPostService = restPostService;
    }

    @GetMapping(value = "/forums/{forum}/threads/{threadId}/posts", produces = APPLICATION_JSON_VALUE)
    public List<RestPostDto> findAll(@PathVariable("forum") String forum, @PathVariable("threadId") Long threadId) {
        return restPostService.listPostInForumAndThread(forum, threadId);
    }

    @PostMapping(value = "/forums/{forum}/threads/{threadId}/posts", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createNew(@PathVariable("forum") String forum,
                          @PathVariable("threadId") Long threadId,
                          @RequestBody RestPostDto postDto) {
        restPostService.create(forum, threadId, postDto);
    }

    @DeleteMapping(value = "/forums/{forum}/threads/{threadId}/posts/{postId}")
    public void remove(@PathVariable("forum") String forum,
                       @PathVariable("threadId") Long threadId,
                       @PathVariable("postId") Long postId) {
        restPostService.remove(forum, threadId, postId);
    }

    @PutMapping(path = "/forums/{forum}/threads/{threadId}/posts/{postId}", consumes = APPLICATION_JSON_VALUE)
    public void update(@PathVariable("forum") String forum,
                       @PathVariable("threadId") Long threadId,
                       @PathVariable("postId") Long postId,
                       @RequestBody RestPostDto postDto) {
        postDto = postDto.withPostId(requireNonNull(postId));
        restPostService.update(forum, threadId, postDto);
    }
}
