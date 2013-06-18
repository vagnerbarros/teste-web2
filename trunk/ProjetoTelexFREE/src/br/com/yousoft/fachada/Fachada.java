package br.com.yousoft.fachada;

import br.com.yousoft.cadastro.CadastroUsuario;
import br.com.yousoft.dao.UsuarioDAO;

public class Fachada {

	private static Fachada fachada;
	private CadastroUsuario cadUsuario;
	
	private Fachada(){
		inicializar();
	}
	
	private void inicializar(){
		
		UsuarioDAO usuario = new UsuarioDAO();
		cadUsuario = new CadastroUsuario(usuario);
	}
	
	public static Fachada getInstance(){
		if(fachada == null){
			fachada = new Fachada();
		}
		return fachada;
	}
	
	public CadastroUsuario cadastroUsuario(){
		return cadUsuario;
	}
}
