package com.ficha.medica.app.web.models.service;

import com.ficha.medica.app.web.models.dao.ICatalogoExamenComplementario;
import com.ficha.medica.app.web.models.entities.CatalogoExamenenComplementario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CatalogoExamenComplementarioService implements ICatalogoExamenComplementarioService{

    @Autowired
    private ICatalogoExamenComplementario dao;

    @Override
    @Transactional
    public void save(CatalogoExamenenComplementario catalogoExamenenComplementario) {
        dao.save(catalogoExamenenComplementario);
    }

    @Override
    @Transactional(readOnly=true)
    public CatalogoExamenenComplementario findById(Integer id) {
        return dao.findById(id).get();
    }

    @Override
    public void deleteById(Integer id) {
            dao.deleteById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public List<CatalogoExamenenComplementario> findAll() {
        return (List<CatalogoExamenenComplementario>) dao.findAll();
    }

}
