package com.impaqgroup.training.architecture.hexagonalarchitecture.restprimaryport;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Thread;
import com.impaqgroup.training.architecture.hexagonalarchitecture.rest.dto.ThreadDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ThreadDtoConverter implements Converter<Thread, ThreadDto> {
    @Override
    public ThreadDto convert(Thread thread) {
        return new ThreadDto(thread.getId(), thread.getThreadName());
    }
}