package com.ficha.medica.app.web.models.service;

import java.util.List;
import com.ficha.medica.app.web.models.entities.CasoEmergencia;

public interface ICasoEmergenciaService {
	public void save(CasoEmergencia casoEmergencia);
	public CasoEmergencia findById(Integer id);
	public void delete(Integer id);
	public List<CasoEmergencia> findAll();
}
