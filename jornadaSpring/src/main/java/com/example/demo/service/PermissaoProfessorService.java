package com.example.demo.service;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Permissao;
import com.example.demo.entity.PermissaoProfessor;
import com.example.demo.entity.Professor;
import com.example.demo.repository.PermissaoProfessorRepository;
import com.example.demo.repository.PermissaoRepository;

@Service
public class PermissaoProfessorService {
	
	@Autowired
	private PermissaoProfessorRepository permissaoProfessorRepository;
	
	@Autowired
	private PermissaoRepository permissaoRepository;
	
	public void vincularProfessorPermissaoCliente(Professor professor) {
		
		List<Permissao> listarPermissao = permissaoRepository.findByNome("permissao professor");
		
		if(listarPermissao.size() > 0){
			
			PermissaoProfessor permissaoProfessor = new PermissaoProfessor();
			permissaoProfessor.setProfessor(professor);
			permissaoProfessor.setPermissao(listarPermissao.get(0));
			permissaoProfessor.setDataCriacao(new Date());
			permissaoProfessorRepository.saveAndFlush(permissaoProfessor);
		}
	}
}
