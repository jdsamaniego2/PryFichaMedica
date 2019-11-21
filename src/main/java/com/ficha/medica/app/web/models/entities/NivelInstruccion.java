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
@Table(name = "NIVELINSTRUCCION")
public class NivelInstruccion implements Serializable{
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDNIVELINSTRUCCION")
	private Integer idnivelinstruccion;
	
	@Column(name = "NOMBRE")
	@Size(max=45)
	private String nombre;
	
	public NivelInstruccion() {
		super();
	}

	public NivelInstruccion(Integer idnivelinstruccion) {
		super();
		this.idnivelinstruccion = idnivelinstruccion;
	}

	public Integer getIdnivelinstruccion() {
		return idnivelinstruccion;
	}

	public void setIdnivelinstruccion(Integer idnivelinstruccion) {
		this.idnivelinstruccion = idnivelinstruccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
