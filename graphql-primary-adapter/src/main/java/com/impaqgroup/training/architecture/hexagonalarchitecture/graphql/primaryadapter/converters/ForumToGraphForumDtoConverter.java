package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.primaryadapter.converters;

import com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto.GraphForumDto;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Forum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class ForumToGraphForumDtoConverter implements Converter<Forum, GraphForumDto> {
    @Override
    public GraphForumDto convert(Forum forum) {
        return new GraphForumDto(forum.getName(), forum.getTitle());
    }
}
