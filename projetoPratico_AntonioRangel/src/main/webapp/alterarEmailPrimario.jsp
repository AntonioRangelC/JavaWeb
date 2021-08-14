<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Alterar email primario</title>
	</head>
	<body>
	<form action="AlterarEmailPrim?idPessoa=${idPessoa }" method="post">
		<div id="emailPrim">
			<p id="rotuloEmailPrim">Email:</p>
			<input type="email" id="emailPrim" name="emailPrim" value="${emailPrim }"></input>
		</div>
		<div id="botaoEnviar">
			<input type="submit" id="botaoEnviar" value="Salvar"></input>
		</div>
	</form>
	</body>
</html>