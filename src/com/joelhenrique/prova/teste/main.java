package com.joelhenrique.prova.teste;

import java.util.Scanner;

import com.joelhenrique.prova.enums.Opcoes;
import com.joelhenrique.prova.exception.SaqueNegativoException;
import com.joelhenrique.prova.store.StoreSingleton;

public class main {
	public static void main(String args[]) {
		StoreSingleton storeContas = StoreSingleton.getInstance();
		storeContas.iniciarMenu();
		try (Scanner input = new Scanner(System.in)) {
			while(storeContas.getMenuIniciado()) {
				
				System.out.println("\n\n+-------------------------------------------+");
				System.out.println("| 1. Cadastrar Conta ou Poupança            |");
				System.out.println("| 2. Realizar depósito                      |");
				System.out.println("| 3. Render Juros                           |");
				System.out.println("| 4. Consultar número e nome da agência     |");
				System.out.println("| 5. Alterar o número e nome da agência     |");
				System.out.println("| 0. Sair                                   |");
				System.out.println("+-------------------------------------------|\n\n");
				
				System.out.print("Opção escolhida: ");
				
				int opcao = input.nextInt();
				input.nextLine();
				
				if (Opcoes.SAIR.getValor() == opcao) {
					StoreSingleton.fecharMenu();
					
				} else if (Opcoes.CADASTRAR_CONTA.getValor() == opcao) {
					if (StoreSingleton.getSize() >= 10) {
						System.out.println("Você não pode cadastrar mais contas");
						
					} else {
						System.out.println("\n\n+--------------------------+");
						System.out.println("| 6. Cadastrar Conta       |");
						System.out.println("| 7. Cadastrar Poupança    |");
						System.out.println("+--------------------------|\n\n");
						
						System.out.print("Opção escolhida: ");
						
						int opcaoCadastro = input.nextInt();
						input.nextLine();
						
						if (Opcoes.CADASTRAR_TIPO_CONTA.getValor() == opcaoCadastro) {
							storeContas.cadastrarConta();
							
						} else if (Opcoes.CADASTRAR_TIPO_POUPANCA.getValor() == opcaoCadastro) {
							storeContas.cadastrarPoupanca();
						}
						
					}
					
				} else if (Opcoes.DEPOSITAR.getValor() == opcao) {
					try {
						storeContas.realizarDeposito();
					} catch (SaqueNegativoException e) {
						System.out.println(e.getMessage());
					}
					
				} else if (Opcoes.RENDER_JUROS.getValor() == opcao) {
					storeContas.renderJuros();
					
				} else if (Opcoes.CONSULTAR_AGENCIA.getValor() == opcao) {
					storeContas.consultarAgenda();
					
				} else if (Opcoes.ALTERAR_AGENCIA.getValor() == opcao) {
					storeContas.alterarAgencia();
					
				}
				
			}
		}
		
	}
}