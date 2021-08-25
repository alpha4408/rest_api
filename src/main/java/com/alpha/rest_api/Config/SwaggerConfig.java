package com.alpha.rest_api.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Student Swagger page")
                .description("Student API page")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .termsOfServiceUrl("")
                .version("1.0.0")
                .contact(new Contact("Alpha Ngwenya", "https://www.linkedin.com/in/alpha-ngwenya-77537a139/", "angweny1@asu.edu"))
                .build();
    }

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.alpha.rest_api"))
                .build()
                .apiInfo(apiInfo());
    }
}
