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
import com.ficha.medica.app.web.models.entities.AsociacionEmpleado;
import com.ficha.medica.app.web.models.service.IAsociacionEmpleadoService;


@Controller
@RequestMapping(value="/asociacionempleado")
public class AsociacionEmpleadoController {

	@Autowired
	private IAsociacionEmpleadoService service;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		AsociacionEmpleado asociacionEmpleado = new AsociacionEmpleado();
		model.addAttribute("title", "Registro de una nueva Asociación de Empleado");
		model.addAttribute("asociacionEmpleado", asociacionEmpleado);
		return "asociacionempleado/form";		
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		AsociacionEmpleado asociacionEmpleado = service.findById(id);
		model.addAttribute("asociacionEmpleado", asociacionEmpleado);
		return "asociacionempleado/card";		
	} 
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		AsociacionEmpleado asociacionEmpleado = service.findById(id);
		model.addAttribute("title", "Actualizando el registro de " 
		+ asociacionEmpleado.getNombre());
		model.addAttribute("asociacionEmpleado", asociacionEmpleado);
		return "asociacionempleado/form";		
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
	public String save(AsociacionEmpleado asociacionEmpleado, Model model,
			RedirectAttributes flash) {
		try {
			service.save(asociacionEmpleado);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/asociacionempleado/list";		
	} 
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<AsociacionEmpleado> lista = service.findAll();
		model.addAttribute("title", "Listado de Asociaciones de Empleados");
		model.addAttribute("lista", lista);
		return "asociacionempleado/list";		
	} 

}
