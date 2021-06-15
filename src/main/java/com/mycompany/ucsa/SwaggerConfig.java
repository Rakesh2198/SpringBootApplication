package com.mycompany.ucsa;


import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import  com.google.common.base.Predicate;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;



@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket postApi() {
		
		return new Docket(DocumentationType.SWAGGER_2).groupName("course-api").apiInfo(apiInfo()).select().paths(postPaths()).build();
	}
	
	private Predicate<String> postPaths() {
		return or (regex("/courses/.*"), regex("/Exam Details/.*"), regex("/universitystaffmember/.*"), regex("/admisssioncommiteemember/.*"),regex("/admission/.*"),regex("/applicant/.*"), regex("/faculty/.*"));
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Course.API").description("Raki API Reference for developer").termsOfServiceUrl("http://raki.com").license("Raki license").licenseUrl("raki@cg.com").version("1.0").build();
	}

}
