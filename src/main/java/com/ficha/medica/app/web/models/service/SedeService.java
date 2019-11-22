package com.ficha.medica.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ficha.medica.app.web.models.dao.ISede;
import com.ficha.medica.app.web.models.entities.Sede;

@Service
public class SedeService implements ISedeService {
	
	@Autowired
	private ISede dao;
	
	@Override
	@Transactional
	public void save(Sede sede) {
		dao.save(sede);
	}

	@Override
	@Transactional
	public Sede findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	@Transactional
	public List<Sede> findAll() {
		return (List<Sede>)dao.findAll();
	}


}
