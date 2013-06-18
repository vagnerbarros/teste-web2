package br.com.yousoft.exceptions;

public class CadastroException extends Exception{

	private static final long serialVersionUID = 1L;
	private String mensagem;
	
	public CadastroException(String mens){
		this.mensagem = mens;
	}
	
	public String getMessage(){
		return this.mensagem;
	}
}
