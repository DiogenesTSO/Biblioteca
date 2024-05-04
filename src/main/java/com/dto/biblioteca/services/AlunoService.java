package com.dto.biblioteca.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dto.biblioteca.domain.Alunos;
import com.dto.biblioteca.domain.dtos.AlunoDTO;
import com.dto.biblioteca.repositories.AlunosRepository;
import com.dto.biblioteca.services.exception.ObjectNotFoundException;

@Service
public class AlunoService {

	@Autowired
	private AlunosRepository repository;

	public Alunos findById(Integer id) {
		Optional<Alunos> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " +id));
	}

	public List<Alunos> findAll() {
		return repository.findAll();
		
	}

	public Alunos create(AlunoDTO objDTO) {
		objDTO.setId(null);
		Alunos newObj = new Alunos(objDTO);
		return repository.save(newObj);
	}
}
