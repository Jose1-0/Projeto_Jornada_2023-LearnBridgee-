package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Professor;
import com.example.demo.service.ProfessorService;

import jakarta.websocket.server.PathParam;



@RestController
@RequestMapping("/api/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping("/")
    public List<Professor> buscarTodos(){
        /* o retorno vem direto pois os dois retornar um estado lista */
        return professorService.buscarTodos();
    }
    
   @PostMapping("/inserir")
    public Professor inserir(@RequestBody Professor professor){
        return professorService.inserir(professor);
    }
 
    @PutMapping("/alterar")
    public Professor alterar(@RequestBody Professor professor){
         return professorService.alterar(professor);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        professorService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
