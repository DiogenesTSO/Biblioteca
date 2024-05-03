package com.dto.biblioteca.domain;

import java.util.ArrayList;
import java.util.List;

import com.dto.biblioteca.domain.enums.Perfil;
import com.dto.biblioteca.domain.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Alunos extends Usuario {
	private static final long serialVersionUID = 1L;
		
	@OneToMany(mappedBy = "alunos")
	private List<Emprestimo> emprestimos = new ArrayList<>();

	public Alunos() {
		super();
		addPerfil(Perfil.ALUNO);
	}

	public Alunos(Integer id, Integer matricula, String nome, String usuario, String senha, Status status) {
		super(id, matricula, nome, usuario, senha, status);
		addPerfil(Perfil.ALUNO);
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
	
	
	
}
