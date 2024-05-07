package com.dto.biblioteca.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dto.biblioteca.domain.Emprestimo;
import com.dto.biblioteca.repositories.EmprestimoRepository;
import com.dto.biblioteca.services.exception.ObjectNotFoundException;

@Service
public class EmprestimoService {

	@Autowired
	private EmprestimoRepository repository;

	public Emprestimo findById(Integer id) {
		Optional<Emprestimo> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: " + id));
	}
}
