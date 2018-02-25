package com.impaqgroup.training.architecture.hexagonalarchitecture.repository;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses = RepositoryConfiguration.class)
@EntityScan("com.impaqgroup.training.architecture.hexagonalarchitecture")
public class RepositoryConfiguration {

}
