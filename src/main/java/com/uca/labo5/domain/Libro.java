package com.uca.labo5.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema = "public", name = "cat_libro")
public class Libro {
	
	@Id
	@Column(name = "c_libro")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoLibro;
	
	@Column(name = "s_titulo")
	@NotEmpty(message = "No debe estar vacio")
	@Size(max = 500, message = "No debe tener mas de 500 caracteres")
	private String titulo;
	
	@Column(name = "s_autor")
	@NotEmpty(message = "No debe estar vacio")
	@Size(max = 150, message = "No debe tener mas de 150 caracteres")
	private String autor;
	
	@Column(name = "s_isbn")
	@NotEmpty(message = "No debe estar vacio")
	@Size(max = 10, message = "No debe tener mas de 10 caracteres")
	private String isbn;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_categoria")
	private Categoria cCategoria;
	
	@Transient
	private Integer cCategoriafk;
	
	@Column(name = "f_ingreso")
	private LocalDateTime ingreso;
	
	@Column(name = "b_estado")
	private Boolean estado;
	
	public Integer getCodigoLibro() {
		return codigoLibro;
	}
	public void setCodigoLibro(Integer codigoLibro) {
		this.codigoLibro = codigoLibro;
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
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Categoria getcCategoria() {
		return cCategoria;
	}
	public void setcCategoria(Categoria cCategoria) {
		this.cCategoria = cCategoria;
	}
	public LocalDateTime getIngreso(){
		return ingreso;
	}
	public void setIngreso(LocalDateTime ingreso) {
		this.ingreso = ingreso;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	public String getEstadoDelegate() {
		if(this.estado == null) return "";
		else {
			return estado == true ?"Activo":"Inactivo";
		}
	}
	
	public String getFechaDelegate(){
		if(this.ingreso == null){
			return "";
		}
		else{
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
			String shortdate = this.ingreso.format(formatter);
			return shortdate;
		}
    }

    @PrePersist
    public void prePersist(){
        this.ingreso = LocalDateTime.now();
    }
	
	public Libro() {
		
	}
	
	
	

}
