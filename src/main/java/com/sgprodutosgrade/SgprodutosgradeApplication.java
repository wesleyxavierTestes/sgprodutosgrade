package com.sgprodutosgrade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({
	"com.sgprodutosgrade.controller",
	"com.sgprodutosgrade.core.services",
	"com.sgprodutosgrade.infra.data"
})
@EntityScan("com.sgprodutosgrade.core.entities")
@EnableJpaRepositories("com.sgprodutosgrade.infra.repositorys")
@SpringBootApplication
public class SgprodutosgradeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SgprodutosgradeApplication.class, args);
	}

}
