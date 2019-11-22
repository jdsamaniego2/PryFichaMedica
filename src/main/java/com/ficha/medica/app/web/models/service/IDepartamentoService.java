package com.ficha.medica.app.web.models.service;

import java.util.List;

import com.ficha.medica.app.web.models.entities.Departamento;

public interface IDepartamentoService {
	
	public void save(Departamento departamento);
	
	public Departamento findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Departamento> findAll();
}
