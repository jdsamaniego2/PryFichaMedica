package com.ficha.medica.app.web.models.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CASOEMERGENCIA")
public class CasoEmergencia implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDCASOEMERGENCIA")
	private Integer idcasoemergencia;
	
	@Column(name="NOMBRE")
	@Size(max=55)
	private String nombre;
	
	@Column(name="PARENTEZO")
	@Size(max=25)
	private String parentezco;
	
	@Column(name="TELEFONOCONVENCIONAL")
	@Size(max=20)
	private String telefonoConvencional;
	
	@Column(name="TELEFONOCELULAR")
	@Size(max=20)
	private String telefonoCelular;
	
	@Column(name="DIRECCION")
	@Size(max=255)
	private String direccion;
	
	@JoinColumn(name = "IDPACIENTE", referencedColumnName = "IDPERSONA")
	@ManyToOne
	private Paciente paciente;
		
	
	public CasoEmergencia() {
		super();
	}
	
	public CasoEmergencia(Integer id) {
		super();
		this.idcasoemergencia = id;
	}

	public Integer getIdcasoemergencia() {
		return idcasoemergencia;
	}

	public void setIdcasoemergencia(Integer idcasoemergencia) {
		this.idcasoemergencia = idcasoemergencia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getParentezco() {
		return parentezco;
	}

	public void setParentezco(String parentezco) {
		this.parentezco = parentezco;
	}

	public String getTelefonoConvencional() {
		return telefonoConvencional;
	}

	public void setTelefonoConvencional(String telefonoConvencional) {
		this.telefonoConvencional = telefonoConvencional;
	}

	public String getTelefonoCelular() {
		return telefonoCelular;
	}

	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	
	
	
	

	
}











