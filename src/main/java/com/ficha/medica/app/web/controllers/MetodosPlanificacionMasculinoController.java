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


import com.ficha.medica.app.web.models.entities.MetodosPlanificacionMasculino;
import com.ficha.medica.app.web.models.service.IMetodosPlanificacionMasculinoService;


@Controller
@RequestMapping(value="/metodosplanificacionmasculino")
public class MetodosPlanificacionMasculinoController {

	@Autowired
	private IMetodosPlanificacionMasculinoService service;
		
	@GetMapping(value="/create")
	public String create(Model model) {
		MetodosPlanificacionMasculino metodosplanificacionmasculino = new MetodosPlanificacionMasculino();
		model.addAttribute("title", "Registro de un Método de Planificación Familiar Masculino");
		model.addAttribute("metodosplanificacionmasculino", metodosplanificacionmasculino);
		return "metodosplanificacionmasculino/form";		
	}
		
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		MetodosPlanificacionMasculino metodosplanificacionmasculino = service.findById(id);
		model.addAttribute("metodosplanificacionmasculino", metodosplanificacionmasculino);
		return "metodosplanificacionmasculino/card";		
	} 
		
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		MetodosPlanificacionMasculino metodosplanificacionmasculino = service.findById(id);
		model.addAttribute("title", "Actualizando el registro de " + metodosplanificacionmasculino.getNombre());
		model.addAttribute("metodosplanificacionmasculino", metodosplanificacionmasculino);
		return "metodosplanificacionmasculino/form";		
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
		return "redirect:/metodosplanificacionmasculino/list";		
	} 
		
	@PostMapping(value="/save")
	public String save(MetodosPlanificacionMasculino metodosplanificacionmasculino, Model model,
			RedirectAttributes flash) {
		try {
			service.save(metodosplanificacionmasculino);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/metodosplanificacionmasculino/list";		
	} 
		
	@GetMapping(value="/list")
	public String list(Model model) {
		List<MetodosPlanificacionMasculino> lista = service.findAll();
		model.addAttribute("title", "Listado de Métodos de Planificación Familiar Masculino");
		model.addAttribute("lista", lista);
		return "metodosplanificacionmasculino/list";		
	}
	
}
