package com.impaqgroup.training.architecture.hexagonalarchitecture.rest;

import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.CommenceThreadDto;
import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.ThreadDto;

import java.util.List;

public interface RestThreadService {
    void commenceThread(String forumName, CommenceThreadDto commenceThreadDto);
    List<ThreadDto> listThreadsInForum(String forum);
}
