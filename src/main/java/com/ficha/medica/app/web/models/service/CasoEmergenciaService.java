package com.ficha.medica.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ficha.medica.app.web.models.dao.ICasoEmergencia;
import com.ficha.medica.app.web.models.entities.CasoEmergencia;

@Service
public class CasoEmergenciaService implements ICasoEmergenciaService{

	@Autowired
	private ICasoEmergencia dao;
	
	@Override
	@Transactional
	public void save(CasoEmergencia casoEmergencia) {
		dao.save(casoEmergencia);
	}

	@Override
	@Transactional
	public CasoEmergencia findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	@Transactional
	public List<CasoEmergencia> findAll() {
		return (List<CasoEmergencia>)dao.findAll();
	}

}
