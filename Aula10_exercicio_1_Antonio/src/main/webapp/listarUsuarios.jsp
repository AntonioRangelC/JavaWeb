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
			</tr>
			<c:set var="usuarios" value="${usuarios}"></c:set>
			<c:forEach items="${usuarios}" var="usuario">
				<tr>
					<td>
						<c:out value="${usuario.getId()}"></c:out>
					</td>
					<td>
						<c:out value="${usuario.getNome()}"></c:out>
					</td>
					<td>
						<c:out value="${usuario.getSobrenome()}"></c:out>
					</td>
				</tr>
			</c:forEach>
		</table>			
	</body>
</html>