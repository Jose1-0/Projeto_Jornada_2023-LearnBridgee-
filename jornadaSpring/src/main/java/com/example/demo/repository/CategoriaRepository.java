package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
}
