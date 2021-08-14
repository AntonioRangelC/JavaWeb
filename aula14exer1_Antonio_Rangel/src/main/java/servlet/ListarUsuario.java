package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOException;
import dao.DAOFactory;
import dao.UsuarioDAO;
import model.Usuario;

@WebServlet(name="listarUsuarios" ,urlPatterns="/listarUsuarios")
public class ListarUsuario extends HttpServlet
{
    
	private static final long serialVersionUID = 1L;

	
    protected void service(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException
    {
    	
    	HttpSession session = request.getSession();
		if(session.getAttribute("usuario") == null) {
			response.sendRedirect("login.jsp");
			return;
		}
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
        	session.setAttribute("usuarios", usuarios); 
            response.sendRedirect("listarUsuarios.jsp");
            return;
        }
    }
}
