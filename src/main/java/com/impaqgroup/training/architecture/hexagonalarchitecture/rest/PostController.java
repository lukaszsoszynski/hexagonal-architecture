package com.impaqgroup.training.architecture.hexagonalarchitecture.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @GetMapping(value = "/posts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PostDto> findAll(){
        return postService.findAll();
    }

    @PostMapping(value = "/posts",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createNew(@RequestBody PostDto postDto){
        postService.create(postDto);
    }

    @DeleteMapping(value = "/posts/{id}")
    public void remove(@PathVariable("id") Long postId){
        postService.remove(postId);
    }

    @PutMapping(path = "/posts/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@PathVariable("id") Long postId, @RequestBody PostDto postDto){
        postDto.setId(postId);
        postService.update(postDto);
    }
}
