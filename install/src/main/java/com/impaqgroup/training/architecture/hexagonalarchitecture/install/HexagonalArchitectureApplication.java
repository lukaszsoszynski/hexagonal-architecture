package com.impaqgroup.training.architecture.hexagonalarchitecture.install;

import static org.springframework.context.annotation.FilterType.ANNOTATION;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.stereotype.OutputPort;
import com.impaqgroup.training.architecture.hexagonalarchitecture.repository.jpa.RepositoryConfiguration;

@SpringBootApplication
@ComponentScan(
		basePackages = "com.impaqgroup.training.architecture.hexagonalarchitecture",
		includeFilters = @ComponentScan.Filter(type = ANNOTATION, classes = OutputPort.class))
@Import(RepositoryConfiguration.class)
public class HexagonalArchitectureApplication {

	//on java 9 run with option --add-modules java.xml.bind,java.xml.ws
	public static void main(String[] args) {
		SpringApplication.run(HexagonalArchitectureApplication.class, args);
	}

}
