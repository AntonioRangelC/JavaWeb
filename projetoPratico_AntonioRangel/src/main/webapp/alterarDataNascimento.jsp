<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Alterar data de nascimento</title>
	</head>
	<body>
		<form action="AlterarDataNascimento?idPessoa=${idPessoa}" method="post">
			<div id="dataNascimento">
				<p id="rotuloData">Data de nascimento (dia/mes/ano): ${regrasNegocio.mudarFormatoDataParaDMY(dataNascimento)} </p>
				<input type="date" id="dataNascimento" name="dataNascimento" value="${regrasNegocio.mudarFormatoDataParaDMY(dataNascimento) }"></input>
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