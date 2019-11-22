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
@Table(name = "METODOSPLANIFICACIONMASCULINO")
public class MetodosPlanificacionMasculino implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "IDMPMASCULINO")
	private Integer idmpmasculino;
	
	@Column(name="NOMBRE")	
	@Size(max = 100)
	private String nombre;
	
	/*CONSTRUCTOR*/
	public MetodosPlanificacionMasculino()
	{
		super();
	}
	
	public MetodosPlanificacionMasculino(Integer idmpmasculino)
	{
		super();
		this.idmpmasculino = idmpmasculino;
	}

	
	/*GETTERS AND SETTERS*/
	
	public Integer getIdmpmasculino() {
		return idmpmasculino;
	}

	public void setIdmpmasculino(Integer idmpmasculino) {
		this.idmpmasculino = idmpmasculino;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
