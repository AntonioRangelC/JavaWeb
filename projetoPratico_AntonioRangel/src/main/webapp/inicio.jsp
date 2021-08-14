<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Pagina inicial</title>
	</head>
	<body>
		<% request.getSession().setAttribute("erros", null); %>
		<h1>Menu principal</h1>
		<div id="corpo">
			<a href="cadastraPessoa.jsp">
				<button type="button">Cadastrar pessoa</button>
			</a>
			<a href="ListarPessoas">
				<button type="button">Listar todas pessoas</button>
			</a>
			<a href="consultarPessoa.jsp?pessoa='null'">
				<button type="button">Consultar registro de uma pessoa</button>
			</a>
			<a href="pesquisarPessoa.jsp?pessoas='null'">
				<button type="button">Pesquisar pessoa pelo nome</button>
			</a>
			
		</div>
		
	</body>
	<style>
		body{
			display: flex;
			flex-direction:column;
			justify-content: center;
			align-items: center;
		}
		div#corpo{
			height: 10rem;
			width: 15rem;
			display: flex;
			flex-direction: column;
			justify-content: space-around;
			align-items: center;
			
		}
	</style>
</html>