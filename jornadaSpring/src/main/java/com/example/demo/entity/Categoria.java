package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "categoria")
@Data
public class Categoria {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_criacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_atualizacao ;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataCriacao() {
		return data_criacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.data_criacao = dataCriacao;
	}
	public Date getDataAtualizacao() {
		return data_atualizacao ;
	}
	public void setDataAtualizacao(Date dataAtualizacao) {
		this.data_atualizacao  = dataAtualizacao;
	}
	
    
}
