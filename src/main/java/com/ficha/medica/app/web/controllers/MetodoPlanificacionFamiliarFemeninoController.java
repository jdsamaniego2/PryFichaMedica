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

import com.ficha.medica.app.web.models.entities.MetodoPlanificacionFamiliarFemenino;
import com.ficha.medica.app.web.models.service.IMetodoPlanificacionFamiliarFemeninoService;


@Controller
@RequestMapping(value="/metodoplanificacionfamiliarfemenino")
public class MetodoPlanificacionFamiliarFemeninoController {

	
	@Autowired
	private IMetodoPlanificacionFamiliarFemeninoService service;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		MetodoPlanificacionFamiliarFemenino metodoplanificacionfamiliarfemenino = new MetodoPlanificacionFamiliarFemenino();
		model.addAttribute("title", "Registro de un nuevo Metodo de Planificacion Familiar Femenino");
		model.addAttribute("metodoplanificacionfamiliarfemenino", metodoplanificacionfamiliarfemenino);
		return "metodoplanificacionfamiliarfemenino/form";		
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		MetodoPlanificacionFamiliarFemenino metodoplanificacionfamiliarfemenino = service.findById(id);
		model.addAttribute("metodoplanificacionfamiliarfemenino", metodoplanificacionfamiliarfemenino);
		return "metodoplanificacionfamiliarfemenino/card";		
	} 
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		MetodoPlanificacionFamiliarFemenino metodoplanificacionfamiliarfemenino = service.findById(id);
		model.addAttribute("title", "Actualizando el registro de " 
		+ metodoplanificacionfamiliarfemenino.getNombre());
		model.addAttribute("metodoplanificacionfamiliarfemenino", metodoplanificacionfamiliarfemenino);
		return "metodoplanificacionfamiliarfemenino/form";		
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
		return "redirect:/metodoplanificacionfamiliarfemenino/list";		
	} 
	
	@PostMapping(value="/save")
	public String save(MetodoPlanificacionFamiliarFemenino metodoplanificacionfamiliarfemenino, Model model,
			RedirectAttributes flash) {
		try {
			service.save(metodoplanificacionfamiliarfemenino);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/metodoplanificacionfamiliarfemenino/list";		
	} 
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<MetodoPlanificacionFamiliarFemenino> lista = service.findAll();
		model.addAttribute("title", "Listado de Metodos de Planificacion Familiar Femenino");
		model.addAttribute("lista", lista);
		return "metodoplanificacionfamiliarfemenino/list";		
	} 

	
}
