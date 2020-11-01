package com.impaqgroup.training.architecture.hexagonalarchitecture.install;

import com.impaqgroup.training.architecture.hexagonalarchitecture.install.security.SecurityConfig;
import com.impaqgroup.training.architecture.hexagonalarchitecture.model.stereotype.OutputPort;
import com.impaqgroup.training.architecture.hexagonalarchitecture.repository.jpa.RepositoryConfiguration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.context.annotation.FilterType.ANNOTATION;

@Slf4j
@SpringBootApplication
@ComponentScan(
		basePackages = "com.impaqgroup.training.architecture.hexagonalarchitecture",
		useDefaultFilters = false,
		includeFilters = {
				@Filter(type = ANNOTATION, classes = Component.class),
				@Filter(type = ANNOTATION, classes = OutputPort.class)
		})
@Import({RepositoryConfiguration.class, SecurityConfig.class})
@RequiredArgsConstructor
public class HexagonalArchitectureApplication {

	private final GenericConversionService conversionService;
	private final List<Converter<?,?>> listConverters;

	public static void main(String[] args) {
		SpringApplication.run(HexagonalArchitectureApplication.class, args);
	}

	@PostConstruct
	public void registerConverters(){
		String converters = listConverters
				.stream()
				.map(Object::getClass)
				.map(Class::getCanonicalName)
				.collect(Collectors.joining(",\n"));
		listConverters.forEach(conversionService::addConverter);
		log.info("Converters registered in conversion service '{}'", converters);
	}

}
