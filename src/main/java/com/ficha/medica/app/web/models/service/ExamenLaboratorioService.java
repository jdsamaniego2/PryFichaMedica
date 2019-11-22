package com.ficha.medica.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ficha.medica.app.web.models.dao.IExamenLaboratorio;
import com.ficha.medica.app.web.models.entities.ExamenLaboratorio;

@Service
public class ExamenLaboratorioService implements IExamenLaboratorioService {

	@Autowired 
	private IExamenLaboratorio dao;
	
	@Override
	@Transactional
	public void save(ExamenLaboratorio examenLaboratorio) {
		// TODO Auto-generated method stub
		dao.save(examenLaboratorio);
	}

	@Override
	@Transactional(readOnly=true)
	public ExamenLaboratorio findById(Integer id) {
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
	public List<ExamenLaboratorio> findAll() {
		// TODO Auto-generated method stub
		return (List<ExamenLaboratorio>) dao.findAll();
	}

}
