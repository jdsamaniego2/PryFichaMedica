package com.ficha.medica.app.web.models.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROBLEMADETECTADO")
public class ProblemaDetectado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDPROBLEMADETECTADO")
	private Integer idproblemadetectado;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;

	public ProblemaDetectado() {
		super();
	}

	public ProblemaDetectado(Integer idproblemadetectado, String descripcion) {
		super();
		this.idproblemadetectado = idproblemadetectado;
		this.descripcion = descripcion;
	}

	public Integer getIdproblemadetectado() {
		return idproblemadetectado;
	}

	public void setIdproblemadetectado(Integer idproblemadetectado) {
		this.idproblemadetectado = idproblemadetectado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
