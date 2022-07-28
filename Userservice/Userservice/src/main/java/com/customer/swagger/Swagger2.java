package com.customer.swagger;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class Swagger2 {
	@Bean
	public Docket productApi()  //doc is an obj   //api selector build select()
	{
	return new Docket(DocumentationType.SWAGGER_2)
	.select()
	.apis(RequestHandlerSelectors.basePackage("com.customer"))  
	.paths(PathSelectors.any())
	.build()
	.apiInfo(getApiInfo());
	}
	private ApiInfo getApiInfo() {
		return new ApiInfo(
		"On Demand Car Wash System",
		"Case Study Project",
		"Terms of Service",
		"Free to use",
		new springfox.documentation.service.Contact("Bhavitha.G", "http://Youtube.com", "bhavithag299@gmail.com"),
		"API Licence","http://Youtube.com", Collections.emptyList());
	}



}