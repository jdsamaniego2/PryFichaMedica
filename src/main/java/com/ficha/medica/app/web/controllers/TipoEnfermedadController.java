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

import com.ficha.medica.app.web.models.entities.TipoEnfermedad;
import com.ficha.medica.app.web.models.service.ITipoEnfermedadService;

@Controller
@RequestMapping(value="/tipoenfermedad")
public class TipoEnfermedadController {
	
	@Autowired
	private ITipoEnfermedadService service;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		TipoEnfermedad tipoEnfermedad = new TipoEnfermedad();
		model.addAttribute("title", "Registro de un nuevo tipo de enfermedad");
		model.addAttribute("tipoEnfermedad", tipoEnfermedad);
		return "tipoenfermedad/form";		
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		TipoEnfermedad tipoEnfermedad = service.findById(id);
		model.addAttribute("tipoEnfermedad", tipoEnfermedad);
		return "tipoenfermedad/card";		
	} 
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		TipoEnfermedad tipoEnfermedad = service.findById(id);
		model.addAttribute("title", "Actualizando el registro de " 
		+ tipoEnfermedad.getNombre());
		model.addAttribute("tipoEnfermedad", tipoEnfermedad);
		return "tipoenfermedad/form";		
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
		return "redirect:/tipoenfermedad/list";		
	} 
	
	@PostMapping(value="/save")
	public String save(TipoEnfermedad tipoEnfermedad, Model model,
			RedirectAttributes flash) {
		try {
			service.save(tipoEnfermedad);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/tipoenfermedad/list";		
	} 
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<TipoEnfermedad> lista = service.findAll();
		model.addAttribute("title", "Listado de tipos de enfermedades");
		model.addAttribute("lista", lista);
		return "tipoenfermedad/list";		
	} 

}
