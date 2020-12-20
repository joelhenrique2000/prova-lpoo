package com.joelhenrique.prova.model;

import java.math.BigInteger;
import java.util.Scanner;

public class Conta {

	private String numero;
	private Banco banco;
	private Cliente cliente;
	private double saldo;
	
	public static class Builder {

		private Scanner input = new Scanner(System.in);
		
		private String numeroConta = "";
		private String numeroAgencia = "";
		private String nomeAgencia = "";
		private String nome = "";
		private String cpf = "";
		private double saldo = 0;
		
		public Builder numeroConta() {
			System.out.print("Digite o numero da conta: ");
			this.numeroConta = input.nextLine();
			return this;
		}
		
		public Builder numeroAgencia() {
			System.out.print("Digite o numero da agência: ");
			this.numeroAgencia = input.nextLine();
			return this;
		}
		
		public Builder nomeAgencia() {
			System.out.print("Digite o nome da agência: ");
			this.nomeAgencia = input.nextLine();
			return this;
		}
		
		public Builder nome() {
			System.out.print("Digite o seu nome: ");
			this.nome = input.nextLine();
			return this;
		}
	
		public Builder cpf() {
			System.out.print("Digite o seu CPF: ");
			this.cpf = input.nextLine();
			return this;
		}

		public Conta construir() {
			return new Conta(this.numeroConta, new Banco(this.numeroAgencia, this.nomeAgencia), new Cliente(this.nome, this.cpf), this.saldo);
		}
	}
	
	public Conta() {
		
	}
	
	public Conta(String numero, Banco banco, Cliente cliente, double saldo) {
		super();
		this.numero = numero;
		this.banco = banco;
		this.cliente = cliente;
		this.saldo = saldo;
	}
	

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	} 
	
}
