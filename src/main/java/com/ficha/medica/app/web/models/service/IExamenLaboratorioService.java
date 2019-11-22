package com.ficha.medica.app.web.models.service;

import java.util.List;

import com.ficha.medica.app.web.models.entities.ExamenLaboratorio;


public interface IExamenLaboratorioService {
	
	public void save(ExamenLaboratorio examenLaboratorio);
	public ExamenLaboratorio findById(Integer id);
	public void delete(Integer id);
	public List<ExamenLaboratorio> findAll();

	
}
