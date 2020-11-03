package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.primaryadapter.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static java.time.format.DateTimeFormatter.ISO_DATE;

@Component
class LocalDateTimeToStringConverter implements Converter<LocalDateTime, String> {

    @Override
    public String convert(LocalDateTime localDateTime) {
        return localDateTime.format(ISO_DATE);
    }
}
