package com.example.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProfessorClienteRequestDTO;
import com.example.demo.entity.Professor;
import com.example.demo.repository.ProfessorClienteRepository;


@Service
public class ProfessorClienteService {
	
	@Autowired 
	private ProfessorClienteRepository professorRepository;
	
	
	public Professor registrar(ProfessorClienteRequestDTO professorClienteRequestDTO){
		
		Professor professor = new ProfessorClienteRequestDTO().converter(professorClienteRequestDTO);
		
        professor.setDataCriacao(new Date());
        Professor professorNovo = professorRepository.saveAndFlush(professor);
        return professorNovo;
    }
}
