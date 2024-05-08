package com.dto.biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.biblioteca.domain.Alunos;
import com.dto.biblioteca.domain.Emprestimo;
import com.dto.biblioteca.domain.Livros;
import com.dto.biblioteca.domain.dtos.EmprestimoDTO;
import com.dto.biblioteca.repositories.EmprestimoRepository;
import com.dto.biblioteca.services.exception.ObjectNotFoundException;

import jakarta.validation.Valid;

@Service
public class EmprestimoService {

	@Autowired
	private EmprestimoRepository repository;
	@Autowired
	private AlunoService alunoService;
	@Autowired
	private LivroService livroService;

	public Emprestimo findById(Integer id) {
		Optional<Emprestimo> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: " + id));
	}

	public List<Emprestimo> findAll() {
		return repository.findAll();

	}

	public Emprestimo create(@Valid EmprestimoDTO objDTO) {
		return repository.save(newEmprestimo(objDTO));
	}

	private Emprestimo newEmprestimo(EmprestimoDTO obj) {
		Alunos alunos = alunoService.findById(obj.getAlunos());
		Livros livros = livroService.findById(obj.getLivros());

		Emprestimo emprestimo = new Emprestimo();
		if (obj.getId() != null) {
			emprestimo.setId(obj.getId());
		}

		emprestimo.setAlunos(alunos);
		emprestimo.setLivros(livros);
		return emprestimo;
	}

}
