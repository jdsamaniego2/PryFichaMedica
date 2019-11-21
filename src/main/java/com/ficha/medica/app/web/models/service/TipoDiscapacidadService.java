package com.ficha.medica.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ficha.medica.app.web.models.dao.ITipoDiscapacidad;
import com.ficha.medica.app.web.models.entities.TipoDiscapacidad;

@Service
public class TipoDiscapacidadService implements ITipoDiscapacidadService{

	@Autowired 
	private ITipoDiscapacidad dao;
		
	@Override
	@Transactional
	public void save(TipoDiscapacidad tipoDiscapacidad) {
		dao.save(tipoDiscapacidad);		
	}

	@Override
	@Transactional(readOnly=true)
	public TipoDiscapacidad findById(Integer id) {		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);		
	}

	@Override
	@Transactional(readOnly=true)
	public List<TipoDiscapacidad> findAll() {
		return (List<TipoDiscapacidad>) dao.findAll();
	}
}
