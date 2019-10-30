package com.ficha.medica.app.web.models.service;

import java.util.List;

import com.ficha.medica.app.web.models.entities.TipoEnfermedad;

public interface ITipoEnfermedadService {
		
	//Este método crea un nuevo registro de TipoEnfermedad
	//o actualiza un registro anterior
	public void save(TipoEnfermedad tipoEnfermedad);
	
	public TipoEnfermedad findById(Integer id);
	
	public void delete(Integer id);
	
	public List<TipoEnfermedad> findAll();	
	

}
