package com.joelhenrique.prova.enums;

public enum Opcoes {
	SAIR(0),
	CADASTRAR_CONTA(1),
	DEPOSITAR(2),
	RENDER_JUROS(3),
	CONSULTAR_AGENCIA(4),
	ALTERAR_AGENCIA(5),
	CADASTRAR_TIPO_CONTA(6),
	CADASTRAR_TIPO_POUPANCA(7);

	private final int valor;
	
	Opcoes(int valorOpcao){
	valor = valorOpcao;
	}
	
	public int getValor(){
	return valor;
	}
}
