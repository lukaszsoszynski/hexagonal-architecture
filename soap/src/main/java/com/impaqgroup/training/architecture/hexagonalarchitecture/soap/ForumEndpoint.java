package com.impaqgroup.training.architecture.hexagonalarchitecture.soap;

import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
class ForumEndpoint {
    private final SoapForumService soapForumService;

    @PayloadRoot(namespace = SoapConfiguration.NAMESPACE_URI, localPart = "listSubForums")
    @ResponsePayload
    public ListSubForumsResponse getAllPostRequest(){
        return soapForumService.listSubForums();
    }
}
