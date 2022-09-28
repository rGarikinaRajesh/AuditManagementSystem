package com.cognizant.AuditAuthenticationMicroservice.Swagger;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * This class is used for the configuration and customization of swagger.
 * Swagger is used to describe and document RESTful APIs with Swagger user will
 * able to see the end-points to access the application.
 *
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	/**
	 * 
	 * @return Docket
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}
}