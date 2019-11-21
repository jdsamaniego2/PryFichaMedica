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
@Table(name = "TIPODISCAPACIDAD")
public class TipoDiscapacidad implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDTIPODISCAPACIDAD")
	private Integer idtipodiscapacidad;
	
	@Column(name = "NOMBRE")
	@Size(max=45)
	private String nombre;
	
	public TipoDiscapacidad() {
		super();
	}

	public TipoDiscapacidad(Integer idtipodiscapacidad) {
		super();
		this.idtipodiscapacidad = idtipodiscapacidad;
	}

	
	public Integer getIdtipodiscapacidad() {
		return idtipodiscapacidad;
	}

	public void setIdtipodiscapacidad(Integer idtipodiscapacidad) {
		this.idtipodiscapacidad = idtipodiscapacidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
