package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "permissao_professor")
@Data
public class PermissaoProfessor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_professor")
	private Professor professor;
	
	@ManyToOne
	@JoinColumn(name = "id_permissao")
	private Permissao permissao;
	
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_criacao;
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_atualizacao;
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Permissao getPermissao() {
		return permissao;
	}



	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}



	public Date getDataCriacao() {
		return data_criacao;
	}



	public void setDataCriacao(Date dataCriacao) {
		this.data_criacao = dataCriacao;
	}



	public Date getDataAtualizacao() {
		return data_atualizacao;
	}



	public void setDataAtualizacao(Date dataAtualizacao) {
		this.data_atualizacao = dataAtualizacao;
	}



	public Professor getProfessor() {
		return professor;
	}



	public void setProfessor(Professor professor2) {
		// TODO Auto-generated method stub
		
	}
	
	
}
