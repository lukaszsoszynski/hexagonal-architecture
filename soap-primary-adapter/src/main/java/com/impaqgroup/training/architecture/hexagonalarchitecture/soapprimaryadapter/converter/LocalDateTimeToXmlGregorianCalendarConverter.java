package com.impaqgroup.training.architecture.hexagonalarchitecture.soapprimaryadapter.converter;

import lombok.SneakyThrows;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;

@Component
class LocalDateTimeToXmlGregorianCalendarConverter implements Converter<LocalDateTime, XMLGregorianCalendar> {

    @Override
    @SneakyThrows
    public XMLGregorianCalendar convert(LocalDateTime localDateTime) {
        return DatatypeFactory
                .newInstance()
                .newXMLGregorianCalendar(localDateTime.toString());
    }
}
