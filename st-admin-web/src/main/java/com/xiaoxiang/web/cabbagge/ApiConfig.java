package com.xiaoxiang.web.cabbagge;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApiConfig {

	@Bean
	public Docket apiConfiguration() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.xiaoxiang.web.cabbagge"))
				.paths(PathSelectors.any())
				.build();
	}
	
	
	private ApiInfo apiInfo() {
		
		return new ApiInfoBuilder()
				.title("Title")
				.description("Description")
				.version("1.0.0")
				.build();
	}
}
