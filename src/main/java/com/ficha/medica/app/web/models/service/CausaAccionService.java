package com.ficha.medica.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ficha.medica.app.web.models.dao.ICausaAccion;
import com.ficha.medica.app.web.models.entities.CausaAccion;

@Service
public class CausaAccionService implements ICausaAccionService {

	@Autowired 
	private ICausaAccion dao;
	
	@Override
	@Transactional
	public void save(CausaAccion causaaccion) {
		// TODO Auto-generated method stub
		dao.save(causaaccion);
	}

	@Override
	@Transactional(readOnly=true)
	public CausaAccion findById(Integer id) {
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
	public List<CausaAccion> findAll() {
		// TODO Auto-generated method stub
		return (List<CausaAccion>) dao.findAll();
	}

}
