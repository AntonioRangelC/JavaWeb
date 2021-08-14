<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.*" %>
<%@ page import = "model.Pessoa" %>
<%@ page import = "controller.RegrasDeNegocio" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Lista de pessoas</title>
		<script type="text/javascript">
			function confirmarExclusao(idPessoa,nome){
				if(confirm("Tem certeza que deseja excluir o cadastro de " + nome + " ?")){
					location.href='ExcluirPessoa?idPessoa=' + idPessoa;
				}
			}
		</script>
	</head>
	<body>
	
		<% if((request.getSession().getAttribute("pessoas") == null) == false) { %>
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
							<c:out value="${pessoa.getIdPessoa()}"></c:out>
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
							
							<button onClick="confirmarExclusao(${pessoa.getIdPessoa()}, '${pessoa.getNomeCompleto()}')">Excluir</button>
						</td>
						<td>
							<a href='AlterarPessoa?idPessoa=${pessoa.getIdPessoa()}'>
								<button>Alterar</button>      
							</a>
							
						</td>
					</tr>
				</c:forEach>
				
				<tr>
					<th bgcolor="${ 'lightblue' }">QUANTIDADE DE HOMENS:</th>
					<td> 
						<c:out value="${quantidade[0] }"></c:out>
					</td>
				</tr>
				<tr>
					<th bgcolor="${ 'lightblue' }">QUANTIDADE DE MULHERES:</th>
					<td>
						<c:out value="${quantidade[1] }"></c:out>
					</td>
				</tr>
			</table>
		<%} %>
		
		<c:if test="${not empty erros}">
			<c:out value="${erros.get(0)}"></c:out>
		</c:if>
	</body>
	<style>
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
	
	</style>
</html>