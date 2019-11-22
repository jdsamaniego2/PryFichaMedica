package com.ficha.medica.app.web.models.service;

import com.ficha.medica.app.web.models.entities.CatalogoExamenenComplementario;
import com.ficha.medica.app.web.models.entities.CatalogoSeguro;

import java.util.List;

public interface ICatalogoExamenComplementarioService  {

    public void save(CatalogoExamenenComplementario catalogoExamenenComplementario);

    public CatalogoExamenenComplementario findById(Integer id);

    public void deleteById(Integer id);

    public List<CatalogoExamenenComplementario> findAll();
}
