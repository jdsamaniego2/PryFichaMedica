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
@Table(name="TIPOINCIDENCIA")
public class TipoIncidencia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDTIPOINCIDENCIA")
	private Integer idtipoincidencia;
	
	@Column(name = "NOMBRE")
	@Size(max=45)
	private String nombre;
	

	public TipoIncidencia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getIdtipoincidencia() {
		return idtipoincidencia;
	}

	public void setIdtipoincidencia(Integer idtipoincidencia) {
		this.idtipoincidencia = idtipoincidencia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
