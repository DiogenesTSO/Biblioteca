package com.dto.biblioteca.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dto.biblioteca.domain.Alunos;

public interface AlunosRepository extends JpaRepository<Alunos, Integer> {

	Optional<Alunos> findByMatricula(Integer matricula);

	Optional<Alunos> findByUsuario(String usuario);
}
