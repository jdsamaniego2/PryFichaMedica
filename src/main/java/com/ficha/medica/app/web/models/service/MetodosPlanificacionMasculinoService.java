package com.ficha.medica.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ficha.medica.app.web.models.dao.IMetodosPlanificacionMasculino;
import com.ficha.medica.app.web.models.entities.MetodosPlanificacionMasculino;

@Service
public class MetodosPlanificacionMasculinoService implements IMetodosPlanificacionMasculinoService{

	@Autowired
	private IMetodosPlanificacionMasculino dao;
	
	@Override
	@Transactional
	public void save(MetodosPlanificacionMasculino mpMasculino) {
		dao.save(mpMasculino);
		
	}

	@Override
	@Transactional(readOnly = true)
	public MetodosPlanificacionMasculino findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);	
	}

	@Override
	@Transactional(readOnly=true)
	public List<MetodosPlanificacionMasculino> findAll() {
		return (List<MetodosPlanificacionMasculino>) dao.findAll();
	}

}
