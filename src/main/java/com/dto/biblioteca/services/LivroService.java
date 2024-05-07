package com.dto.biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dto.biblioteca.domain.Livros;
import com.dto.biblioteca.domain.dtos.LivroDTO;
import com.dto.biblioteca.repositories.LivrosRepository;
import com.dto.biblioteca.services.exception.DataIntegrtyViolationException;
import com.dto.biblioteca.services.exception.ObjectNotFoundException;

import jakarta.validation.Valid;

@Service
public class LivroService {

	@Autowired
	private LivrosRepository repository;

	public Livros findById(Integer id) {
		Optional<Livros> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<Livros> findAll() {
		return repository.findAll();

	}

	public Livros create(LivroDTO objDTO) {
		objDTO.setId(null);
		Livros newObj = new Livros(objDTO);
		return repository.save(newObj);
	}

	public Livros update(Integer id, @Valid LivroDTO objDTO) {
		objDTO.setId(id);
		Livros oldObj = findById(id);
		oldObj = new Livros(objDTO);
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		Livros obj = findById(id);
		if (obj.getEmprestimos().size() > 0) {
			throw new DataIntegrtyViolationException("Possui emprestimos para esse livro!");
		}
		repository.deleteById(id);
	}

}
