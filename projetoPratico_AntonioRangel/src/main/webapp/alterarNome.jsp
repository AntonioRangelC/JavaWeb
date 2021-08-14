<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Alterar nome</title>
	</head>
	<body>
		<form action="AlterarNome?idPessoa=${idPessoa}" method="post">
			<div id="nomeCompleto">
				<p id="rotuloNome">Nome completo: ${nome} </p>
				<input type="text" id="nome" name="nome" value="${nome}"></input>
			</div>
			<div id="botaoEnviar">
				<input type="submit" id="botaoEnviar" value="Salvar"></input>
			</div>
		</form>
		<c:if test="${not empty erros}">
			<ul>
				<c:forEach items="${erros}" var="erro">
					<li style="color: red;">
						<c:out value="${erro}"></c:out>
					</li>
				</c:forEach>
			</ul>
		
		</c:if>
	</body>
</html>