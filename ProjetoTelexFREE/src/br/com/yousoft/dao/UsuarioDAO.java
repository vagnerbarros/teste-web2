package br.com.yousoft.dao;

import java.util.List;

import br.com.yousoft.dominio.Perfil;
import br.com.yousoft.entidades.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario>{

	public UsuarioDAO() {
		super(Usuario.class);
	}

	public Usuario logar(String login, String senha) {
		Usuario retorno = null;
		List<Usuario> lista = buscarPorLikeIlimitado(new String [] {"login", "senha"},  new String [] {login, senha});
		if(lista != null){
			retorno = lista.get(0);
		}
		return retorno;
	}
	
	public List<Usuario> listarClientes(){
		return buscarPorLike("perfil", Perfil.CLIENTE);
	}
}
