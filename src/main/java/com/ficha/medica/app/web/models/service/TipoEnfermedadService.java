package com.ficha.medica.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ficha.medica.app.web.models.dao.ITipoEnfermedad;
import com.ficha.medica.app.web.models.entities.TipoEnfermedad;

@Service
public class TipoEnfermedadService implements ITipoEnfermedadService {

	@Autowired //Inyección de dependencia
	private ITipoEnfermedad dao;
		
	@Override
	@Transactional
	public void save(TipoEnfermedad tipoEnfermedad) {
		dao.save(tipoEnfermedad);		
	}

	@Override
	@Transactional(readOnly=true)
	public TipoEnfermedad findById(Integer id) {		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);		
	}

	@Override
	@Transactional(readOnly=true)
	public List<TipoEnfermedad> findAll() {
		return (List<TipoEnfermedad>) dao.findAll();
	}
		

}








