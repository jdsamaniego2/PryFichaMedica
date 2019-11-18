package com.ficha.medica.app.web.models.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table (name = "ANTECEDENTEPATOLOGICO")
public class AntecedentePatologico implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDANTECEDENTEPATOLOGICO")
	private Integer idantecedentepatologico;
	
	
	@Column(name="FECHADIAGNOSTICO")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	private Calendar fechadiagnostico;
	
	@Column(name="TOMAMEDICACION")
	@Size(max = 20)
	private String tomamedicacion;
	
	
	@Column(name="DIAGNOSTICO")
	@Size(max = 255)
	private String diagnostico;

	
	
	
	
	@JoinColumn(name = "IDTIPOENFERMEDAD", referencedColumnName = "IDTIPOENFERMEDAD")
	@ManyToOne
	private TipoEnfermedad tipoenfermedad;
	
	@JoinColumn(name = "IDPACIENTE", referencedColumnName = "IDPERSONA")
	@ManyToOne
	private Paciente paciente;
	
	
	
	
	
	
	public TipoEnfermedad getTipo_enfermedad() {
		return tipoenfermedad;
	}
	public void setTipo_enfermedad(TipoEnfermedad tipo_enfermedad) {
		this.tipoenfermedad = tipo_enfermedad;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public AntecedentePatologico() {
		super();
		
	}
	public AntecedentePatologico(Integer id) {
		super();
		idantecedentepatologico = id;
	}


	public Integer getIdantecedentepatologico() {
		return idantecedentepatologico;
	}


	public void setIdantecedentepatologico(Integer idantecedentepatologico) {
		this.idantecedentepatologico = idantecedentepatologico;
	}


	public Calendar getFechadiagnostico() {
		return fechadiagnostico;
	}


	public void setFechadiagnostico(Calendar fechadiagnostico) {
		this.fechadiagnostico = fechadiagnostico;
	}


	public String getTomamedicacion() {
		return tomamedicacion;
	}


	public void setTomamedicacion(String tomamedicacion) {
		this.tomamedicacion = tomamedicacion;
	}


	public String getDiagnostico() {
		return diagnostico;
	}


	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	
	
	
}
