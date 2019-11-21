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
@Table(name = "CAUSAACCION")
public class CausaAccion implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="CAUSAACCION")
	private Integer idcausaaccion;
	
	@Column(name = "NOMBRE")
	@Size(max=50)
	private String nombre;
	
	@Column(name = "CAUSA")
	@Size(max=50)
	private String causa;
	
	public CausaAccion() {
		super();
	}

	public CausaAccion(Integer idcausaaccion) {
		super();
		this.idcausaaccion = idcausaaccion;
	}

	public Integer getIdcausaaccion() {
		return idcausaaccion;
	}

	public void setIdcausaaccion(Integer idcausaaccion) {
		this.idcausaaccion = idcausaaccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCausa() {
		return causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}
	
}
