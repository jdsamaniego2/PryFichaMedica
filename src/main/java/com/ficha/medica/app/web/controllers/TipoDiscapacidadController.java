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

import com.ficha.medica.app.web.models.entities.TipoDiscapacidad;
import com.ficha.medica.app.web.models.service.ITipoDiscapacidadService;

@Controller
@RequestMapping(value="/tipodiscapacidad")
public class TipoDiscapacidadController {
	
	@Autowired
	private ITipoDiscapacidadService service;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		TipoDiscapacidad tipoDiscapacidad = new TipoDiscapacidad();
		model.addAttribute("title", "Registro de un nuevo tipo de discapacidad");
		model.addAttribute("tipoDiscapacidad", tipoDiscapacidad);
		return "tipodiscapacidad/form";		
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		TipoDiscapacidad tipoDiscapacidad = service.findById(id);
		model.addAttribute("tipoDiscapacidad", tipoDiscapacidad);
		return "tipodiscapacidad/card";		
	} 
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		TipoDiscapacidad tipoDiscapacidad = service.findById(id);
		model.addAttribute("title", "Actualizando el registro de " 
		+ tipoDiscapacidad.getNombre());
		model.addAttribute("tipoDiscapacidad", tipoDiscapacidad);
		return "tipodiscapacidad/form";		
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
		return "redirect:/tipodiscapacidad/list";		
	} 
	
	@PostMapping(value="/save")
	public String save(TipoDiscapacidad tipoDiscapacidad, Model model,
			RedirectAttributes flash) {
		try {
			service.save(tipoDiscapacidad);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/tipodiscapacidad/list";		
	} 
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<TipoDiscapacidad> lista = service.findAll();
		model.addAttribute("title", "Listado de tipos de discapacidades");
		model.addAttribute("lista", lista);
		return "tipodiscapacidad/list";		
	} 
}
