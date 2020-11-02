package com.impaqgroup.training.architecture.hexagonalarchitecture.rest;

import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.RestSubForumDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
class ForumController {

    private final RestForumService restForumService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/forums", produces = APPLICATION_JSON_VALUE)
    public List<RestSubForumDto> listAllSubForums(){
        return restForumService.listAllSubForums();
    }
}
