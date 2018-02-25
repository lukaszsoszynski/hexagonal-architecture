package com.impaqgroup.training.architecture.hexagonalarchitecture.install;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.impaqgroup.training.architecture.hexagonalarchitecture.service.repository.RepositoryConfiguration;

@SpringBootApplication(scanBasePackages = "com.impaqgroup.training.architecture.hexagonalarchitecture")
@Import(RepositoryConfiguration.class)
public class HexagonalArchitectureApplication {

	//on java 9 run with option --add-modules java.xml.bind
	public static void main(String[] args) {
		SpringApplication.run(HexagonalArchitectureApplication.class, args);
	}
}
