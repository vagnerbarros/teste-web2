package br.com.yousoft.exceptions;

public class RemocaoException extends Exception{

	private static final long serialVersionUID = 1L;
	private String mensagem;
	
	public RemocaoException(String mens){
		this.mensagem = mens;
	}
	
	public String getMessage(){
		return this.mensagem;
	}
}
