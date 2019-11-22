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
import com.ficha.medica.app.web.models.entities.Pais;
import com.ficha.medica.app.web.models.service.IPaisService;

@Controller
@RequestMapping(value="/pais")
public class PaisController {

	@Autowired
	private IPaisService service;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		Pais pais = new Pais();
		model.addAttribute("title", "Registro de un Pais");
		model.addAttribute("pais", pais);
		return "pais/form";		
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Pais pais = service.findById(id);
		model.addAttribute("pais", pais);
		return "pais/card";		
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Pais pais = service.findById(id);
		model.addAttribute("title", "Actualizando el registro de " 
		+ pais.getNombre());
		model.addAttribute("pais", pais);
		return "pais/form";		
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
		return "redirect:/pais/list";		
	} 
	
	@PostMapping(value="/save")
	public String save(Pais pais, Model model,
			RedirectAttributes flash) {
		try {
			service.save(pais);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/pais/list";		
	} 
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Pais> lista = service.findAll();
		model.addAttribute("title", "Listado de Paises");
		model.addAttribute("lista", lista);
		return "pais/list";		
	}
	
}
