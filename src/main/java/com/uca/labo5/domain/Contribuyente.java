package com.uca.labo5.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema = "public", name = "contribuyente")
public class Contribuyente {
	
	@Id
	@Column(name = "c_contribuyente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer c_contri;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_importancia")
	private Importancia c_impor;
	
	@Transient
	private Integer c_imporfk;
	
	@Size(min = 1, max = 30, message = "Debe contener de 1 a 30 caracteres")
	@Column(name = "s_nombre")
	private String s_name;
	
	@Size(min = 1, max = 30, message = "Debe contener de 1 a 30 caracteres")
	@Column(name = "s_apellido")
	private String apellido;
	
	@Size(min = 1, max = 14, message = "Debe contener de 1 a 14 caracteres")
	@Column(name = "s_nit")
	private String nit;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "f_fecha_ingreso")
	@Temporal(TemporalType.DATE)
	private Date date;
	
//	private List<Importancia> importancias;
//	
//	public List<Importancia> getImportancias() {
//		return importancias;
//	}
//	public void setImportanciasList(List<Importancia> importanciaList) {
//		this.importancias = importanciaList;
//	}
	
	public Integer getC_importanciafk() {
		return c_imporfk;
	}

	public void setC_importanciafk(Integer c_imporfk) {
		this.c_imporfk = c_imporfk;
	}
//	
	public Integer getC_contri() {
		return c_contri;
	}
	public void setC_contri(Integer c_contri) {
		this.c_contri = c_contri;
	}
	public Importancia getC_impor() {
		return c_impor;
	}
	public void setC_impor(Importancia c_impor) {
		this.c_impor = c_impor;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public String getDate() throws ParseException{
		DateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
		Date date2 = new SimpleDateFormat("yyyy-mm-dd").parse(String.valueOf(date));
		String strDate = formatter.format(date2);
		return strDate;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Contribuyente() {
		
	}
	
	
	

}
