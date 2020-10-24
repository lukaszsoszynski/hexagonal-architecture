package com.impaqgroup.training.architecture.hexagonalarchitecture.soap;

import org.springframework.ws.server.endpoint.annotation.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Endpoint
@Slf4j
@RequiredArgsConstructor
public class ForumEndpoint {

    private final SoapPostService soapPostService;

    @PayloadRoot(namespace = SoapConfiguration.NAMESPACE_URI, localPart = "getAllPostRequest")
    @ResponsePayload
    public GetAllPostResponse getAllPostRequest(@RequestPayload GetAllPostRequest getAllPostRequest){
        log.info("Get all post from forum {}", getAllPostRequest);
        return soapPostService.getAllPost(getAllPostRequest);
    }

    @PayloadRoot(namespace = SoapConfiguration.NAMESPACE_URI, localPart = "createPostRequest")
    public void createPost(@RequestPayload PostType createPostRequest){
        log.info("Create post {}", createPostRequest);
        soapPostService.createPost(createPostRequest);
    }

    @PayloadRoot(namespace = SoapConfiguration.NAMESPACE_URI, localPart = "removePostRequest")
    public void removePost(@RequestPayload RemovePostRequest removePostRequest){
        log.info("Post will be removed {}", removePostRequest);
        soapPostService.removePost(removePostRequest);
    }

    @PayloadRoot(namespace = SoapConfiguration.NAMESPACE_URI, localPart = "updatePostRequest")
    public void updatePost(@RequestPayload PersistentPostType updatePostRequest){
        log.info("Update post: {}", updatePostRequest);
        soapPostService.updatePost(updatePostRequest);
    }

}
