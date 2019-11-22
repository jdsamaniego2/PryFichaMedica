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
@Table(name = "EXAMENLABORATORIO")
public class ExamenLaboratorio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDEXAMENLABORATORIO")
	private Integer idexamenlaboratorio;
	
	@Column(name = "NOMBRE")
	@Size(max=50)
	private String nombre;
	
	@Column(name = "UNIDAD")
	@Size(max=50)
	private String unidad;

	public ExamenLaboratorio() {
		super();
	}

	public ExamenLaboratorio(Integer id) {
		super();
		this.idexamenlaboratorio = id;
	}

	public Integer getIdexamenlaboratorio() {
		return idexamenlaboratorio;
	}

	public void setIdexamenlaboratorio(Integer idexamenlaboratorio) {
		this.idexamenlaboratorio = idexamenlaboratorio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	
}
