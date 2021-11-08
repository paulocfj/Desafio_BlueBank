package com.ibm.notfound.bluebank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ibm.notfound.bluebank")).build().apiInfo(metaData());

	}
	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("Spring Boot REST API Blue Bank")
				.description("\"Spring Boot REST API Blue Bank\"").version("1.0.0")
				.license("Apache License Version 2.0").licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
				.build();
	}


	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

}

/*
 * @Api Marca uma classe como um recurso de Swagger.
 * 
 * @ApiImplicitParam Representa um único parâmetro em uma operação da API.
 * 
 * @ApiImplicitParams Um wrapper para permitir uma lista de vários objetos
 * ApiImplicitParam.
 * 
 * @ApiModel Fornece informações adicionais sobre os modelos Swagger.
 * 
 * @ApiModelProperty Adiciona e manipula dados de uma propriedade de modelo.
 * 
 * @ApiOperation Descreve uma operação ou normalmente um método HTTP em um
 * caminho específico.
 * 
 * @ApiParam Adiciona meta-dados adicionais para parâmetros de operação.
 * 
 * @ApiResponse Descreve uma possível resposta de uma operação.
 * 
 * @ApiResponses Um wrapper para permitir uma lista de vários objetos
 * ApiResponse.
 * 
 * @Authorization Declara um esquema de autorização a ser usado em um recurso ou
 * uma operação.
 * 
 * @AuthorizationScope Descreve um escopo de autorização do OAuth2.
 */
