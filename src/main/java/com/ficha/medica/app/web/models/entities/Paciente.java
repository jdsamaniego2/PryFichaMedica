package com.ficha.medica.app.web.models.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PACIENTE")
public class Paciente extends Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="TRANSFUCIONES")	
	private Boolean transfuciones;
			
	@Column(name="LATERALIDAD")
	@Size(max=1)
	private String lateralidad;
	
	@Column(name="GRUPOSANGUINEO")
	@Size(max=3)
	private String grupoSanginueo;
		
	@OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
	private List<CasoEmergencia> casosEmergencia;
		
	//Bitácora
	@Column(name="CREADOPOR")
	@Size(max=35)
	private String creadoPor;
	
	@Column(name="CREADOEN")
	private LocalDateTime creadoEn;

	public Paciente() {
		super();
	}
	
	public Paciente(Integer id) {
		super();
		this.setIdpersona(id);
	}
	
	
	public Boolean getTransfuciones() {
		return transfuciones;
	}

	public void setTransfuciones(Boolean transfuciones) {
		this.transfuciones = transfuciones;
	}

	public String getLateralidad() {
		return lateralidad;
	}

	public void setLateralidad(String lateralidad) {
		this.lateralidad = lateralidad;
	}

	public String getGrupoSanginueo() {
		return grupoSanginueo;
	}

	public void setGrupoSanginueo(String grupoSanginueo) {
		this.grupoSanginueo = grupoSanginueo;
	}

	public String getCreadoPor() {
		return creadoPor;
	}

	public void setCreadoPor(String creadoPor) {
		this.creadoPor = creadoPor;
	}

	public LocalDateTime getCreadoEn() {
		return creadoEn;
	}

	public void setCreadoEn(LocalDateTime creadoEn) {
		this.creadoEn = creadoEn;
	}

	public List<CasoEmergencia> getCasosEmergencia() {
		return casosEmergencia;
	}

	public void setCasosEmergencia(List<CasoEmergencia> casosEmergencia) {
		this.casosEmergencia = casosEmergencia;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
