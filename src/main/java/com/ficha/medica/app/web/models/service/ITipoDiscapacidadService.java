package com.ficha.medica.app.web.models.service;

import java.util.List;

 
import com.ficha.medica.app.web.models.entities.TipoDiscapacidad;

public interface ITipoDiscapacidadService {
	public void save(TipoDiscapacidad tipoDiscapacidad);
	public TipoDiscapacidad findById(Integer id);
	public void delete(Integer id);
	public List<TipoDiscapacidad> findAll();

}
