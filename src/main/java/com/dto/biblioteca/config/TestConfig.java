package com.dto.biblioteca.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dto.biblioteca.services.DBService;

//Configuração do ambiente de teste

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService dbService;

	public void instanciaDB() {
		this.dbService.instanciaDB();
	}
}
