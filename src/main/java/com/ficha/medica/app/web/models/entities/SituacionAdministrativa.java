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
@Table(name = "SITUACIONADMINISTRATIVA")
public class SituacionAdministrativa implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDSITUACIONADMINISTRATIVA")
	private Integer idsituacionadministrativa;
	@Column(name = "DESCRIPCION")
	@Size(max=255)
	private String descripcion;
	public Integer getIdsituacionadministrativa() {
		return idsituacionadministrativa;
	}

	public void setIdsituacionadministrativa(Integer idsituacionadministrativa) {
		this.idsituacionadministrativa = idsituacionadministrativa;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public SituacionAdministrativa() {
		super();
	}
	
	public SituacionAdministrativa(Integer id) {
		super();
		this.idsituacionadministrativa = id;
	}
}
