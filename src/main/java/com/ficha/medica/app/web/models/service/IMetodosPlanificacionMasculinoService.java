package com.ficha.medica.app.web.models.service;

import java.util.List;
import com.ficha.medica.app.web.models.entities.MetodosPlanificacionMasculino;

public interface IMetodosPlanificacionMasculinoService {

	public void save(MetodosPlanificacionMasculino mpMasculino);
	
	public MetodosPlanificacionMasculino findById(Integer id);
	
	public void delete(Integer id);
	
	public List<MetodosPlanificacionMasculino> findAll();
}
