package com.joelhenrique.prova.model;

public class Cliente {
	private String nome;
	private String CPF;
	
	public Cliente() {
		
	}
	
	public Cliente(String nome, String cPF) {
		super();
		this.nome = nome;
		CPF = cPF;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}
	
}
