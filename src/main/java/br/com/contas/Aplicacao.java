package br.com.contas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com")
@EntityScan("br.com.entity")
public class Aplicacao {
	public static void main(String[] args) {
		SpringApplication.run(Aplicacao.class, args);
	}
}
