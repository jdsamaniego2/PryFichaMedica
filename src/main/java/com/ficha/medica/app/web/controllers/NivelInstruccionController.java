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

import com.ficha.medica.app.web.models.entities.NivelInstruccion;
import com.ficha.medica.app.web.models.service.INivelInstruccionService;

@Controller
@RequestMapping(value="/nivelinstruccion")
public class NivelInstruccionController {
	@Autowired
	private INivelInstruccionService service;
	
	
	@GetMapping(value="/create")
	public String create(Model model) {
		NivelInstruccion nivelInstruccion = new NivelInstruccion();
		model.addAttribute("title", "Registro de un nuevo tipo de instruccion");
		model.addAttribute("nivelInstruccion", nivelInstruccion);
		return "nivelinstruccion/form";		
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		NivelInstruccion nivelInstruccion = service.findById(id);
		model.addAttribute("nivelInstruccion", nivelInstruccion);
		return "nivelinstruccion/card";		
	} 
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		NivelInstruccion nivelInstruccion = service.findById(id);
		model.addAttribute("title", "Actualizando nivel de instrucción " + nivelInstruccion.getNombre());
		model.addAttribute("nivelInstruccion", nivelInstruccion);
		return "nivelinstruccion/form";		
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
		return "redirect:/nivelinstruccion/list";		
	} 
	
	@PostMapping(value="/save")
	public String save(NivelInstruccion nivelInstruccion, Model model,
			RedirectAttributes flash) {
		try {
			service.save(nivelInstruccion);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/nivelinstruccion/list";		
	} 
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<NivelInstruccion> lista = service.findAll();
		model.addAttribute("title", "Listado de niveles de instrucción");
		model.addAttribute("lista", lista);
		return "nivelinstruccion/list";		
	} 

}
