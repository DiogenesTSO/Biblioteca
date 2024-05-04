package com.dto.biblioteca.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dto.biblioteca.domain.Alunos;
import com.dto.biblioteca.repositories.AlunosRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunosRepository repository;

	public Alunos findById(Integer id) {
		Optional<Alunos> obj = repository.findById(id);
		return obj.orElse(null);
	}
}
