package com.ficha.medica.app.web.models.service;

import java.util.List;

import com.ficha.medica.app.web.models.entities.TipoIncidencia;



public interface ITipoIncidenciaService {

public void save(TipoIncidencia tipoIncidencia);
	
	public TipoIncidencia findById(Integer id);
	
	public void delete(Integer id);
	
	public List<TipoIncidencia> findAll();	
	
}
