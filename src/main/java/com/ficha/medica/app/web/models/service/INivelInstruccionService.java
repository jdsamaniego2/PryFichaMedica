package com.ficha.medica.app.web.models.service;

import java.util.List;

import com.ficha.medica.app.web.models.entities.NivelInstruccion;

public interface INivelInstruccionService {
	public void save(NivelInstruccion nivelInstruccion);
	public NivelInstruccion findById(Integer id);
	public void delete(Integer id);
	public List<NivelInstruccion> findAll();

}
