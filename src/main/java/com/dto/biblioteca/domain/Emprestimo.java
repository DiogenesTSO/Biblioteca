package com.dto.biblioteca.domain;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Emprestimo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataEmprestimo = LocalDate.now();
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDevolucao = LocalDate.now();

	@ManyToOne
	@JoinColumn(name = "livro_id")
	private Livros livros;

	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Alunos alunos;

	public Emprestimo() {
		super();
	}

	public Emprestimo(Integer id, Alunos alunos, Livros livros) {
		super();
		this.id = id;
		this.alunos = alunos;
		this.livros = livros;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Alunos getAlunos() {
		return alunos;
	}

	public void setAlunos(Alunos alunos) {
		this.alunos = alunos;
	}

	public Livros getLivros() {
		return livros;
	}

	public void setLivros(Livros livros) {
		this.livros = livros;
	}

}
