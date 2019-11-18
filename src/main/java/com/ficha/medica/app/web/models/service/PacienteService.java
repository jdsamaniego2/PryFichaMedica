package com.ficha.medica.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ficha.medica.app.web.models.dao.IPaciente;
import com.ficha.medica.app.web.models.entities.Paciente;

@Service
public class PacienteService implements IPacienteService{

	@Autowired
	private IPaciente dao;
	
	@Override
	@Transactional
	public void save(Paciente paciente) {
		dao.save(paciente);	
	}

	@Override
	@Transactional
	public Paciente findById(Integer id) {
		return dao.findById(id).get();
	}
	
	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
	}

	@Override
	@Transactional
	public List<Paciente> findAll() {
		return (List<Paciente>)dao.findAll();
	}

}
