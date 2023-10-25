package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Permissao;
import java.util.List;


public interface PermissaoRepository extends JpaRepository<Permissao, Long>{
    
	@Query
	List<Permissao> findByNome(String nome);
}
