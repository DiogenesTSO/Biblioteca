package com.dto.biblioteca.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dto.biblioteca.domain.Alunos;
import com.dto.biblioteca.domain.dtos.AlunoDTO;
import com.dto.biblioteca.repositories.AlunosRepository;
import com.dto.biblioteca.services.exception.DataIntegrtyViolationException;
import com.dto.biblioteca.services.exception.ObjectNotFoundException;

import jakarta.validation.Valid;

@Service
public class AlunoService {

	@Autowired
	private AlunosRepository repository;

	public Alunos findById(Integer id) {
		Optional<Alunos> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<Alunos> findAll() {
		return repository.findAll();

	}

	public Alunos create(AlunoDTO objDTO) {
		objDTO.setId(null);
		validaMatricula(objDTO);
		Alunos newObj = new Alunos(objDTO);
		return repository.save(newObj);
	}

	public Alunos update(Integer id, @Valid AlunoDTO objDTO) {
		objDTO.setId(id);
		Alunos oldObj = findById(id);
		validaMatricula(objDTO);
		oldObj = new Alunos(objDTO);
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		Alunos obj = findById(id);
		if (obj.getEmprestimos().size() > 0) {
			throw new DataIntegrtyViolationException("Aluno possui livros emprestados!");
		}
		repository.deleteById(id);
	}

	private void validaMatricula(AlunoDTO objDTO) {
		Optional<Alunos> obj = repository.findByMatricula(objDTO.getMatricula());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrtyViolationException("Matricula ja cadastrada no sistema");
		}

		obj = repository.findByUsuario(objDTO.getUsuario());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrtyViolationException("Usuário ja cadastrada no sistema");
		}

	}

}
