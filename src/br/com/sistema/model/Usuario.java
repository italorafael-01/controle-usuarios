package br.com.sistema.model;

import java.math.BigDecimal;

public class Usuario {

	private Long id;
	private String nome;
	private String telefone;
	private BigDecimal saldoNegativo;
	private BigDecimal saldoPositivo;
	private Administrador administrador;
	
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
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public BigDecimal getSaldoNegativo() {
		return saldoNegativo;
	}
	
	public void setSaldoNegativo(BigDecimal saldoNegativo) {
		this.saldoNegativo = saldoNegativo;
	}
	
	public BigDecimal getSaldoPositivo() {
		return saldoPositivo;
	}
	
	public void setSaldoPositivo(BigDecimal saldoPositivo) {
		this.saldoPositivo = saldoPositivo;
	}
	
	public Administrador getAdministrador() {
		return administrador;
	}
	
	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

}
