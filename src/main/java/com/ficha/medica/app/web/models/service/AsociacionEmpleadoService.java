package com.ficha.medica.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ficha.medica.app.web.models.dao.IAsociacionEmpleado;

import com.ficha.medica.app.web.models.entities.AsociacionEmpleado;


@Service
public class AsociacionEmpleadoService implements IAsociacionEmpleadoService{

	@Autowired 
	private IAsociacionEmpleado dao;
	
	@Override
	@Transactional
	public void save(AsociacionEmpleado asociacionEmpleado) {
		dao.save(asociacionEmpleado);
		
	}

	@Override
	@Transactional(readOnly=true)
	public AsociacionEmpleado findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);	
	}

	@Override
	@Transactional(readOnly=true)
	public List<AsociacionEmpleado> findAll() {
		return (List<AsociacionEmpleado>) dao.findAll();
	}

}
