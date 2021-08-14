<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>Alterar cadastro</title>
	</head>
	<body>
		<h1>Altere os dados que desejar </h1>
		
			<div id="nomeCompleto">
				<p id="rotuloNome">Nome completo: ${nome} </p>
				<a href='AlterarNome?nome=${nome}'>Alterar nome</a>
			</div>
			<div id="dataNascimento">
				<p id="rotuloData">Data de nascimento (dia/mes/ano): ${regrasNegocio.mudarFormatoDataParaDMY(dataNascimento)} </p>
				<a href='AlterarDataNascimento?dataNascimento=${dataNascimento}'>Alterar data de nascimento</a>
			</div>
			<div id="altura">
				<p id="rotuloAltura">Altura (em metros): ${altura} </p>
				<a href='AlterarAltura?altura=${altura}'>Alterar altura</a>
			</div>
			<div id="genero">
				
				<p id="rotuloGenero">Genero: 
					<c:if test="${genero == 'F' }">
						<c:out value="Feminino"></c:out>
					</c:if>
					<c:if test="${genero == 'M' }">
						<c:out value="Masculino"></c:out>
					</c:if>
					
				</p>
				<a href='alterarGenero.jsp'>Alterar genero</a>
			</div>
			<div id="emailPrim">
				<p id="rotuloEmailPrim">Email: ${emailPrim} </p>
				<a href='alterarEmailPrimario.jsp'>Alterar email primario</a>
			</div>
			<div id="emailSec">
				<p id="rotuloEmailSec">Email alternativo: ${emailSec}  </p>
				<a href='alterarEmailSecundario.jsp'>Alterar email alternativo</a>
			</div>
			
	</body>
	<style>
		body{
			height: 100%;
			width: 100%;
			display: flex;
			flex-direction: column;
			align-items: start;
		}
		div#nomeCompleto{
			margin-left: 2rem;
			margin-top: 1rem;
			width: 40rem;
			display: flex;
			height: 3rem;
			align-items: center;
			
		}
		div#dataNascimento{
			margin-top: 2rem;
			margin-left: -42rem;
			width: 40rem;
			height: 3rem;
			display: flex;
			align-items: center;
			justify-self: start;
			
		}
		div#altura{
			margin-top: 2rem;
			margin-left: -42rem;
			width: 40rem;
			height: 3rem;
			display: flex;
			align-items: center;
			
		}
		div#genero{
			margin-top: 2rem;
			margin-left: 2rem;
			width: 40rem;
			height: 3rem;
			display: flex;
			align-items: center;
		}
		div#botaoEnviar{
			margin-top: 2rem;
			margin-left: 1rem;
			width: 15rem;
			height: 2rem;
		}
		div#emailPrim{
			margin-left: 2rem;
			margin-top: 1rem;
			width: 40rem;
			display: flex;
			height: 3rem;
			align-items: center;
		
		}
		div#emailSec{
			margin-left: 2rem;
			margin-top: 1rem;
			width: 40rem;
			display: flex;
			height: 3rem;
			align-items: center;
		
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
		
		p#rotuloNome{
			width: 20rem;
		}
		
		p#rotuloData{
			width: 20rem;
		}
		
		p#rotuloAltura{
			width: 20rem;
		}
		
		p#rotuloGenero{
			width: 20rem;
		}
		
		p#rotuloEmailPrim{
			width: 20rem;
		}
		
		p#rotuloEmailSec{
			width: 20rem;
		}
	</style>
</html>