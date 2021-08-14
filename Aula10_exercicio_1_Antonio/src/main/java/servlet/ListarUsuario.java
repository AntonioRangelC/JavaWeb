package servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet(name="listarUsuarios" ,urlPatterns="/listarUsuarios")
public class ListarUsuario extends HttpServlet
{
    
	private static final long serialVersionUID = 1L;

	@Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	List<Usuario> usuarios = null;
        try
        {
            UsuarioDAO dao = (UsuarioDAO)DAOFactory.getInstance().getDAO("dao.UsuarioDAO");
            usuarios = dao.listar();
                        

            
        } catch (DAOException e)
        {
            e.printStackTrace();
        }
        
        if(!usuarios.isEmpty()) {
        	request.setAttribute("usuarios", usuarios);       
            RequestDispatcher rd = request.getRequestDispatcher("listarUsuarios.jsp");
            rd.forward(request, response);
            return;
        }
    }
}
