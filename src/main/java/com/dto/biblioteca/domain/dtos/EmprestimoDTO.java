package com.dto.biblioteca.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import com.dto.biblioteca.domain.Emprestimo;
import com.fasterxml.jackson.annotation.JsonFormat;

public class EmprestimoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String titulo;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataEmprestimo = LocalDate.now();
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDevolucao = LocalDate.now();

	private Integer livros;
	private Integer alunos;
	private String nomeAluno;
	private String nomeLivro;

	public EmprestimoDTO() {
		super();
	}

	public EmprestimoDTO(Emprestimo obj) {
		super();
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
		this.dataEmprestimo = obj.getDataEmprestimo();
		this.dataDevolucao = obj.getDataDevolucao();
		this.livros = obj.getLivros().getId();
		this.alunos = obj.getAlunos().getId();
		this.nomeAluno = obj.getAlunos().getNome();
		this.nomeLivro = obj.getLivros().getTitulo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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

	public Integer getLivros() {
		return livros;
	}

	public void setLivros(Integer livros) {
		this.livros = livros;
	}

	public Integer getAlunos() {
		return alunos;
	}

	public void setAlunos(Integer alunos) {
		this.alunos = alunos;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

}
