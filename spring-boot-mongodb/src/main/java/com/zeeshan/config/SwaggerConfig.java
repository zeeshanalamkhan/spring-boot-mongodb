package com.zeeshan.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final Logger logger = LogManager.getLogger(SwaggerConfig.class);

	@Bean
	public Docket restApi() {

		logger.info("restApi() execution started");
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.zeeshan"))
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());
	}

	public ApiInfo apiInfo() {

		logger.info("apiInfo() execution started");
		return new ApiInfo("Spring Boot RES API", "Spring BOOT REST API for Demo Application", "1.0",
				"Terms of Service", new Contact("Zeeshan Khan", "http://www.zeeshan.com/", "zeeshan.maths@gmail.com"),
				"Apache License Version 2.0", "http://www.apche.org/licence/LICENSE-2.0");
	}

	// URL to see documentation
	// http://localhost:8085/v2/api-docs
	// http://localhost:8085/swagger-ui.html

}
