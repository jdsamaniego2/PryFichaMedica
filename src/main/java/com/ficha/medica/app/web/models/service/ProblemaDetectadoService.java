package com.ficha.medica.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ficha.medica.app.web.models.dao.IProblemaDetectado;
import com.ficha.medica.app.web.models.entities.ProblemaDetectado;

@Service
public class ProblemaDetectadoService implements IProblemaDetectadoService{

	@Autowired 
	private IProblemaDetectado dao;
	
	@Override
	@Transactional
	public void save(ProblemaDetectado problemadetectado) {
		dao.save(problemadetectado);
		
	}

	@Override
	@Transactional(readOnly=true)
	public ProblemaDetectado findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);	
	}

	@Override
	@Transactional(readOnly=true)
	public List<ProblemaDetectado> findAll() {
		return (List<ProblemaDetectado>)dao.findAll();
	}
}
