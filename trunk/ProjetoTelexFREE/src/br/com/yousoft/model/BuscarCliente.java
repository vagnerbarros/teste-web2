package br.com.yousoft.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.yousoft.entidades.Usuario;
import br.com.yousoft.fachada.Fachada;
import br.com.yousoft.util.Pagina;
import br.com.yousoft.util.Parametros;

public class BuscarCliente implements Acao{

	public String executar(HttpServletRequest request, HttpServletResponse response) {
		
		String paginaRetorno = Pagina.ATUALIZAR_CLIENTE;
		String id_cliente = request.getParameter(Parametros.ID_USUARIO);
		Long id = Long.parseLong(id_cliente);
		Fachada fachada = Fachada.getInstance();
		Usuario edicao = fachada.cadastroUsuario().buscarId(id);
		if(edicao != null){
			request.getSession().setAttribute(Parametros.USUARIO_EDICAO, edicao);
		}
		else{
			paginaRetorno = Pagina.LISTAR_CLIENTES;
		}
		return paginaRetorno;
	}

}
