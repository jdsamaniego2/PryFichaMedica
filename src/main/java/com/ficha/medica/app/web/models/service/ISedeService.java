package com.ficha.medica.app.web.models.service;

import java.util.List;
import com.ficha.medica.app.web.models.entities.Sede;

public interface ISedeService {
	
	public void save(Sede sede);
	public Sede findById(Integer id);
	public void delete(Integer id);
	public List<Sede> findAll();

}
