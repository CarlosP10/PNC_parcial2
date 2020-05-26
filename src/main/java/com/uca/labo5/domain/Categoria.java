package com.uca.labo5.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "public", name = "cat_categoria")
public class Categoria {
	
	@Id
	@Column(name = "c_categoria")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cCategoria;
	
	@NotEmpty(message = "El campo nombre categoría no puede estar vacío")
	@Size(max = 50, message = "“El campo sobrepasa la cantidad de 50 caracteres")
	@Column(name = "s_categoria")
	private String sCategoria;
	
	public Integer getcCategoria() {
		return cCategoria;
	}
	public void setcCategoria(Integer cCategoria) {
		this.cCategoria = cCategoria;
	}
	public String getsCategoria() {
		return sCategoria;
	}
	public void setsCategoria(String sCategoria) {
		this.sCategoria = sCategoria;
	}
	
	public Categoria() {
		
	}
	
	

}
