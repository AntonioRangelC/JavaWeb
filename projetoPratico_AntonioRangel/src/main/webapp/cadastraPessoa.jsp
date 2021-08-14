<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>Cadastro de pessoa</title>
	</head>
	<body>
		<h1>Insira os dados </h1>
		<form action="CadastrarPessoa" method="post">
			<div id="nomeCompleto">
				<p id="rotuloNome">Nome completo:</p>
				<input type="text" id="nome" name="nome" value="${nome}"></input>
			</div>
			<div id="dataNascimento">
				<p id="rotuloData">Data de nascimento (dia/mes/ano):</p>
				<input type="date" id="dataNascimento" name="dataNascimento" value="${dataNascimento }"></input>
			</div>
			<div id="altura">
				<p id="rotuloAltura">Altura (em metros):</p>
				<input type="text" id="altura" name="altura" value="${altura }"></input>
			</div>
			<div id="genero">
				<p id="rotuloGenero">Genero:</p>
				<input type="radio" id="generoFem" name="genero" value="F" 
					<c:if test="${genero == 'F' }  or ${genero == null} " >
						checked
					</c:if>
				>
				
				<label for="generoFem">Feminino</label><br>
				<input type="radio" id="generoMas" name="genero" value="M"
					<c:if test="${genero == 'M' }" >
						checked
					</c:if>
				>
				
				<label for="generoMas">Masculino</label><br>
			</div>
			<div id="emailPrim">
				<p id="rotuloEmailPrim">Email:</p>
				<input type="email" id="emailPrim" name="emailPrim" value="${emailPrim }"></input>
			</div>
			<div id="emailSec">
				<p id="rotuloEmailSec">Email alternativo:</p>
				<input type="email" id="emailSec" name="emailSec" value="${emailSec }"></input>
			</div>
			<div id="botaoEnviar">
				<input type="submit" id="botaoEnviar" value="Enviar"></input>
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
		<c:if test="${not empty respostaPositiva }">
			<h3 style="color: green;"> ${respostaPositiva} </h3>
		</c:if>
	</body>
	<style>
		body{
			display: flex;
			flex-direction: column;
		}
		div#nomeCompleto{
			margin-left: 2rem;
			margin-top: 1rem;
			width: 30rem;
			display: flex;
			height: 1rem;
		}
		div#dataNascimento{
			margin-top: 2rem;
			margin-left: 2rem;
			width: 30rem;
			display: flex;
			
		}
		div#altura{
			margin-top: 2rem;
			margin-left: 2rem;
			width: 30rem;
			display: flex;
		}
		div#genero{
			margin-top: 2rem;
			margin-left: 2rem;
			width: 30rem;
		}
		div#emailPrim{
			margin-top: 2rem;
			margin-left: 2rem;
			width: 30rem;
			display: flex;
		}
		div#emailSec{
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
		#dataNascimento{
			height: 1rem;
			width: 10rem;
			align-self: center;
		}
		#altura{
			width: 8rem;
			height: 1rem;
			align-self: center;
		}
		#emailPrim{
			width: 15rem;
			height: 1rem;
			align-self: center;
		}
		#emailSec{
			width: 15rem;
			height: 1rem;
			align-self: center;
		}
		p#rotuloNome{
			width: 9rem;
			align-self: center;

		}
		p#rotuloData{
			align-self: center;
			width: 9rem;
		}
		p#rotuloAltura{
			align-self: center;
			width: 9rem;
		}
		p#rotuloGenero{
			align-self: center;
			width: 9rem;
		}
		p#rotuloEmailPrim{
			width: 9rem;
			align-self: center;
		}
		p#rotuloEmailSec{
			width: 9rem;
			align-self: center;
		}
	</style>
</html>