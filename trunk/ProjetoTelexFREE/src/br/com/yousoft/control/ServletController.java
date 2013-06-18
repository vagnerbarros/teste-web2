package br.com.yousoft.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.yousoft.model.Acao;
import br.com.yousoft.model.Logar;
import br.com.yousoft.util.Acoes;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/controlador")
public class ServletController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Map<String, Acao> mapa;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletController() {
		super();
		mapa = new HashMap<String, Acao>();
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		mapa.put(Acoes.LOGAR, new Logar());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		Acao classeAcao = buscarAcao(acao);
		String proximaPagina = classeAcao.executar(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher(proximaPagina);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private Acao buscarAcao(String acao) {
		Acao resultado = mapa.get(acao);
		if (resultado == null) {
			resultado = mapa.get(Acoes.ERRO);
		}
		return resultado;
	}
}
