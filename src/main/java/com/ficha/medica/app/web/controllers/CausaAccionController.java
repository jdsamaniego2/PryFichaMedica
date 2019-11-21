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

import com.ficha.medica.app.web.models.entities.CausaAccion;
import com.ficha.medica.app.web.models.service.ICausaAccionService;

@Controller
@RequestMapping(value="/causaaccion")
public class CausaAccionController {

	@Autowired
	private ICausaAccionService service;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		CausaAccion causaaccion = new CausaAccion();
		model.addAttribute("title", "Registro de una Causa del Empleado");
		model.addAttribute("causaAccion", causaaccion);
		return "causaaccion/form";		
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		CausaAccion causaAccion = service.findById(id);
		model.addAttribute("causaAccion", causaAccion);
		return "causaaccion/card";		
	} 
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		CausaAccion causaaccion = service.findById(id);
		model.addAttribute("title", "Actualizando el registro de " 
		+ causaaccion.getNombre());
		model.addAttribute("causaAccion", causaaccion);
		return "causaaccion/form";		
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
		return "redirect:/asociacionempleado/list";		
	} 
	
	@PostMapping(value="/save")
	public String save(CausaAccion causaAccion, Model model,
			RedirectAttributes flash) {
		try {
			service.save(causaAccion);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/causaaccion/list";		
	} 
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<CausaAccion> lista = service.findAll();
		model.addAttribute("title", "Listado de Causas");
		model.addAttribute("lista", lista);
		return "causaaccion/list";		
	} 
	
}
