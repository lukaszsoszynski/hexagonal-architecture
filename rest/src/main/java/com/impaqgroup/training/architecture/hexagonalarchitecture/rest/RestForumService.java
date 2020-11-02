package com.impaqgroup.training.architecture.hexagonalarchitecture.rest;

import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.RestSubForumDto;

import java.util.List;

public interface RestForumService {
    List<RestSubForumDto> listAllSubForums();
}
