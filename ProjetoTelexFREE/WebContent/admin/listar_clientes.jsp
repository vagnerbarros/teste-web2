<%@page import="br.com.yousoft.util.Parametros"%>
<%@page import="br.com.yousoft.util.Acoes"%>
<%@page import="br.com.yousoft.util.Pagina"%>
<%@page import="br.com.yousoft.fachada.Fachada"%>
<%@page import="br.com.yousoft.entidades.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Clientes</title>
</head>
<body>
	<%
	Fachada fachada = Fachada.getInstance();
	List<Usuario> lista = fachada.cadastroUsuario().listar();
	for(Usuario u : lista){ %>
		Nome : <%=u.getNome() %> <a href="../controlador?acao=<%=Acoes.BUSCAR_CLIENTE + "&" + Parametros.ID_USUARIO + "=" + u.getId()%>">Atualizar</a> <br>
	<% } %>

</body>
</html>