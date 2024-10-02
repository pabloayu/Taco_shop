package io.keepcoding.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
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

	@Bean
	Docket createApiDoc() {
		return new Docket(DocumentationType.SWAGGER_2)
			.apiInfo(apiInfo())
			.select()
			.apis(RequestHandlerSelectors.basePackage("io.keepcoding.web"))
			.paths(PathSelectors.any())
			.build();					
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Documentación de la Franquicia de Taco Shop")
				.description("Información completa sobre la API REST para consumo de clientes de todo tipo")
				.termsOfServiceUrl("www.termsofserviceTacoshop.com")
				.contact(new Contact("Elias Barrera", "www.tacoshop.com", "taco@taco.es"))
				.version("1.0")
				.build();
	}
	
}
