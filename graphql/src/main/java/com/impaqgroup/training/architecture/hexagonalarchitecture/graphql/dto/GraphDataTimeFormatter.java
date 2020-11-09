package com.impaqgroup.training.architecture.hexagonalarchitecture.graphql.dto;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;

import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;

public enum GraphDataTimeFormatter {

    ISO(ISO_DATE_TIME),
    DATE(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
    TIME(DateTimeFormatter.ofPattern("HH:mm")),
    DAYS_TILL_NOW(null){
        @Override
        String format(LocalDateTime localDateTime) {
            return Optional.ofNullable(localDateTime)
                    .map(dateTime -> Duration.between(dateTime, LocalDateTime.now()).toDays())
                    .map(Objects::toString)
                    .orElse("");
        }
    };

    private final DateTimeFormatter dateTimeFormatter;

    GraphDataTimeFormatter(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }

    String format(LocalDateTime localDateTime) {
        return Optional.ofNullable(localDateTime)
                .map(dateTime -> dateTime.format(this.dateTimeFormatter))
                .orElse("");
    }
}
