<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.*" %>
<%@ page import = "model.Usuario" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<table>
			<tr>
				<th>ID</th>
				<th>NOME</th>
				<th>SOBRENOME</th>
			</tr>
			<%  List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios"); %>
			
			<% for(Usuario usu: usuarios){%>
				<tr>
					<td>
						<%= usu.id %>
					</td>
					<td>
						<%= usu.nome %>
					</td>
					<td>
						<%= usu.sobrenome %>
					</td>
				</tr>
			<% } %>
		</table>
	</body>
</html>