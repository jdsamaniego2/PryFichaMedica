package com.ficha.medica.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ficha.medica.app.web.models.dao.ICatalogoSeguro;
import com.ficha.medica.app.web.models.entities.CatalogoSeguro;
@Service
public class CatalogoSeguroService implements ICatalogoSeguroService {

	@Autowired 
	private ICatalogoSeguro dao;
	@Override
	@Transactional
	public void save(CatalogoSeguro catalogoseguro) {
		dao.save(catalogoseguro);		
	}

	@Override
	@Transactional(readOnly=true)
	public CatalogoSeguro findById(Integer id) {		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);		
	}

	@Override
	@Transactional(readOnly=true)
	public List<CatalogoSeguro> findAll() {
		return (List<CatalogoSeguro>) dao.findAll();
	}
		
}

