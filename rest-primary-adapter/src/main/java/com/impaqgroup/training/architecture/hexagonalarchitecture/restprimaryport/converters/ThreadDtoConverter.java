package com.impaqgroup.training.architecture.hexagonalarchitecture.restprimaryport.converters;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Thread;
import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.RestThreadDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class ThreadDtoConverter implements Converter<Thread, RestThreadDto> {
    @Override
    public RestThreadDto convert(Thread thread) {
        return new RestThreadDto(thread.getId(),
                thread.getThreadName(),
                thread.getCreatorEmail(),
                thread.getForumName());
    }
}
