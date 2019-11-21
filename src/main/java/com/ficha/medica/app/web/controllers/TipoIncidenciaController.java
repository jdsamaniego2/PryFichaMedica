package com.ficha.medica.app.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ficha.medica.app.web.models.entities.TipoIncidencia;
import com.ficha.medica.app.web.models.service.ITipoIncidenciaService;

@Controller
@RequestMapping(value="/tipoincidencia")
public class TipoIncidenciaController {
	
	@Autowired
	private ITipoIncidenciaService service;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		TipoIncidencia tipoIncidencia = new TipoIncidencia();
		model.addAttribute("title", "Registro de un nuevo tipo de incidencia");
		model.addAttribute("tipoIncidencia", tipoIncidencia);
		return "tipoincidencia/form";		
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		TipoIncidencia tipoIncidencia = service.findById(id);
		model.addAttribute("tipoIncidencia", tipoIncidencia);
		return "tipoincidencia/card";		
	} 
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		TipoIncidencia tipoIncidencia = service.findById(id);
		model.addAttribute("title", "Actualizando el registro de " 
		+ tipoIncidencia.getNombre());
		model.addAttribute("tipoIncidencia", tipoIncidencia);
		return "tipoincidencia/form";		
	} 
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, 
			RedirectAttributes flash) {
		try {
			service.delete(id);
			flash.addFlashAttribute("success", "El registro fue eliminado con éxito.");
		}	
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser eliminado.");
		}
		return "redirect:/tipoincidencia/list";		
	} 
	
	@PostMapping(value="/save")
	public String save(TipoIncidencia tipoIncidencia, Model model,
			RedirectAttributes flash) {
		try {
			service.save(tipoIncidencia);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/tipoincidencia/list";		
	} 
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<TipoIncidencia> lista = service.findAll();
		model.addAttribute("title", "Listado de tipos de incidencias");
		model.addAttribute("lista", lista);
		return "tipoincidencia/list";		
	} 

}