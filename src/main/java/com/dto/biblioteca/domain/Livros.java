package com.dto.biblioteca.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.dto.biblioteca.domain.dtos.LivroDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Livros implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@OneToMany(mappedBy = "livros")
	private List<Emprestimo> emprestimos = new ArrayList<>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String titulo;
	private String autor;
	private String categoria;
	private Integer ano;
	private Integer exemplares;

	public Livros() {
		super();
	}

	public Livros(Integer id, String titulo, String autor, String categoria, Integer ano, Integer exemplares) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.categoria = categoria;
		this.ano = ano;
		this.exemplares = exemplares;
	}

	public Livros(LivroDTO obj) {
		super();
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
		this.autor = obj.getAutor();
		this.categoria = obj.getCategoria();
		this.ano = obj.getAno();
		this.exemplares = obj.getExemplares();
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getExemplares() {
		return exemplares;
	}

	public void setExemplares(Integer exemplares) {
		this.exemplares = exemplares;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livros other = (Livros) obj;
		return Objects.equals(id, other.id);
	}

}
