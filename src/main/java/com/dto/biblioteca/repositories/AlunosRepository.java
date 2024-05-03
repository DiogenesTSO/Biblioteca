package com.dto.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dto.biblioteca.domain.Alunos;

public interface AlunosRepository extends JpaRepository<Alunos, Integer>{

}
