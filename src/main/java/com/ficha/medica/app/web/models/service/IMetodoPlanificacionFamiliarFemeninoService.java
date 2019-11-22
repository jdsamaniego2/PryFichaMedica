package com.ficha.medica.app.web.models.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ficha.medica.app.web.models.entities.MetodoPlanificacionFamiliarFemenino;

@Service
public interface IMetodoPlanificacionFamiliarFemeninoService  {

	void save(MetodoPlanificacionFamiliarFemenino mpfFemenino);
	public MetodoPlanificacionFamiliarFemenino findById(Integer id);
	public void delete(Integer id);
	public List<MetodoPlanificacionFamiliarFemenino> findAll();
}
