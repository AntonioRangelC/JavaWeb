<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" language="java" %>
<%@ page import="java.util.ArrayList" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%
	// servlet - Servlet MVC - JSP + Scriptlet - (JSP + EL) + JSTL lib 
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Usando EL + JSTL</h1>
	<form action='cadastrarUsuario' method='get'>
		<label>Nome</label>
		<input type='text' name='nome' value='${param.nome}'/><br>
		<label>Sobrenome</label>
		<input  type='text' name='sobrenome' value='${param.sobrenome}'/><br>
		<input type='submit' value='Gravar'/>
		
		<a href="listarUsuarios">Listar Todos</a>
		
		<c:if test="${not empty erros}">
			<ul>
				<c:forEach items="${erros}" var="erro">
					<li>
						<c:out value="${erro}"></c:out>
					</li>
				</c:forEach>
			</ul>
		
		</c:if>
		
    </form>       
</body>
</html>