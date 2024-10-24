package edu.padroes.projetos_dio;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Projeto Spring Boot gerado via Spring Intializr
 * Modúlos adicionados
 * 	- Spring WEB
 * 	- Spring data JPA
 * 	- H2 Database
 * 	- OpenFeign
 *
 * @author SandroAmânciodeSá
 *
 * */
@EnableFeignClients
@OpenAPIDefinition(info = @Info(title="Swagger Api", version="1", description = "API teste"))
@SpringBootApplication

public class ProjetosDioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetosDioApplication.class, args);
	}

}
