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

import com.ficha.medica.app.web.models.entities.ProblemaDetectado;
import com.ficha.medica.app.web.models.service.IProblemaDetectadoService;

@Controller
@RequestMapping(value="/problemadetectado")
public class ProblemaDetectadoController {

	@Autowired
	private IProblemaDetectadoService service;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		ProblemaDetectado problemadetectado = new ProblemaDetectado();
		model.addAttribute("title", "Registro de un problema detectado");
		model.addAttribute("problemadetectado", problemadetectado);
		return "problemadetectado/form";		
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		ProblemaDetectado problemadetectado = service.findById(id);
		model.addAttribute("problemadetectado", problemadetectado);
		return "problemadetectado/card";		
	} 
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		ProblemaDetectado problemadetectado = service.findById(id);
		model.addAttribute("title", "Actualizando un problema detectado de paciente");
		model.addAttribute("problemadetectado", problemadetectado);
		return "problemadetectado/form";		
	} 
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, RedirectAttributes flash) {
		try {
			service.delete(id);
			flash.addFlashAttribute("success", "El registro fue eliminado con éxito.");
		}	
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser eliminado.");
		}
		return "redirect:/problemadetectado/list";		
	} 
	
	@PostMapping(value="/save")
	public String save(ProblemaDetectado problemadetectado, Model model, RedirectAttributes flash) {
		try {
			service.save(problemadetectado);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/problemadetectado/list";
	} 
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<ProblemaDetectado> lista = service.findAll();
		model.addAttribute("title", "Listado de problemas detectados");
		model.addAttribute("lista", lista);
		return "problemadetectado/list";
	} 
}
