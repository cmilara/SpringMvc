package com.example.controllers;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.entities.Estudiante;
import com.example.entities.Facultad;
import com.example.services.EstudianteService;
import com.example.services.FacultadService;


@Controller
@RequestMapping("/")
public class MainController {
    
    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private FacultadService facultadService;




/*Un controlador responde a una peticion concreta y la delega en un método
 * que tiene en cuenta el verbo utilizado del protocolo HTTP para realizar la peticion
 * get, put, delete, option, post...
 */
    
 /*El metodo siguiente devuelve un  listado de estudiantes */
 @GetMapping("/listar")
 public ModelAndView listar(){
    List <Estudiante> estudiantes = estudianteService.findAll();

        ModelAndView mav = new ModelAndView("views/listarEstudiantes");
        mav.addObject("estudiantes", estudiantes);    

        return mav;
    }
    /**
     * Muestra el formulario de alta de estudiantes
     */ 
    @GetMapping("/frmAltaEstudiante")
    public String formularioAltaEstudiante(Model model){
        
        List<Facultad> facultades= facultadService.findAll();
        
        model.addAttribute("estudiante", new Estudiante());
        model.addAttribute("facultades", facultades);
        
        return "views/formularioAltaEstudiante";

    }
/**
 * Metodo que recibe los datos procedentes de los controles del formulario-ESTOY EN HOME-
 */
@PostMapping("/altaEstudiante")
public String altaEstudiante(@ModelAttribute Estudiante estudiante){
    
    estudianteService.save(estudiante);
    return "redirect:/listar";

    }

}














