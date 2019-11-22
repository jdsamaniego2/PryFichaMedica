package com.ficha.medica.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ficha.medica.app.web.models.dao.IMetodoPlanificacionFamiliarFemenino;
import com.ficha.medica.app.web.models.entities.MetodoPlanificacionFamiliarFemenino;


@Service
public class MetodoPlanificacionFamiliarFemeninoService implements IMetodoPlanificacionFamiliarFemeninoService{

	@Autowired 
	private IMetodoPlanificacionFamiliarFemenino dao;
	
	@Override
	@Transactional
	public void save(MetodoPlanificacionFamiliarFemenino mpfFemenino) {
		dao.save(mpfFemenino);
		
	}

	@Override
	@Transactional(readOnly=true)
	public MetodoPlanificacionFamiliarFemenino findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);	
	}

	@Override
	@Transactional(readOnly=true)
	public List<MetodoPlanificacionFamiliarFemenino> findAll() {
		return (List<MetodoPlanificacionFamiliarFemenino>) dao.findAll();
	}

}
