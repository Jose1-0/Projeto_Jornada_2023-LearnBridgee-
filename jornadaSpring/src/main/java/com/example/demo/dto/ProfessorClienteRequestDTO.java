package com.example.demo.dto;

import org.springframework.beans.BeanUtils;

import com.example.demo.entity.Professor;

import lombok.Data;

@Data
public class ProfessorClienteRequestDTO {
	
	private String nome;
	private String cpf;
	private String email;
	
	public Professor converter(ProfessorClienteRequestDTO ProfessorClienteRequestDTO) {
			Professor professor = new Professor();
			BeanUtils.copyProperties(ProfessorClienteRequestDTO, professor);
			return professor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
