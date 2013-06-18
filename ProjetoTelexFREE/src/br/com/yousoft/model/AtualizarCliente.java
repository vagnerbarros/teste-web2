package br.com.yousoft.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.yousoft.entidades.Usuario;
import br.com.yousoft.exceptions.AtualizacaoException;
import br.com.yousoft.fachada.Fachada;
import br.com.yousoft.util.Pagina;
import br.com.yousoft.util.Parametros;

public class AtualizarCliente implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) {
		
		String paginaRetorno = Pagina.LISTAR_CLIENTES;
		
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Usuario usuario = new Usuario();
		usuario.setId(Long.parseLong(id));
		usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		Fachada fachada = Fachada.getInstance();
		try {
			fachada.cadastroUsuario().atualizar(usuario);
		} catch (AtualizacaoException e) {
			paginaRetorno += "?" + Parametros.ERRO + "=" + e.getMessage();
		}
		return paginaRetorno;
	}

}
