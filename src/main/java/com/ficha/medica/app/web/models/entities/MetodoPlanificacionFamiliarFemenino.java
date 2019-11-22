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
@Table(name = "METODOPLANIFICACIONFAMILIARFEMENINO")
public class MetodoPlanificacionFamiliarFemenino implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	//MPFFEMENINO---> METODOPLANIFICACIONFAMILIARFEMENINO
	@Column(name="IDMPFFEMENINO")
	private Integer idmpffemenino;
	
	@Column(name = "NOMBRE")
	@Size(max=50)
	private String nombre;
	

	
	public MetodoPlanificacionFamiliarFemenino() {
		super();
	}


	public MetodoPlanificacionFamiliarFemenino(Integer idmpffemenino) {
		super();
		this.idmpffemenino = idmpffemenino;
	}

	
	public Integer getIdmpffemenino() {
		return idmpffemenino;
	}


	public void setIdmpffemenino(Integer idmpffemenino) {
		this.idmpffemenino = idmpffemenino;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	

}
