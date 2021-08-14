<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Alterar altura</title>
	</head>
	<body>
		<form action="AlterarAltura?idPessoa=${idPessoa}" method="post">
			<div id="altura">
				<p id="rotuloAltura">Altura (em metros):</p>
				<input type="text" id="altura" name="altura" value="${altura }"></input>
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