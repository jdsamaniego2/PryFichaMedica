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
@Table(name = "CATALOGOSEGURO")
public class CatalogoSeguro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDCATALOGOSEGURO")
	private Integer idcatalogoseguro;
	
	@Column(name="NOMBRE")	
	@Size(max=100)
	private String nombre;
			
	@Column(name="TIPOSEGURO")
	@Size(max=100)
	private String tipoSeguro;
	 
	
	
	public CatalogoSeguro() {
		super();
	}
	
	public CatalogoSeguro(Integer id) {
		super();
		this.idcatalogoseguro = id;
	}

	public Integer getIdcatalogoseguro() {
		return idcatalogoseguro;
	}

	public void setIdcatalogoseguro(Integer idcatalogoseguro) {
		this.idcatalogoseguro = idcatalogoseguro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoSeguro() {
		return tipoSeguro;
	}

	public void setTipoSeguro(String tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}

	 
	 
	

}
