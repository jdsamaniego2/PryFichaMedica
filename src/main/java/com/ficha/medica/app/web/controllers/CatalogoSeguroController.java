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

import com.ficha.medica.app.web.models.entities.CatalogoSeguro; 
import com.ficha.medica.app.web.models.service.ICatalogoSeguroService;

@Controller
@RequestMapping(value="/catalogoseguro")
public class CatalogoSeguroController {

	@Autowired
	private ICatalogoSeguroService service;
	
	
	@GetMapping(value="/create")
	public String create(Model model) {
		CatalogoSeguro catalogoseguro = new CatalogoSeguro();
		model.addAttribute("title", "Registro de un nuevo seguro");
		model.addAttribute("catalogoseguro", catalogoseguro);
		return "catalogoseguro/form";		
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		CatalogoSeguro catalogoseguro = service.findById(id);
		model.addAttribute("catalogoseguro", catalogoseguro);
		return "catalogoseguro/card";		
	} 
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		CatalogoSeguro catalogoseguro  = service.findById(id);
		model.addAttribute("title", "Actualizando el registro de " 
		+ catalogoseguro.getNombre()+" "+catalogoseguro.getTipoSeguro());
		model.addAttribute("catalogoseguro", catalogoseguro);
		return "catalogoseguro/form";		
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
		return "redirect:/catalogoseguro/list";		
	} 
	
	@PostMapping(value="/save")
	public String save(CatalogoSeguro catalogoseguro, Model model,
			RedirectAttributes flash) {
		try {
			service.save(catalogoseguro);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/catalogoseguro/list";		
	} 
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<CatalogoSeguro> lista = service.findAll();
		model.addAttribute("title", "Listado de seguros");
		model.addAttribute("lista", lista);
		return "catalogoseguro/list";		
	} 
	
}

