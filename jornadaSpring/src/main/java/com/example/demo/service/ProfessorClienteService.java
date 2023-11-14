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
	
	@Autowired
	private PermissaoProfessorService PermissaoProfessorService;
	
	@Autowired
	private EmailService emailService; 
	
	public Professor registrar(ProfessorClienteRequestDTO professorClienteRequestDTO){
		
		Professor professor = new ProfessorClienteRequestDTO().converter(professorClienteRequestDTO);
        professor.setDataCriacao(new Date());
        Professor professorNovo = professorRepository.saveAndFlush(professor);
        PermissaoProfessorService.vincularProfessorPermissaoCliente(professorNovo);
        emailService.enviarEmailTexto(professorNovo.getEmail(), "Cadastro Learn Bridge", "Cadastro realizado com sucesso. Em breve você recebera sua senha de acesso no e-mail");
        return professorNovo;
    }
}
