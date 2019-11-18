package com.ficha.medica.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ficha.medica.app.web.models.dao.IAntecedentePatologico;
import com.ficha.medica.app.web.models.entities.AntecedentePatologico;

@Service
public class AntecedentePatologicoService implements IAntecedentePatologicoService {

	@Autowired
	private IAntecedentePatologico dao;
	
	@Override
	@Transactional
	public void save(AntecedentePatologico antecedentePatologico) {
		dao.save(antecedentePatologico);
	}

	@Override
	@Transactional
	public AntecedentePatologico findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	@Transactional
	public List<AntecedentePatologico> findAll() {
		return (List<AntecedentePatologico>)dao.findAll();
	}

}
