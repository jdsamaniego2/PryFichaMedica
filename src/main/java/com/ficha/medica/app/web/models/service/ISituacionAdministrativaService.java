package com.ficha.medica.app.web.models.service;

import java.util.List;

import com.ficha.medica.app.web.models.entities.SituacionAdministrativa;

public interface ISituacionAdministrativaService {
	public void save(SituacionAdministrativa situacionAdministrativa);
	
	public SituacionAdministrativa findById(Integer id);
	
	public void delete(Integer id);
	
	public List<SituacionAdministrativa> findAll();	
	
}
