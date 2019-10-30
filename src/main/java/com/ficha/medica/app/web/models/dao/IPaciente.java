package com.ficha.medica.app.web.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ficha.medica.app.web.models.entities.Paciente;

public interface IPaciente extends CrudRepository<Paciente, Integer> {

}
