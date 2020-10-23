package com.impaqgroup.training.architecture.hexagonalarchitecture.rest;

import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.CommenceThreadDto;
import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.ThreadDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ThreadController {

    private final RestThreadService restThreadService;

    @PostMapping(value = "/forums/{forum}/threads", consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void commenceThread(@PathVariable("forum") String forum, @RequestBody CommenceThreadDto commenceThreadDto){
        restThreadService.commenceThread(forum, commenceThreadDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/forums/{forum}/threads", produces = APPLICATION_JSON_VALUE)
    public List<ThreadDto> listThreadInForum(@PathVariable("forum") String forum){
        return restThreadService.listThreadsInForum(forum);
    }

}
