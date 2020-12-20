package com.joelhenrique.prova.store;

import java.util.ArrayList;
import java.util.Scanner;

import com.joelhenrique.prova.exception.SaqueNegativoException;
import com.joelhenrique.prova.model.Conta;
import com.joelhenrique.prova.model.Poupanca;

// Esta classe quebra com o principio de responsabilidade unica do SOLID,
// porém desconsiderei isso visto que não é o escopo da prova.
public class StoreSingleton {
	
	private static StoreSingleton instance = null;
	private static ArrayList<Conta> contas = new ArrayList<Conta>();
	private static Boolean menuIniciado = false;
	private static Scanner in = new Scanner(System.in);
	
	public Boolean getMenuIniciado() {
		return StoreSingleton.menuIniciado;
	}
	
	private StoreSingleton() {
		
	}
	
	public static StoreSingleton getInstance() {
		if (StoreSingleton.instance == null) {
			StoreSingleton.instance = new StoreSingleton();
		}
		
		return StoreSingleton.instance;
	}
	
	public static int getSize() {
		return contas.size();
	}
	
	public static void fecharMenu() {
		StoreSingleton.menuIniciado = false;
	}

	public void iniciarMenu() {
		StoreSingleton.menuIniciado = true;
	}
	 

	public void cadastrarConta() {
		Conta conta = new Conta.Builder()
			.cpf()
			.nome()
			.nomeAgencia()
			.numeroAgencia()
			.numeroConta()
			.construir();
			
		contas.add(conta);
	}
	
	public void cadastrarPoupanca() {
		Poupanca conta = new Poupanca.Builder()
			.cpf()
			.nome()
			.nomeAgencia()
			.numeroAgencia()
			.numeroConta()
			.construir();
			
		contas.add(conta);
	}

	
	public boolean realizarDeposito() throws SaqueNegativoException {
		System.out.println("Digite o seu cpf: ");
		String cpf = in.next();
		System.out.println("Digite o  valor: ");
		double valor = in.nextDouble();
		in.nextLine();
		
		if (valor < 0) { 
			throw new SaqueNegativoException("Você não pode depositar um valor negativo");
		}
		
		contas.forEach(conta -> {
			if (conta.getCliente().getCPF().equalsIgnoreCase(cpf)) {
				conta.setSaldo(conta.getSaldo() + valor);
				System.out.println("Seu saldo é: " + conta.getSaldo());
				
			}
		});
		
		return true;
	}
	


	public void renderJuros() {
		System.out.println("Digite o seu cpf: ");
		String cpf = in.next();

		contas.forEach(conta -> {
			if (conta.getCliente().getCPF().equalsIgnoreCase(cpf)) {
				
				if (conta instanceof Poupanca) {
					System.out.println("Seu saldo com juros é de: " + ( (Poupanca) conta).renderJuros());
				} else {
					System.out.println("Sua conta não é poupança");  
				}
				
			}
		});
	}

	
	public void consultarAgenda() {
		System.out.println("Digite o numero da agência: ");
		String numeroAgencia = in.next();

		System.out.println("Digite o nome da agência: ");
		String nomeAgencia = in.next();
		
		contas.forEach(conta -> {
			
			if (conta.getBanco().getNomeAgencia().equalsIgnoreCase(nomeAgencia) 
					&& conta.getBanco().getNumeroAgencia().equalsIgnoreCase(numeroAgencia)) {

				System.out.println("\n\n=> CONSULTA REALIZADA\n");
				
				System.out.println("CPF: " + conta.getCliente().getNome());
				System.out.println("Nome: " + conta.getCliente().getCPF());
				
				
			}
		});
	}
	
	
	public void alterarAgencia() {
		System.out.println("Digite o seu nome: ");
		String nome = in.nextLine();
		
		contas.forEach(conta -> {
			
			if (conta.getCliente().getNome().equalsIgnoreCase(nome)) {
				
				System.out.println("Digite o numero da agencia: ");
				String numeroAgencia = in.nextLine();
				
				System.out.println("Digite o nome da agencia: ");
				String nomeAgencia = in.nextLine();
				
				conta.getBanco().setNomeAgencia(nomeAgencia);
				conta.getBanco().setNumeroAgencia(numeroAgencia);
				
				System.out.println("\n\n=> DADOS ALTERADOS\n");

				System.out.println("Novo nome da agencia: " + conta.getBanco().getNomeAgencia());
				System.out.println("Novo numero da agencia: " + conta.getBanco().getNumeroAgencia());
				
			}
		});
	}

}
