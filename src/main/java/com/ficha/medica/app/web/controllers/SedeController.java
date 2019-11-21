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

import com.ficha.medica.app.web.models.entities.Sede;
import com.ficha.medica.app.web.models.service.ISedeService;

@Controller
@RequestMapping(value="/sede")
public class SedeController {
	
	@Autowired
	private ISedeService service;
	
	
	@GetMapping(value="/create")
	public String create(Model model) {
		Sede sede = new Sede();
		model.addAttribute("title", "Registro de una nueva sede");
		model.addAttribute("sede", sede);
		return "sede/form";		
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Sede sede = service.findById(id);
		model.addAttribute("sede", sede);
		return "sede/card";		
	} 
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Sede sede = service.findById(id);
		model.addAttribute("title", "Actualizando el registro de " + sede.getNombre());
		model.addAttribute("sede", sede);
		return "sede/form";		
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
		return "redirect:/sede/list";		
	} 
	
	@PostMapping(value="/save")
	public String save(Sede sede, Model model,
			RedirectAttributes flash) {
		try {
			service.save(sede);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/sede/list";		
	} 
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Sede> lista = service.findAll();
		model.addAttribute("title", "Listado de sedes");
		model.addAttribute("lista", lista);
		return "sede/list";		
	} 

}
