package com.impaqgroup.training.architecture.hexagonalarchitecture.soap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import static com.impaqgroup.training.architecture.hexagonalarchitecture.soap.SoapConfiguration.NAMESPACE_URI;

@Endpoint
@Slf4j
@RequiredArgsConstructor
public class ThreadEndpoint {

    private final SoapThreadService soapThreadService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "commenceNewThread")
    @ResponsePayload
    public void commenceNewThread(@RequestPayload CommenceNewThread commenceNewThread){
        log.info("Commence new thread {}", commenceNewThread);
        soapThreadService.commenceNewThread(commenceNewThread);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "listAllThreads")
    @ResponsePayload
    public ListAllThreadsResponse listAllThreads(@RequestPayload ListAllThreads listAllThreads){
        log.info("List all threads in forum '{}'", listAllThreads);
        return soapThreadService.listAllThread(listAllThreads);
    }
}
