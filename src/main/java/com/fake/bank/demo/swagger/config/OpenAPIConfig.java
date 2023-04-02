package com.fake.bank.demo.swagger.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfig {

  @Value("${rambabu.openapi.dev-url}")
  private String devUrl;

  @Value("${rambabu.openapi.prod-url}")
  private String prodUrl;

  @Bean
  public OpenAPI myOpenAPI() {
    Server devServer = new Server();
    devServer.setUrl(devUrl);
    devServer.setDescription("Server URL in Development environment");

    Server prodServer = new Server();
    prodServer.setUrl(prodUrl);
    prodServer.setDescription("Server URL in Production environment");

    Contact contact = new Contact();
    contact.setEmail("ram.t.babu@gmail.com");
    contact.setName("Rambabu");
    contact.setUrl("https://www.rambabu.com");

    License mitLicense = new License().name("MIT License").url("https://rambabu.com/licenses/mit/");

    Info info = new Info()
        .title("Fake Bank Core Banking AccountDTO Management API")
        .version("1.0")
        .contact(contact)
        .description("This API exposes endpoints to manage tutorials.").termsOfService("https://www.rambabu.com/terms")
        .license(mitLicense);

    return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
  }
}
