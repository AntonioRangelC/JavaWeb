package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;

@WebServlet("/apresentarUsuario")
public class ApresentarUsuario extends HttpServlet
{
    @Override //atendimento genérico.
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/html");
        PrintWriter saida = resp.getWriter();
        
        String nome1 = req.getParameter("nome");
        String sobrenome1 = req.getParameter("sobrenome");
        
        Usuario usuario = new Usuario(nome1, sobrenome1);
        
        saida.println("<html>");
        saida.println("<head>");
            saida.println("<title>Usuarios Gravado(s)</title>");
        saida.println("</head>");
        
        saida.println("<body>");
            saida.println("NOME" + "&nbsp&nbsp&nbsp&nbsp" + "SOBRENOME<br>");
            saida.println("================================<br>");
            saida.println(usuario.getNome() + "&nbsp&nbsp&nbsp" + usuario.getSobrenome());
        saida.println("</body>");
        saida.println("</html>");
    }
}
