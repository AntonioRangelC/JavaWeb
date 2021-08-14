<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" language="java" %>
<%@ page import="java.util.ArrayList" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action='cadastrarUsuario' method='get'>
		<label>Nome</label>
		<input type='text' name='nome' value='<%=(request.getParameter("nome") == null ? "": request.getParameter("nome"))%>'/><br>
		<label>Sobrenome</label>
		<input  type='text' name='sobrenome' value='<%=(request.getParameter("sobrenome") == null ? "": request.getParameter("sobrenome") )%>'/><br>
		<input type='submit' value='Gravar'/>
		<% List<String> erros = (ArrayList<String>)request.getAttribute("erros"); %>
        <% if(erros != null && !erros.isEmpty()) { %>
        		<ul>
                 <% for (String erro : erros) {%>      
	                 <li> 
	                    <%=erro%>
	                  </li> 
                 <%}%>
            </ul>
        <%}%>       
</body>
</html>