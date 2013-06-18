package br.com.yousoft.exceptions;

public class AtualizacaoException extends Exception{

	private static final long serialVersionUID = 1L;
	private String mensagem;
	
	public AtualizacaoException(String mens){
		this.mensagem = mens;
	}
	
	public String getMessage(){
		return this.mensagem;
	}
}
