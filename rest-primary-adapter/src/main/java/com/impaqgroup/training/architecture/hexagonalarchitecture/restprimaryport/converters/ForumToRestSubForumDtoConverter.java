package com.impaqgroup.training.architecture.hexagonalarchitecture.restprimaryport.converters;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Forum;
import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.RestSubForumDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class ForumToRestSubForumDtoConverter implements Converter<Forum, RestSubForumDto> {
    @Override
    public RestSubForumDto convert(Forum forum) {
        return new RestSubForumDto(forum.getName(), forum.getTitle());
    }
}
