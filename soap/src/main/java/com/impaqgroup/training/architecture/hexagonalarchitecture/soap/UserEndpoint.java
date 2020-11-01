package com.impaqgroup.training.architecture.hexagonalarchitecture.soap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.SoapFaultException;

import static com.impaqgroup.training.architecture.hexagonalarchitecture.soap.SoapConfiguration.NAMESPACE_URI;

@Slf4j
@Endpoint
@RequiredArgsConstructor
public class UserEndpoint {

    private final SoapUserService soapUserService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "findUserByEmail")
    @ResponsePayload
    public FindUserByEmailResponse findUserByEmail(@RequestPayload FindUserByEmail request){
        log.info("Searching user by email '{}'", request);
        return soapUserService
                .findUserByEmail(request)
                .orElseThrow(() -> new SoapFaultException(String.format("User with email %s not found.", request.getEmail())));
    }
}
