package servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "formCadastrarUsuario", description = "CadastraUsuario", urlPatterns = { "/formCadastrarUsuario" })
public class FormUsuario extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private String gerarPagina(List<String> erros) {
		StringBuilder html = new StringBuilder();
		
		// construir head (html aberto)
		html.append("<!DOCTYPE html>");
		html.append("<html>");
			html.append("<head>");
			html.append("	<meta charset=\"UTF-8\">");
			html.append("	<title>Cadastrar Usuario</title>");
			html.append("</head>");
			html.append("<body>");
				html.append("<h1>Cadastra Usuario</h1>");
				html.append("<form action='cadastrarUsuario' method='get'>");
					html.append("<label for='nome'>Nome</label>");
					html.append("<input type='text' name='nome' id='nome' required='required'><br>");
					html.append("<label for='sobrenome'>Sobrenome</label>");
					html.append("<input type='text' name='sobrenome' id='sobrenome' required='required'><br>");
					html.append("<button type='submit'>Gravar</button>");
				html.append("</form>");
				if (erros != null) {
					if (!erros.isEmpty()) {
						for (String erro : erros) {
							html.append("<ul>");
								html.append("<li style='color:red;'>");
									html.append(erro);
								html.append("</li>");
							html.append("</ul>");
						}
					}
				}
			html.append("</body>");
		html.append("</html>");

		return html.toString();
	}

	@Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
		/*
    	
    	
    	saida.println("<html>");
	    	saida.println("<head>");
		    	saida.println("<meta charset='ISO-8859-1'>");
		    	saida.println("<title>Cadastra Usuário</title>");
	    	saida.println("</head>");
	    	saida.println("<body>");
		    	saida.println("<form action=cadastrarUsuario method=get>");
			    	saida.println("<label>Nome</label>");
			    	saida.println("<input type=text name=nome><br>");
			    	saida.println("<label>Sobrenome</label>");
			    	saida.println("<input type=text name=sobrenome><br>");
			    	saida.println("<input type=submit value=Gravar>");
		    	saida.println("</form>");
		    	for(String erro: erros) {
		    		saida.println("<p style='color: red;'>"+ erro + "</p>");
		    	}
	    	saida.println("</body>");
    	saida.println("</html>");
        saida.close();
        System.out.println("Servlet de cadastro executada...");*/
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        List<String> erros = (List<String>) request.getAttribute("erros");
        PrintWriter saida = response.getWriter();
        saida.println(gerarPagina(erros));
        saida.close();
    }
}
