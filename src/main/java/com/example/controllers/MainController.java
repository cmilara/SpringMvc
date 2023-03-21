package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.entities.Estudiante;
import com.example.services.EstudianteService;


@Controller
@RequestMapping("/")
public class MainController {
    
    @Autowired
    private EstudianteService estudianteService;




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
        
        model.addAttribute("estudiante", new Estudiante());
        
        return "views/formularioAltaEstudiante";

    }

    

}
