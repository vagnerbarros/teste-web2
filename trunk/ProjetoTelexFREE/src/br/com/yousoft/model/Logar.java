package br.com.yousoft.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.yousoft.entidades.Usuario;
import br.com.yousoft.fachada.Fachada;
import br.com.yousoft.util.Pagina;
import br.com.yousoft.util.Parametros;

public class Logar implements Acao{

	public String executar(HttpServletRequest request, HttpServletResponse response) {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		Fachada fachada = Fachada.getInstance();
		Usuario usuario = fachada.cadastroUsuario().logar(login, senha);
		if(usuario != null){
			request.getSession().setAttribute(Parametros.USUARIO_LOGADO, usuario);
			return Pagina.HOME;
		}
		else{
			return Pagina.INDEX;
		}
	}

}
