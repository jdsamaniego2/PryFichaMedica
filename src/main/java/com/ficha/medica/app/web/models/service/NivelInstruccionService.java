package com.ficha.medica.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ficha.medica.app.web.models.dao.INivelInstruccion;

import com.ficha.medica.app.web.models.entities.NivelInstruccion;


@Service
public class NivelInstruccionService implements INivelInstruccionService{
	
	@Autowired 
	private INivelInstruccion dao;

	@Override
	@Transactional
	public void save(NivelInstruccion nivelInstruccion) {
		dao.save(nivelInstruccion);		
		
	}

	@Override
	@Transactional(readOnly=true)
	public NivelInstruccion findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<NivelInstruccion> findAll() {
		return (List<NivelInstruccion>) dao.findAll();
	}

}
