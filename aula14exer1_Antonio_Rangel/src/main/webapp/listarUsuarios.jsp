<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Lista de usuarios</title>
	</head>
	<body>
		<table>
			<tr>
				<th>ID</th>
				<th>NOME</th>
				<th>SOBRENOME</th>
				<th>ACAO</th>
			</tr>
			<c:forEach items="${usuarios}" var="usuario" varStatus="i">
				<tr bgcolor="${i.count mod 2 == 0 ? 'lightgray':'white'}">
					<td>
						<c:out value="${usuario.getId()}"></c:out>
					</td>
					<td>
						<c:out value="${usuario.getNome()}"></c:out>
					</td>
					<td>
						<c:out value="${usuario.getSobrenome()}"></c:out>
					</td>
					<td>
						<a href='excluirUsuario?id=${usuario.getId()}'>Excluir</a>
					</td>
				</tr>
			</c:forEach>
		</table>			
		
		<a href="cadastrarUsuarioJstl.jsp">Novo</a>
	</body>
</html>