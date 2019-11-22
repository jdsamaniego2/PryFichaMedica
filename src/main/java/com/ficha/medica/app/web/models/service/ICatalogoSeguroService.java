package com.ficha.medica.app.web.models.service;

import java.util.List;

import com.ficha.medica.app.web.models.entities.CatalogoSeguro;


public interface ICatalogoSeguroService {

	public void save(CatalogoSeguro catalogoseguro);
	
	public CatalogoSeguro findById(Integer id);
	
	public void delete(Integer id);
	
	public List<CatalogoSeguro> findAll();
}
