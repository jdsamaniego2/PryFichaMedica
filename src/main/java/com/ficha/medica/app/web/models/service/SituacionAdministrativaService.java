package com.ficha.medica.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ficha.medica.app.web.models.dao.ISituacionAdministrativa;
import com.ficha.medica.app.web.models.entities.SituacionAdministrativa;

@Service
public class SituacionAdministrativaService implements ISituacionAdministrativaService {
	@Autowired 
	private ISituacionAdministrativa dao;
	@Override
	@Transactional
	public void save(SituacionAdministrativa situacionAdminstrativa) {
		dao.save(situacionAdminstrativa);		
	}
	@Override
	@Transactional(readOnly=true)
	public SituacionAdministrativa findById(Integer id) {		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);		
	}

	@Override
	@Transactional(readOnly=true)
	public List<SituacionAdministrativa> findAll() {
		return (List<SituacionAdministrativa>) dao.findAll();
	}
		
}
