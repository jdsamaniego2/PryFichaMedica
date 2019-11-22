package com.ficha.medica.app.web.models.dao;

import com.ficha.medica.app.web.models.entities.CasoEmergencia;
import com.ficha.medica.app.web.models.entities.CatalogoExamenenComplementario;
import org.springframework.data.repository.CrudRepository;

public interface ICatalogoExamenComplementario extends CrudRepository<CatalogoExamenenComplementario, Integer> {
}
