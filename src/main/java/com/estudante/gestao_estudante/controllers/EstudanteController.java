package com.estudante.gestao_estudante.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.estudante.gestao_estudante.entities.Estudantes;
import com.estudante.gestao_estudante.repositories.EstudanteRepositories;

@Controller
@RequestMapping("/estudantes")
public class EstudanteController {

    @Autowired
    private EstudanteRepositories estudanteRepositories;
    
    @GetMapping("/estudantes")
    public ModelAndView buscarTodos(){

        var modelAndView= new ModelAndView("mostrar_estudante");
        modelAndView.addObject("estudantes", estudanteRepositories.findAll());
        return modelAndView;
    }
    @GetMapping("/estudantes/novo")
    public String createStudent(Model model){
        Estudantes estudante = new Estudantes();
        model.addAttribute("estudante", estudante);
        return "cadastrar_estudante";
    }
    
    @GetMapping("/{id}")
    public ModelAndView buscarPorId(@PathVariable Long id){
        var modelAndView = new ModelAndView("detalhes");
        modelAndView.addObject("estudantes", estudanteRepositories.getReferenceById(id));
        return modelAndView;
    }
    
}
