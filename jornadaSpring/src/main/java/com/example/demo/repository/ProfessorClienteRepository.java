package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Professor;

public interface ProfessorClienteRepository extends JpaRepository<Professor, Long>{
	
	
}
