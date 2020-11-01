package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql;

import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphForumDto;

import java.util.List;

public interface GraphForumService {
    List<GraphForumDto> listSubForums();
}
