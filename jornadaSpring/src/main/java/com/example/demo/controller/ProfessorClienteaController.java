package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProfessorClienteRequestDTO;
import com.example.demo.entity.Professor;
import com.example.demo.service.ProfessorClienteService;

@RestController
@RequestMapping("api/clinte")
public class ProfessorClienteaController {
	
	@Autowired
    private ProfessorClienteService professorService;


    
   @PostMapping("/inserir")
    public Professor inserir(@RequestBody ProfessorClienteRequestDTO professorClienteRequestDTO){

        return professorService.registrar(professorClienteRequestDTO);
    }
 
//    @PutMapping("/alterar")
//    public Professor alterar(@RequestBody Professor professor){
//         return professorService.alterar(professor);
//    }
//
//    @DeleteMapping("/excluir/{id}")
//    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
//        professorService.excluir(id);
//        return ResponseEntity.ok().build();
//    }
}
