package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOException;
import dao.DAOFactory;
import dao.UsuarioDAO;
import model.Usuario;
import validator.Validador;

@WebServlet("/gio")
public class ServletGiovanna extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
     // html dentro do java.
        StringBuilder html = new StringBuilder();
        html.append("<html>");
            html.append("<body>");
                //form
                html.append("<form action='gio' method='post'>");
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
        System.out.println("gio em ação...");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String nome1 = request.getParameter("nome");
        String sobrenome1 = request.getParameter("sobrenome");
        
        List<String> erros = Validador.valida(request);
        if(!erros.isEmpty()) {
            request.setAttribute("erros", erros);
           // response.sendRedirect("/formCadastrarUsuario"); nao mantem a requisicao
            RequestDispatcher rd = request.getRequestDispatcher("/formCadastrarUsuario");
            rd.forward(request, response);
            return;
        }
        
        Usuario usuario = new Usuario(nome1, sobrenome1);
        try
        {
            UsuarioDAO dao = (UsuarioDAO)DAOFactory.getInstance().getDAO("dao.UsuarioDAO");
            dao.cadastrar(usuario);
 
        } catch (DAOException e)
        {
            e.printStackTrace();
        }
        //RequestDispatcher rd = request.getRequestDispatcher("/apresentarUsuario");
        //rd.forward(request, response);
        
        response.sendRedirect("listarUsuarios");
        
    }
}
