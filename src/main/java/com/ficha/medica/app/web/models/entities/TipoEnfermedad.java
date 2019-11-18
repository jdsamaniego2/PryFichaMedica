package com.ficha.medica.app.web.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TIPOENFERMEDAD")
public class TipoEnfermedad implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDTIPOENFERMEDAD")
	private Integer idtipoenfermedad;
	
	@Column(name = "NOMBRE")
	@Size(max=45)
	private String nombre;
	
	@Column(name = "DESCRIPCION")
	@Size(max=255)
	private String descripcion;
	
	
	@OneToMany(mappedBy = "tipoenfermedad", fetch = FetchType.LAZY)
	private List<AntecedentePatologico> antecedentespatologicos;
	
	
	
	public TipoEnfermedad() {
		super();
	}
	
	public TipoEnfermedad(Integer id) {
		super();
		this.idtipoenfermedad = id;
	}

	public Integer getIdtipoenfermedad() {
		return idtipoenfermedad;
	}

	public void setIdtipoenfermedad(Integer idtipoenfermedad) {
		this.idtipoenfermedad = idtipoenfermedad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	public List<AntecedentePatologico> getAntecedentepatologico() {
		return antecedentespatologicos;
	}
	public void setAntecedentepatologico(List<AntecedentePatologico> antecedentepatologico) {
		this.antecedentespatologicos = antecedentepatologico;
	}
	
	
	

}


















