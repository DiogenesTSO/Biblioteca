package com.dto.biblioteca;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dto.biblioteca.domain.Alunos;
import com.dto.biblioteca.domain.Usuario;
import com.dto.biblioteca.domain.enums.Perfil;
import com.dto.biblioteca.domain.enums.Status;
import com.dto.biblioteca.repositories.AlunosRepository;
import com.dto.biblioteca.repositories.UsuarioRepository;

@SpringBootApplication
public class BibliotecaApplication implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private AlunosRepository alunosRepository;

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	Usuario user1 = new Usuario(null, 2015101137, "Diogenes Odisi", "diogenes.odisi", "dto2311", Status.ATIVO); 
		user1.addPerfil(Perfil.ADMIN);
	
	Alunos alun1 = new Alunos(null, 19101047, "Ana Larissa", "ana.larissa", "aninha11", Status.ATIVO);
		alun1.addPerfil(Perfil.ALUNO);
		
		usuarioRepository.saveAll(Arrays.asList(user1));
		alunosRepository.saveAll(Arrays.asList(alun1));
	}
	}