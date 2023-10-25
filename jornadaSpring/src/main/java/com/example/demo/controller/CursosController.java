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

import com.example.demo.entity.Cursos;
import com.example.demo.service.CursosService;

@RestController
@RequestMapping("api/cursos")
public class CursosController {
	
	@Autowired
	private CursosService cursosService;
	
	@GetMapping("/")
	public List<Cursos> buscarTodos(){
		return cursosService.buscarTodos();
	}
	
	@PostMapping("/inserir")
	public Cursos inserir(@RequestBody Cursos cursos) {
		return cursosService.inserir(cursos);
	}
	
	@PutMapping("/alterar")
	public Cursos alterar(@RequestBody Cursos cursos) {
		return cursosService.alterar(cursos);
	}
	
	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
		cursosService.excluir(id);
		return ResponseEntity.ok().build();
	}
	
}
