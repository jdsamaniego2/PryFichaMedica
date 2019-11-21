package com.ficha.medica.app.web.models.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ASOCIACIONEMPLEADO")
public class AsociacionEmpleado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDASOCIACIONEMPLEADO")
	private Integer idasociacionempleado;
	
	@Column(name = "NOMBRE")
	@Size(max=50)
	private String nombre;
	
	public AsociacionEmpleado() {
		super();
	}

	public AsociacionEmpleado(Integer idasociacionempleado) {
		super();
		this.idasociacionempleado = idasociacionempleado;
	}

	public Integer getIdasociacionempleado() {
		return idasociacionempleado;
	}

	public void setIdasociacionempleado(Integer idasociacionempleado) {
		this.idasociacionempleado = idasociacionempleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
}
