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

import com.ficha.medica.app.web.models.entities.ExamenLaboratorio;
import com.ficha.medica.app.web.models.service.IExamenLaboratorioService;

@Controller
@RequestMapping(value="/examenlaboratorio")
public class ExamenLaboratorioController {
	@Autowired
	private IExamenLaboratorioService service;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		ExamenLaboratorio examenLaboratorio = new ExamenLaboratorio();
		model.addAttribute("title", "Registro de un nuevo Examen de Laboratorio");
		model.addAttribute("examenLaboratorio", examenLaboratorio);
		return "examenlaboratorio/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		ExamenLaboratorio examenLaboratorio = service.findById(id);
		model.addAttribute("examenLaboratorio", examenLaboratorio);
		return "examenlaboratorio/card";		
	} 
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		ExamenLaboratorio examenLaboratorio = service.findById(id);
		model.addAttribute("title", "Actualizando el registro de " 
		+ examenLaboratorio.getNombre());
		model.addAttribute("examenLaboratorio", examenLaboratorio);
		return "examenlaboratorio/form";		
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
		return "redirect:/examenlaboratorio/list";		
	} 
	
	@PostMapping(value="/save")
	public String save(ExamenLaboratorio examenLaboratorio, Model model,
			RedirectAttributes flash) {
		try {
			service.save(examenLaboratorio);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/examenlaboratorio/list";		
	} 
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<ExamenLaboratorio> lista = service.findAll();
		model.addAttribute("title", "Listado de Examenes de Laboratorio");
		model.addAttribute("lista", lista);
		return "examenlaboratorio/list";		
	} 
}
	
