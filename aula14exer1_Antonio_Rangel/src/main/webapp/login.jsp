<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login</title>
	</head>
	<body>
		<h1>Insira o usuario e senha</h1>
		<form action="LoginUsuario" method="post">
			<div id="usuario">
				<p id="rotuloUsuario">Usuario:</p>
				<input type="text" id="usuario" name="usuario"></input>
			</div>
			<div id="senha">
				<p id="rotuloSenha">Senha:</p>
				<input type="password" id="senha" name="senha"></input>
			</div>
			<div id="botaoEnviar">
				<input type="submit" id="botaoEnviar" value="Enviar"></input>
			</div>
			<c:if test="${not empty erros}">
			<ul>
				<c:forEach items="${erros}" var="erro">
					<li style="color:red;">
						<c:out value="${erro}"></c:out>
					</li>
				</c:forEach>
			</ul>
		
		</c:if>
		</form>
	</body>
	<style>
		body{
			display: flex;
			flex-direction: column;
		}
		div#usuario{
			margin-left: 2rem;
			margin-top: 1rem;
			width: 30rem;
			display: flex;
			height: 1rem;
		}
		div#senha{
			margin-top: 2rem;
			margin-left: 2rem;
			width: 30rem;
			display: flex;
			
		}
		div#botaoEnviar{
			margin-top: 2rem;
			margin-left: 2rem;
			width: 15rem;
			height: 2rem;
			
		}
		#usuario{
			width: 15rem;
			height: 1rem;
			align-self: center;
		}
		#senha{
			height: 1rem;
			width: 15rem;
			align-self: center;
		}
		
		p#rotuloUsuario{
			width: 9rem;
			align-self: center;

		}
		p#rotuloSenha{
			align-self: center;
			width: 9rem;
		}
	
	</style>
</html>