package com.dto.biblioteca.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dto.biblioteca.domain.Alunos;
import com.dto.biblioteca.domain.dtos.AlunoDTO;
import com.dto.biblioteca.services.AlunoService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {

	// localhost:8080/alunos/1

	@Autowired
	private AlunoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<AlunoDTO> findById(@PathVariable Integer id) {
		Alunos obj = this.service.findById(id);
		return ResponseEntity.ok().body(new AlunoDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<AlunoDTO>> findAll() {
		List<Alunos> list = service.findAll();
		List<AlunoDTO> listDTO = list.stream().map(obj -> new AlunoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<AlunoDTO> create(@RequestBody AlunoDTO objDTO) {
		Alunos newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
