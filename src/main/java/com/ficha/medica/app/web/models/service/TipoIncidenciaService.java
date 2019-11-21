package com.ficha.medica.app.web.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ficha.medica.app.web.models.dao.ITipoIncidencia;
import com.ficha.medica.app.web.models.entities.TipoIncidencia;



@Service
public class TipoIncidenciaService implements ITipoIncidenciaService {
	
		
		@Autowired 
		private ITipoIncidencia dao;
			
		@Override
		@Transactional
		public void save(TipoIncidencia tipoIncidencia) {
			dao.save(tipoIncidencia);		
		}

		@Override
		@Transactional(readOnly=true)
		public TipoIncidencia findById(Integer id) {		
			return dao.findById(id).get();
		}

		@Override
		@Transactional
		public void delete(Integer id) {
			dao.deleteById(id);		
		}

		@Override
		@Transactional(readOnly=true)
		public List<TipoIncidencia> findAll() {
			return (List<TipoIncidencia>) dao.findAll();
		}
		
		
	
}

