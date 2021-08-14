<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Cadastro de usuario</title>
	</head>
	<body>
		<h1>Insira os dados</h1>
		<form action="CadastrarUsuario" method="get">
			<div id="nome">
				<p id="rotuloNome">Nome:</p>
				<input type="text" id="nome" name="nome"></input>
			</div>
			<div id="sobrenome">
				<p id="rotuloSobrenome">Sobrenome:</p>
				<input type="text" id="sobrenome" name="sobrenome"></input>
			</div>
			<div id="botaoEnviar">
				<input type="submit" id="botaoEnviar" value="Enviar"></input>
			</div>
			<% List<String> erros = (List<String>) request.getAttribute("erros"); %>
			<% if(erros != null && !erros.isEmpty()){ %>
				<%for(String erro : erros){ %>
				<ul>
					<li style="color: red;">
						<%= erro %>
					</li>
				</ul>	
				<%}%>
			<% } %>
		</form>
	</body>
	<style>
		body{
			display: flex;
			flex-direction: column;
		}
		div#nome{
			margin-left: 2rem;
			margin-top: 1rem;
			width: 30rem;
			display: flex;
			height: 1rem;
		}
		div#sobrenome{
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
		#nome{
			width: 15rem;
			height: 1rem;
			align-self: center;
		}
		#sobrenome{
			height: 1rem;
			width: 15rem;
			align-self: center;
		}
		
		p#rotuloNome{
			width: 9rem;
			align-self: center;

		}
		p#rotuloSobrenome{
			align-self: center;
			width: 9rem;
		}
	
	</style>
</html>