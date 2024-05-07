package com.dto.biblioteca.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dto.biblioteca.domain.Emprestimo;
import com.dto.biblioteca.domain.dtos.EmprestimoDTO;
import com.dto.biblioteca.services.EmprestimoService;

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
}
