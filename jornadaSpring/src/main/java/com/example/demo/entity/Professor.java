package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;


@Entity
@Table(name = "professor")
@Data
@JsonSerialize

@JsonInclude
public class Professor {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String email;
    
    @Column(name = "codigo_recuperacao_senha")
    private String codigoRecuperacaoSenha;
    
    @OneToMany(mappedBy = "professor", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @Setter(value = AccessLevel.NONE)
    @JsonIgnore
    private List<PermissaoProfessor> permissaoProfessores;
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_envio_codigo;
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_criacao;
    @Column(name = "data_atualizacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_atualizacao;
    private String senha;
    
    
    public void setPermissaoProfessores(List<PermissaoProfessor> pp) {
    	
    	for(PermissaoProfessor p: pp) {
    		p.setProfessor(this);
    	}
    	this.permissaoProfessores = pp;
    }

	public Professor() {

	}
	
	public Professor(Long id, String nome, String cpf, String email, String codigoRecuperacaoSenha,
			List<PermissaoProfessor> permissaoProfessores, Date data_envio_codigo, Date data_criacao,
			Date data_atualizacao, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.codigoRecuperacaoSenha = codigoRecuperacaoSenha;
		this.permissaoProfessores = permissaoProfessores;
		this.data_envio_codigo = data_envio_codigo;
		this.data_criacao = data_criacao;
		this.data_atualizacao = data_atualizacao;
		this.senha = senha;
	}
	

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
	public String getCodigoRecuperacaoSenha() {
		return codigoRecuperacaoSenha;
	}
	public void setCodigoRecuperacaoSenha(String codigoRecuperacaoSenha) {
		this.codigoRecuperacaoSenha = codigoRecuperacaoSenha;
	}
	public List<PermissaoProfessor> getPermissaoProfessores() {
		return permissaoProfessores;
	}

	public Date getDataEnvioCodigo() {
		return data_envio_codigo;
	}
	public void setDataEnvioCodigo(Date dataEnvioCodigo) {
		this.data_envio_codigo = dataEnvioCodigo;
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
    

}