package com.joelhenrique.prova.exception;

public class SaqueNegativoException extends Exception {
    
	private static final long serialVersionUID = 1L;

	public SaqueNegativoException(String msg){
        super(msg);
    }

    public SaqueNegativoException(String msg, Throwable cause){
        super(msg, cause);
    }
}
