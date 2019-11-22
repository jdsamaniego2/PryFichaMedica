package com.ficha.medica.app.web.models.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PAIS")
public class Pais {

	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDPAIS")
	private Integer idpais;
	
	@Column(name="NOMBRE")
	@Size(max=100)
	private String nombre;
	
	@Column(name="NACIONALIDAD")
	@Size(max=100)
	private String nacionalidad;

	public Pais() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Pais(Integer idpais) {
		super();
		this.idpais = idpais;
		
	}
	
	public Integer getIdpais() {
		return idpais;
	}

	public void setIdpais(Integer idpais) {
		this.idpais = idpais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
