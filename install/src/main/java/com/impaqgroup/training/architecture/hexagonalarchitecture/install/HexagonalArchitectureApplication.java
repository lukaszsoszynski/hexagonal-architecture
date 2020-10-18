package com.impaqgroup.training.architecture.hexagonalarchitecture.install;

import com.impaqgroup.training.architecture.hexagonalarchitecture.model.stereotype.OutputPort;
import com.impaqgroup.training.architecture.hexagonalarchitecture.repository.jpa.RepositoryConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import static org.springframework.context.annotation.FilterType.ANNOTATION;

@SpringBootApplication
@ComponentScan(
		basePackages = "com.impaqgroup.training.architecture.hexagonalarchitecture",
		useDefaultFilters = false,
		includeFilters = {
				@Filter(type = ANNOTATION, classes = Component.class),
				@Filter(type = ANNOTATION, classes = OutputPort.class)
		})
@Import(RepositoryConfiguration.class)
public class HexagonalArchitectureApplication {

//	@Bean
//	PostService postService(ForumDao forumRepository, NotificationSender notificationSender){
//		return new PostModelService(forumRepository, notificationSender);
//	}

	public static void main(String[] args) {
		SpringApplication.run(HexagonalArchitectureApplication.class, args);
	}

}
