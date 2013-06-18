<%@page import="br.com.yousoft.entidades.Usuario"%>
<%@page import="br.com.yousoft.util.Parametros"%>
<%@page import="br.com.yousoft.util.Acoes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Atualizar Cliente</title>
</head>
<body>
	<%
	Usuario edicao = (Usuario) session.getAttribute(Parametros.USUARIO_EDICAO);
	if(edicao != null){
	%>
	<form action="../controlador" method="POST">
		<input type="hidden" name="acao" value="<%=Acoes.ATUALIZAR_CLIENTE %>">
		<input type="hidden" name="id" value="<%=edicao.getId() %>">
		Nome : <input type="text" name="nome" value="<%=edicao.getNome() %>"><br>
		Login : <input type="text" name="login" value="<%=edicao.getLogin() %>"><br>
		Senha : <input type="password" name="senha"><br>
		<input type="submit" value="Atualizar">
	</form>
	<%} %>
</body>
</html>