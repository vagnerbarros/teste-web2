<%@page import="br.com.yousoft.util.Pagina"%>
<%@page import="br.com.yousoft.dominio.Perfil"%>
<%@page import="br.com.yousoft.entidades.Usuario"%>
<%@page import="br.com.yousoft.util.Parametros"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	Usuario usuario = (Usuario) session.getAttribute(Parametros.USUARIO_LOGADO);
	if(usuario != null){ %>
		Bem Vindo <%=usuario.getNome() %> <br>
		
		<%if(usuario.getPerfil().equals(Perfil.ADMIN)){ %>
				<a href="<%=Pagina.CADASTRAR_CLIENTE %>">Cadastrar Cliente</a>
		<%} %>
	<% } %>


</body>
</html>