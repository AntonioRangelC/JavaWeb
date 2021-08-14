<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Alterar email secundario</title>
	</head>
	<body>
		<form action="AlterarEmailSec?idPessoa=${idPessoa }" method="post">
			<div id="emailSec">
				<p id="rotuloEmailSec">Email alternativo:</p>
				<input type="email" id="emailSec" name="emailSec" value="${emailSec }"></input>
			</div>
			<div id="botaoEnviar">
				<input type="submit" id="botaoEnviar" value="Salvar"></input>
			</div>
		</form>
	</body>
</html>