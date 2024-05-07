package com.dto.biblioteca.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.dto.biblioteca.domain.Alunos;
import com.dto.biblioteca.domain.Emprestimo;
import com.dto.biblioteca.domain.Livros;
import com.dto.biblioteca.domain.Usuario;
import com.dto.biblioteca.domain.enums.Perfil;
import com.dto.biblioteca.domain.enums.Status;
import com.dto.biblioteca.repositories.AlunosRepository;
import com.dto.biblioteca.repositories.EmprestimoRepository;
import com.dto.biblioteca.repositories.LivrosRepository;
import com.dto.biblioteca.repositories.UsuarioRepository;

@Service
public class DBService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private AlunosRepository alunosRepository;
	@Autowired
	private EmprestimoRepository emprestimoRepository;
	@Autowired
	private LivrosRepository livrosRepository;

	@Bean
	public void instanciaDB() {
		Usuario user1 = new Usuario(null, "Diogenes Odisi", "diogenes.odisi", "dto2311", Status.ATIVO);
		user1.addPerfil(Perfil.ADMIN);
		Usuario user2 = new Usuario(null, "Ana Larissa", "ana", "aninha11", Status.ATIVO);
		user2.addPerfil(Perfil.ADMIN);

		Alunos alun1 = new Alunos(null, null, 2015101137, "Diogenes Odisi", "diogenes", "dto2311", Status.ATIVO);
		alun1.addPerfil(Perfil.ALUNO);
		Alunos alun2 = new Alunos(null, null, 19101047, "Ana Larissa", "ana.larissa", "aninha11", Status.ATIVO);
		alun2.addPerfil(Perfil.ALUNO);

		Livros liv1 = new Livros(null, "Código Limpo", "Robert C. Martin", "Programação", 2009, 2);
		Livros liv2 = new Livros(null, "Arquitetura Limpa", "Robert C. Martin", "Programação", 2009, 5);
		livrosRepository.saveAll(Arrays.asList(liv1, liv2));

		Emprestimo emp1 = new Emprestimo(null, "Código Limpo", alun1, liv1);

		usuarioRepository.saveAll(Arrays.asList(user1, user2));
		alunosRepository.saveAll(Arrays.asList(alun1, alun2));
		emprestimoRepository.saveAll(Arrays.asList(emp1));

	}
}
