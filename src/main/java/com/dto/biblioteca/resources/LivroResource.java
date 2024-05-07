package com.dto.biblioteca.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.dto.biblioteca.domain.Livros;
import com.dto.biblioteca.domain.dtos.LivroDTO;
import com.dto.biblioteca.services.LivroService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

	// localhost:8080/livros/1

	@Autowired
	private LivroService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<LivroDTO> findById(@PathVariable Integer id) {
		Livros obj = this.service.findById(id);
		return ResponseEntity.ok().body(new LivroDTO(obj));
	}

	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAll() {
		List<Livros> list = service.findAll();
		List<LivroDTO> listDTO = list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<LivroDTO> create(@Valid @RequestBody LivroDTO objDTO) {
		Livros newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<LivroDTO> update(@PathVariable Integer id, @Valid @RequestBody LivroDTO objDTO) {
		Livros obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new LivroDTO(obj));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<LivroDTO> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
