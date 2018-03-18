package com.impaqgroup.training.architecture.hexagonalarchitecture.soap;

import org.springframework.ws.server.endpoint.annotation.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Endpoint
@Slf4j
@RequiredArgsConstructor
public class ForumEndpoint {

    private static final String NAMESPACE_URI = "http://impaqgroup.com/training/architecture/hexagonalarchitecture/soap";

    private final SoapForumService soapForumService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllPostRequest")
    @ResponsePayload
    public GetAllPostResponse getAllPostRequest(@RequestPayload GetAllPostRequest getAllPostRequest){
        log.info("Get all post from forum {}", getAllPostRequest);
        return soapForumService.getAllPost(getAllPostRequest);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createPostRequest")
    public void createPost(@RequestPayload PostType createPostRequest){
        log.info("Create post {}", createPostRequest);
        soapForumService.createPost(createPostRequest);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "removePostRequest")
    public void removePost(@RequestPayload RemovePostRequest removePostRequest){
        log.info("Post will be removed {}", removePostRequest);
        soapForumService.removePost(removePostRequest);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updatePostRequest")
    public void updatePost(@RequestPayload PersistentPostType updatePostRequest){
        log.info("Update post: {}", updatePostRequest);
        soapForumService.updatePost(updatePostRequest);
    }

}
