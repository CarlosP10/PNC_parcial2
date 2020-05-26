package com.uca.labo5.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "importancia")
public class Importancia {
	@Id
	@Column(name = "c_importancia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer c_impor;
	
	@Column(name = "s_importancia")
	private String s_impor;

	public Integer getC_impor() {
		return c_impor;
	}
	public void setC_impor(Integer c_impor) {
		this.c_impor = c_impor;
	}
	public String getS_impor() {
		return s_impor;
	}
	public void setS_impor(String s_impor) {
		this.s_impor = s_impor;
	}
	
	public Importancia() {
		
	}
	
	

}
