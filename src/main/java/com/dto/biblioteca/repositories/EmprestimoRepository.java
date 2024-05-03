package com.dto.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dto.biblioteca.domain.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer>{

}
