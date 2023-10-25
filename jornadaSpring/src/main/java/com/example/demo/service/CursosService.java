package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cursos;
import com.example.demo.repository.CursosRepository;

@Service
public class CursosService {
	
	@Autowired
	private CursosRepository cursosRepository;
	
	public List<Cursos> buscarTodos(){
		return cursosRepository.findAll();
	}
	
	public Cursos inserir(Cursos cursos) {
		cursos.setDataCriacao(new Date());
		Cursos cursosNovo = cursosRepository.saveAndFlush(cursos);
		return cursosNovo;
	}
	
	public Cursos alterar(Cursos cursos) {
		cursos.setDataAtualizacao(new Date());
		return cursosRepository.saveAndFlush(cursos);
	}
	
	public void excluir(Long id) {
		Cursos cursos = cursosRepository.findById(id).get();
		cursosRepository.delete(cursos);
	}
}
