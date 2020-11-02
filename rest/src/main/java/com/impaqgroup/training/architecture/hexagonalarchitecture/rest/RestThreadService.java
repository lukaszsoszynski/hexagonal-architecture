package com.impaqgroup.training.architecture.hexagonalarchitecture.rest;

import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.RestCommenceThreadDto;
import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.RestThreadDto;

import java.util.List;

public interface RestThreadService {
    void commenceThread(String forumName, RestCommenceThreadDto commenceThreadDto);
    List<RestThreadDto> listThreadsInForum(String forum);
}
