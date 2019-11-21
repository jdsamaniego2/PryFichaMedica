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

import com.ficha.medica.app.web.models.entities.SituacionAdministrativa;
import com.ficha.medica.app.web.models.service.ISituacionAdministrativaService;

@Controller
@RequestMapping(value="/situacionadministrativa")
public class SituacionAdministrativaController {
	@Autowired
	private ISituacionAdministrativaService service;
	@GetMapping(value="/create")
	public String create(Model model) {
		SituacionAdministrativa situacionadministrativa = new SituacionAdministrativa();
		model.addAttribute("title", "Registro de una nueva situacion administrativa");
		model.addAttribute("situacionadministrativa", situacionadministrativa);
		return "situacionadministrativa/form";		
		
	}
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		SituacionAdministrativa situacionadministrativa = service.findById(id);
		model.addAttribute("situacionadministrativa", situacionadministrativa);
		return "situacionadministrativa/card";		
	} 
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		SituacionAdministrativa situacionadministrativa = service.findById(id);
		model.addAttribute("title", "Actualizando el registro de " 
		+ situacionadministrativa.getDescripcion());
		model.addAttribute("situacionadministrativa", situacionadministrativa);
		return "situacionadministrativa/form";		
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
		return "redirect:/situacionadministrativa/list";		
	} 
	
	@PostMapping(value="/save")
	public String save(SituacionAdministrativa situacionadministrativa, Model model,
			RedirectAttributes flash) {
		try {
			service.save(situacionadministrativa);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/situacionadministrativa/list";		
	} 
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<SituacionAdministrativa> lista = service.findAll();
		model.addAttribute("title", "Listado de situaciones administrativas");
		model.addAttribute("lista", lista);
		return "situacionadministrativa/list";		
	} 
}
