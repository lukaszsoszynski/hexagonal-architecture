package com.impaqgroup.training.architecture.hexagonalarchitecture.soapprimaryadapter.converter;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.Thread;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ThreadModelConverter implements Converter<Thread, com.impaqgroup.training.architecture.hexagonalarchitecture.soap.Thread> {
    @Override
    public com.impaqgroup.training.architecture.hexagonalarchitecture.soap.Thread convert(Thread thread) {
        com.impaqgroup.training.architecture.hexagonalarchitecture.soap.Thread result = new com.impaqgroup.training.architecture.hexagonalarchitecture.soap.Thread();
        result.setThreadId(thread.getId());
        result.setName(thread.getThreadName());
        return result;
    }
}
