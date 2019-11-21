package com.ficha.medica.app.web.models.service;

import java.util.List;

import com.ficha.medica.app.web.models.entities.CausaAccion;


public interface ICausaAccionService {
	public void save(CausaAccion causaaccion);
	public CausaAccion findById(Integer id);
	public void delete(Integer id);
	public List<CausaAccion> findAll();
}
