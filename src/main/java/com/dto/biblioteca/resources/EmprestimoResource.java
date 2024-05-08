package com.dto.biblioteca.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dto.biblioteca.domain.Emprestimo;
import com.dto.biblioteca.domain.dtos.EmprestimoDTO;
import com.dto.biblioteca.services.EmprestimoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/emprestimos")
public class EmprestimoResource {

	@Autowired
	private EmprestimoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<EmprestimoDTO> findById(@PathVariable Integer id) {
		Emprestimo obj = service.findById(id);
		return ResponseEntity.ok().body(new EmprestimoDTO(obj));
	}

	@GetMapping
	public ResponseEntity<List<EmprestimoDTO>> findAll() {
		List<Emprestimo> list = service.findAll();
		List<EmprestimoDTO> listDTO = list.stream().map(obj -> new EmprestimoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<EmprestimoDTO> create(@Valid @RequestBody EmprestimoDTO objDTO) {
		Emprestimo obj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<EmprestimoDTO> update(@PathVariable Integer id, @Valid @RequestBody EmprestimoDTO objDTO) {
		Emprestimo newObj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new EmprestimoDTO(newObj));
	}
}
