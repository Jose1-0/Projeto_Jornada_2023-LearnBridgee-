package com.example.demo.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Professor;
import com.example.demo.repository.ProfessorRepository;

@Service
public class ProfessorGerenciamentoService {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private EmailService emailService;
	
	public String solicitarCodigo(String email) {
		Professor professor = professorRepository.findByEmail(email);
		professor.setCodigoRecuperacaoSenha(getCodigoRecuperacaoSenha(professor.getId()));
		professor.setDataEnvioCodigo(new Date());
		professorRepository.saveAndFlush(professor);
		emailService.enviarEmailTexto(professor.getEmail(), "Codigo de Recuperação de senha", "Seu docigo para recuperação de senha é: " + professor.getCodigoRecuperacaoSenha());
		return "Codigo Enviado";
	}
	
	public String alterarSenha(Professor professor){
		Professor professorBanco = professorRepository.findByEmailAndCodigoRecuperacaoSenha(professor.getEmail(), professor.getCodigoRecuperacaoSenha());
		
		if(professorBanco != null) {
			Date diferenca = new Date(new Date().getTime() - professor.getDataEnvioCodigo().getTime());
			
			if(diferenca.getTime() / 1000 < 900) {
				professorBanco.setSenha(professor.getSenha());
				professorBanco.setCodigoRecuperacaoSenha(null);
				professorRepository.saveAndFlush(professorBanco);
				return "Senha alterada com sucesso!";
			}else {
				return "Tempo expirado, solicite um novo codigo";
			}
		}else {
			return "Email ou codigo não encontrado";
		}
	}
	
	private String getCodigoRecuperacaoSenha(Long id) {
		DateFormat format = new SimpleDateFormat("ddMMyyyyHHmmssmm");
		return format.format(new Date()) + id;
	}

}
