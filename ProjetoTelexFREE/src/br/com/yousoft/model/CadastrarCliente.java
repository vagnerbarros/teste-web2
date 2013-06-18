package br.com.yousoft.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.yousoft.entidades.Usuario;
import br.com.yousoft.exceptions.CadastroException;
import br.com.yousoft.fachada.Fachada;
import br.com.yousoft.util.Pagina;
import br.com.yousoft.util.Parametros;

public class CadastrarCliente implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		
		String paginaRetorno = Pagina.CADASTRAR_CLIENTE;
		
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Usuario novo = new Usuario();
		novo.setNome(nome);
		novo.setLogin(login);
		novo.setSenha(senha);
		
		Fachada fachada = Fachada.getInstance();
		try {
			fachada.cadastroUsuario().cadastrarCliente(novo);
		} catch (CadastroException e) {
			paginaRetorno += "?" + Parametros.ERRO + "=" + e.getMessage();
		}
		return paginaRetorno;
	}

}
