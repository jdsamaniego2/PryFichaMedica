package com.ficha.medica.app.web.controllers;

import com.ficha.medica.app.web.models.entities.AsociacionEmpleado;
import com.ficha.medica.app.web.models.entities.CatalogoExamenenComplementario;
import com.ficha.medica.app.web.models.service.ICatalogoExamenComplementarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value="/catalogoExamCompl")
public class CatalogoExamenComplementarioController {

    private ICatalogoExamenComplementarioService service;

    @GetMapping(value="/create")
    public String create(Model model) {
        CatalogoExamenenComplementario catalogoExamenenComplementario = new CatalogoExamenenComplementario();
        model.addAttribute("title", "Registro de una nuevo Examencomplementario");
        model.addAttribute("catalogoExamenenComplementario", catalogoExamenenComplementario);
        return "catalogoExamCompl/form";
    }

    @GetMapping(value="/retrieve/{id}")
    public String retrieve(@PathVariable(value="id") Integer id, Model model) {
        CatalogoExamenenComplementario catalogoExamenenComplementario = service.findById(id);
        model.addAttribute("catalogoExamenenComplementario", catalogoExamenenComplementario);
        return "catalogoExamCompl/card";
    }

    @GetMapping(value="/update/{id}")
    public String update(@PathVariable(value="id") Integer id, Model model) {
        CatalogoExamenenComplementario catalogoExamenenComplementario = service.findById(id);
        model.addAttribute("title", "Actualizando el registro de "
                + catalogoExamenenComplementario.getNombre());
        model.addAttribute("catalogoExamenenComplementario", catalogoExamenenComplementario);
        return "catalogoExamCompl/form";
    }

    @GetMapping(value="/delete/{id}")
    public String delete(@PathVariable(value="id") Integer id, Model model,
                         RedirectAttributes flash) {
        try {
            service.deleteById(id);
            flash.addFlashAttribute("success", "El registro fue eliminado con éxito.");
        }
        catch(Exception ex) {
            flash.addFlashAttribute("error", "El registro no pudo ser eliminado.");
        }
        return "redirect:/catalogoExamCompl/list";
    }

    @PostMapping(value="/save")
    public String save(CatalogoExamenenComplementario catalogoExamenenComplementario, Model model,
                       RedirectAttributes flash) {
        try {
            service.save(catalogoExamenenComplementario);
            flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
        }
        catch(Exception ex) {
            flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
        }
        return "redirect:/catalogoExamCompl/list";
    }

    @GetMapping(value="/list")
    public String list(Model model) {
        List<CatalogoExamenenComplementario> catalogoExamenenComplementarioList = service.findAll();
        model.addAttribute("title", "Listado de Asociaciones de Empleados");
        model.addAttribute("catalogoExamenenComplementarioList", catalogoExamenenComplementarioList);
        return "catalogoExamCompl/list";
    }
}
