package com.impaqgroup.training.architecture.hexagonalarchitecture.repository.jpa;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses = RepositoryConfiguration.class)
public class RepositoryConfiguration {

}
