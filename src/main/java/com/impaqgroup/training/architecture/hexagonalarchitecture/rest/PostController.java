package com.impaqgroup.training.architecture.hexagonalarchitecture.rest;

import static java.util.Objects.requireNonNull;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.PostDto;
import com.impaqgroup.training.architecture.hexagonalarchitecture.service.PostService;

@RestController
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "/forums/{forum}/posts", produces = APPLICATION_JSON_VALUE)
    public List<PostDto> findAll(@PathVariable("forum")String forum){
        return postService.findAll(forum);
    }

    @PostMapping(value = "/forums/{forum}/posts", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createNew(@PathVariable("forum") String forum, @RequestBody PostDto postDto){
        postService.create(postDto.withForumName(forum));
    }

    @DeleteMapping(value = "/forums/{forum}/posts/{id}")
    public void remove(@PathVariable("forum") String forum, @PathVariable("id") Long postId){
        postService.remove(forum, postId);
    }

    @PutMapping(path = "/forums/{forum}/posts/{id}", consumes = APPLICATION_JSON_VALUE)
    public void update(@PathVariable("forum") String forum, @PathVariable("id") Long postId, @RequestBody PostDto postDto){
        postDto = postDto.withPostId(requireNonNull(postId))
            .withForumName(requireNonNull(forum));
        postService.update(postDto);
    }
}
