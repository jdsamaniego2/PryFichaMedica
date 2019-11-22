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

import com.ficha.medica.app.web.models.entities.Departamento;
import com.ficha.medica.app.web.models.service.IDepartamentoService;

@Controller
@RequestMapping(value="/departamento")
public class DepartamentoController {
	@Autowired
	private IDepartamentoService service;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		Departamento departamento = new Departamento();
		model.addAttribute("title", "Registro de un Departamento");
		model.addAttribute("departamento", departamento);
		return "departamento/form";		
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Departamento departamento = service.findById(id);
		model.addAttribute("departamento", departamento);
		return "departamento/card";		
	} 
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Departamento departamento = service.findById(id);
		model.addAttribute("title", "Actualizando el registro de " 
		+ departamento.getNombre());
		model.addAttribute("departamento", departamento);
		return "departamento/form";		
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
		return "redirect:/departamento/list";		
	} 
	
	@PostMapping(value="/save")
	public String save(Departamento departamento, Model model,
			RedirectAttributes flash) {
		try {
			service.save(departamento);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/departamento/list";		
	} 
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Departamento> lista = service.findAll();
		model.addAttribute("title", "Listado de Departamentos");
		model.addAttribute("lista", lista);
		return "departamento/list";		
	} 
}
