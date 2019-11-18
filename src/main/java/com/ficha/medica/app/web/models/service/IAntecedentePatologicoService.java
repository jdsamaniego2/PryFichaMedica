package com.ficha.medica.app.web.models.service;

import java.util.List;
import com.ficha.medica.app.web.models.entities.AntecedentePatologico;

public interface IAntecedentePatologicoService {
	public void save(AntecedentePatologico antecedentePatologico);
	public AntecedentePatologico findById(Integer id);
	public void delete(Integer id);
	public List<AntecedentePatologico> findAll();
}
