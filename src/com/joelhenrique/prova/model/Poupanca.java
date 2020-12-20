package com.joelhenrique.prova.model;

import java.util.Scanner;

import com.joelhenrique.prova.model.interfaces.IPoupanca;

public class Poupanca extends Conta implements IPoupanca {
	private double juros;
	
	public static class Builder {

		private Scanner input = new Scanner(System.in);
		
		private String numeroConta = "";
		private String numeroAgencia = "";
		private String nomeAgencia = "";
		private String nome = "";
		private String cpf = "";
		private double saldo = 0;
		private double juros = 0;
		
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

		public Poupanca construir() {
			return new Poupanca(this.numeroConta, new Banco(this.numeroAgencia, this.nomeAgencia), new Cliente(this.nome, this.cpf), this.saldo, 3.5);
		}
	}
	
	public Poupanca(String numero, Banco banco, Cliente cliente, double saldo, double juros) {
		super(numero, banco, cliente, saldo);
		this.juros = juros;
	}

	@Override
	public double renderJuros() {
		return ((this.juros * this.getSaldo()) / 100) + this.getSaldo();
	}
	
}
