<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Alterar genero</title>
	</head>
	<body>
		<form action="AlterarGenero?idPessoa=${idPessoa }" method="post">
			<div id="genero">
				
				<p id="rotuloGenero">Genero:</p>
				<c:if test="${genero == 'F' }">
					<input type="radio" id="generoFem" name="genero" value="F"  checked ></input>
					<label for="generoFem">Feminino</label><br>
					<input type="radio" id="generoMas" name="genero" value="M"></input>
					<label for="generoMas">Masculino</label><br>
				</c:if>
				<c:if test="${genero == 'M' }">
					<input type="radio" id="generoFem" name="genero" value="F"   ></input>
					<label for="generoFem">Feminino</label><br>
					<input type="radio" id="generoMas" name="genero" value="M" checked></input>
					<label for="generoMas">Masculino</label><br>
				</c:if>
			</div>
			<div id="botaoEnviar">
				<input type="submit" id="botaoEnviar" value="Salvar"></input>
			</div>
		</form>
	</body>
</html>