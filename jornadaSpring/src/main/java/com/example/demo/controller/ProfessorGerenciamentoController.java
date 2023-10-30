package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Professor;
import com.example.demo.service.ProfessorGerenciamentoService;

@RestController
@RequestMapping("/api/professor-gerenciamento")
public class ProfessorGerenciamentoController {
	
	@Autowired
	private ProfessorGerenciamentoService professorGerenciamentoService;
	
	@PostMapping("/codigo-senha")
	public String recuperarCodigo(@RequestBody Professor professor) {	
		return professorGerenciamentoService.solicitarCodigo(professor.getEmail());	
	}
	
	@PostMapping("/alterar-senha")
	public String alterarSenha (@RequestBody Professor professor) {	
		return professorGerenciamentoService.alterarSenha(professor);
	}
	
}
