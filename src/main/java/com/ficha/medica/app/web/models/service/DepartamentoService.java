package com.ficha.medica.app.web.models.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ficha.medica.app.web.models.dao.IDepartamento;
import com.ficha.medica.app.web.models.entities.Departamento;

@Service
public class DepartamentoService implements IDepartamentoService{

	@Autowired
	
	private IDepartamento dao;
	
	@Override
	@Transactional
	public void save(Departamento departamento) {
		// TODO Auto-generated method stub
		dao.save(departamento);
	}

	@Override
	@Transactional(readOnly=true)
	public Departamento findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Departamento> findAll() {
		// TODO Auto-generated method stub
		return (List<Departamento>)dao.findAll();
	}

}