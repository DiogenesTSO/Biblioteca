package com.dto.biblioteca.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.dto.biblioteca.domain.Alunos;
import com.dto.biblioteca.domain.Usuario;
import com.dto.biblioteca.domain.enums.Perfil;
import com.dto.biblioteca.domain.enums.Status;
import com.dto.biblioteca.repositories.AlunosRepository;
import com.dto.biblioteca.repositories.UsuarioRepository;

@Service
public class DBService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private AlunosRepository alunosRepository;

	@Bean
	public void instanciaDB() {
		Usuario user1 = new Usuario(null, 2015101137, "Diogenes Odisi", "diogenes.odisi", "dto2311", Status.ATIVO);
		user1.addPerfil(Perfil.ADMIN);

		Alunos alun1 = new Alunos(null, 19101047, "Ana Larissa", "ana.larissa", "aninha11", Status.ATIVO);
		alun1.addPerfil(Perfil.ALUNO);

		usuarioRepository.saveAll(Arrays.asList(user1));
		alunosRepository.saveAll(Arrays.asList(alun1));
	}
}
