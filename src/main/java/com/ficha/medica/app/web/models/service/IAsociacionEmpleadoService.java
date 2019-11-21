package com.ficha.medica.app.web.models.service;

import java.util.List;

import com.ficha.medica.app.web.models.entities.AsociacionEmpleado;

public interface IAsociacionEmpleadoService {
	public void save(AsociacionEmpleado asociacionEmpleado);
	public AsociacionEmpleado findById(Integer id);
	public void delete(Integer id);
	public List<AsociacionEmpleado> findAll();
}
