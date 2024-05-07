package com.dto.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dto.biblioteca.domain.Livros;

public interface LivrosRepository extends JpaRepository<Livros, Integer> {

}
