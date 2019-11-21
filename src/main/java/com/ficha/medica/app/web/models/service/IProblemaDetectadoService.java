package com.ficha.medica.app.web.models.service;

import java.util.List;

import com.ficha.medica.app.web.models.entities.ProblemaDetectado;

public interface IProblemaDetectadoService {
	public void save(ProblemaDetectado problemadetectado);
	public ProblemaDetectado findById(Integer id);
	public void delete(Integer id);
	public List<ProblemaDetectado> findAll();
}
