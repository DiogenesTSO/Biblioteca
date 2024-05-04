package com.dto.biblioteca.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import com.dto.biblioteca.domain.Alunos;
import com.dto.biblioteca.domain.enums.Perfil;
import com.dto.biblioteca.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

public class AlunoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer matricula;
	private String nome;
	private String usuario;
	private String senha;
	private Status status;
	private Set<Integer> perfis = new HashSet<>();

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCriacao = LocalDate.now();

	public AlunoDTO() {
		super();
		addPerfil(Perfil.ALUNO);
	}

	public AlunoDTO(Alunos obj) {
		super();
		this.id = obj.getId();
		this.matricula = obj.getMatricula();
		this.nome = obj.getNome();
		this.usuario = obj.getUsuario();
		this.senha = obj.getSenha();
		this.status = obj.getStatus();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();
		addPerfil(Perfil.ALUNO);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEdum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		this.perfis.add(perfil.getCodigo());
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

}
