package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Professor;
import java.util.List;


public interface ProfessorRepository extends JpaRepository<Professor, Long>{
    
	Professor findByEmail(String email);
	
	Professor findByEmailAndCodigoRecuperacaoSenha(String email, String codigoRecuperacaoSenha);
	
}
