package com.dto.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dto.biblioteca.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
