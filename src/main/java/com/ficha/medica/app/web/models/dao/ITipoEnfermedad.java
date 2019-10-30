package com.ficha.medica.app.web.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ficha.medica.app.web.models.entities.TipoEnfermedad;

public interface ITipoEnfermedad extends CrudRepository<TipoEnfermedad, Integer> {

}
