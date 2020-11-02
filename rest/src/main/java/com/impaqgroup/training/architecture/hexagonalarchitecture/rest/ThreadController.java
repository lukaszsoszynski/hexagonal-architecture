package com.impaqgroup.training.architecture.hexagonalarchitecture.rest;

import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.RestCommenceThreadDto;
import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.RestThreadDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
class ThreadController {

    private final RestThreadService restThreadService;

    @PostMapping(value = "/forums/{forum}/threads", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void commenceThread(@PathVariable("forum") String forum, @RequestBody RestCommenceThreadDto commenceThreadDto){
        restThreadService.commenceThread(forum, commenceThreadDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/forums/{forum}/threads", produces = APPLICATION_JSON_VALUE)
    public List<RestThreadDto> listThreadInForum(@PathVariable("forum") String forum){
        return restThreadService.listThreadsInForum(forum);
    }

}
