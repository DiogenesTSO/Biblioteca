package com.dto.biblioteca.domain.dtos;

import java.io.Serializable;

import com.dto.biblioteca.domain.Livros;

public class LivroDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String titulo;
	private String autor;
	private String categoria;
	private Integer ano;
	private Integer exemplares;

	public LivroDTO() {
		super();
	}

	public LivroDTO(Integer id, String titulo, String autor, String categoria, Integer ano, Integer exemplares) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.categoria = categoria;
		this.ano = ano;
		this.exemplares = exemplares;
	}

	public LivroDTO(Livros obj) {
		super();
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
		this.autor = obj.getAutor();
		this.categoria = obj.getCategoria();
		this.ano = obj.getAno();
		this.exemplares = obj.getExemplares();
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

}
