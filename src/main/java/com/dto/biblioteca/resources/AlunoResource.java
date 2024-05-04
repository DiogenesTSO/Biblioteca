package com.dto.biblioteca.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.biblioteca.domain.Alunos;
import com.dto.biblioteca.services.AlunoService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {

	// localhost:8080/alunos/1

	@Autowired
	private AlunoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Alunos> findById(@PathVariable Integer id) {
		Alunos obj = this.service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
