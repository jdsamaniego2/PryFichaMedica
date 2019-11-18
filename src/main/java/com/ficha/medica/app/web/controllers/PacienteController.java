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

import com.ficha.medica.app.web.models.entities.Paciente;
import com.ficha.medica.app.web.models.service.IPacienteService;

@Controller
@RequestMapping(value="/paciente")
public class PacienteController {

	@Autowired
	private IPacienteService service;
	
	
	@GetMapping(value="/create")
	public String create(Model model) {
		Paciente paciente = new Paciente();
		model.addAttribute("title", "Registro de un nuevo paciente");
		model.addAttribute("paciente", paciente);
		return "paciente/form";		
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Paciente paciente = service.findById(id);
		model.addAttribute("paciente", paciente);
		return "paciente/card";		
	} 
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Paciente paciente = service.findById(id);
		model.addAttribute("title", "Actualizando el registro de " 
		+ paciente.getNombres()+" "+paciente.getApellidos());
		model.addAttribute("paciente", paciente);
		return "paciente/form";		
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
		return "redirect:/paciente/list";		
	} 
	
	@PostMapping(value="/save")
	public String save(Paciente paciente, Model model,
			RedirectAttributes flash) {
		try {
			service.save(paciente);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/paciente/list";		
	} 
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Paciente> lista = service.findAll();
		model.addAttribute("title", "Listado de pacientes");
		model.addAttribute("lista", lista);
		return "pacientes/list";		
	} 
}
