package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/formCadastrarUsuario")
public class FormUsuario extends HttpServlet
{
    @SuppressWarnings("unchecked")
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // html dentro do java.
        StringBuilder html = new StringBuilder();
        html.append("<html>");
            html.append("<body>");
                //form
                html.append("<form action='cadastrarUsuario' method='get'>");
                    //nome
                    html.append("<label>Nome</label>");
                    html.append("<input type='text' name='nome' value='"+(request.getParameter("nome") == null ? "": request.getParameter("nome") ) +"'/><br>");//request.getParameter("nome") == null ? "": request.getParameter("nome") 
                    //sobrenome
                    html.append("<label>Sobrenome</label>");
                    html.append("<input type='text' name='sobrenome' value='"+ (request.getParameter("sobrenome") == null ? "": request.getParameter("sobrenome") )+"'/><br>");
                    //sbmit
                    html.append("<input type=\"submit\" value=\"Gravar\">");
                html.append(" </form>");   
                html.append(" <br>");
                
                //tratamento de erros do formulario
                
                List<String> erros = (ArrayList<String>)request.getAttribute("erros");
                if(erros != null && !erros.isEmpty()) {
                
                    html.append(" <ul> ");
                        for (String erro : erros)
                        {
                            html.append(" <li> ");
                                html.append(erro);
                            html.append(" </li> ");
                        }
                    html.append(" </ul> ");
                }
                
            html.append("</body>");    
        html.append("</html>");   
        
        PrintWriter browser = response.getWriter();
        browser.print(html.toString());
        browser.close();
    }
}
