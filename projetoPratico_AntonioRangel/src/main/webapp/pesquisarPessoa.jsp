<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Pesquisar</title>
	</head>
	<body>
		<h1>Insira o nome da pessoa</h1>
		
		<form action="PesquisarPessoa" method="post">
			<div id="barraProcura">
				<div id="barra">
					<input type="text"  id="barraPesquisa" value="${nome}" name="nome" > </input>
				</div>
				
				<div id="botaoEnviar">
					<input type="submit" id="botaoEnviar" value="Enviar"></input>
				</div>
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
		<% if((request.getSession().getAttribute("pessoas") == null) == false) { %>
			
			<div id="resultado" >
				<table>
					<tr>
						<th>ID</th>
						<th>NOME COMPLETO</th>
						<th>ALTURA</th>
						<th>GENERO</th>
						<th>DATA DE NASCIMENTO</th>
					</tr>
					<c:forEach items="${pessoas}" var="pessoa" varStatus="i">
						<tr bgcolor="${i.count mod 2 == 0 ? 'lightgray':'white'}">
							<td>
								<c:out value="${ pessoa.getIdPessoa() }"></c:out>
							</td>
							<td>
								<c:out value="${pessoa.getNomeCompleto()}"></c:out>
							</td>
							<td>
								<c:out value="${pessoa.getAltura()}"></c:out>
							</td>
							<td>
								<c:out value="${pessoa.getGenero()}"></c:out>
							</td>
							<td>
								<c:out value="${regrasNegocio.mudarFormatoDataParaDMY(pessoa.getDataNascimento())}"></c:out>
							</td>
							<td>
								<c:out value="${pessoa.getEmailPrimario() }"></c:out>
							</td>
							<td>
								<c:out value="${pessoa.getEmailSecundario() }"></c:out>
							</td>
							
						</tr>
					</c:forEach>
				</table>
			
			
			</div>
		<%} %>
	</body>
	<style>
		body{
			display: flex;
			flex-direction: column;
			align-items: center;
			justify-content: center;
		}
		div#barraProcura{
			display: flex;
			flex-direction: row;
			width: 40rem;
			height: 10rem;
			justify-content: center;
			
		}
		div#botaoEnviar{
			height: 2rem;
			width: 4rem;
			
		}
		div#barra{
			width: 20rem;
			height: 5rem;
			
		}
		div#resultado{
			height: 20rem;
			width: 100%;
		
		}
		th{
			width: 12rem;
			padding: 10px;
			text-align: center;
		}
		td{
			width: 12rem;
			padding: 10px;
			text-align: center;
		
		}
		#barraPesquisa{
			width: 15rem;
		}
	
	</style>
</html>