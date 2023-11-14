package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Permissao;
import java.util.List;


public interface PermissaoRepository extends JpaRepository<Permissao, Long>{
    
	@Query("SELECT p FROM Permissao p WHERE p.nome = :nome")
	List<Permissao> findByNome(@Param("nome") String nome);
}
