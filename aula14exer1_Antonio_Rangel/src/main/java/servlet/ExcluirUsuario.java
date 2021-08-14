package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOException;
import dao.DAOFactory;
import dao.UsuarioDAO;


@WebServlet(name="excluirUsuario",urlPatterns = "/excluirUsuario" )
public class ExcluirUsuario extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idExclusao = request.getParameter("id");
		
		
		
		try
        {
            UsuarioDAO dao = (UsuarioDAO)DAOFactory.getInstance().getDAO("dao.UsuarioDAO");
            dao.excluir(new Integer(idExclusao));
 
        } catch (DAOException e)
        {
            e.printStackTrace();
        }
		//RequestDispatcher rd = request.getRequestDispatcher("/apresentarUsuario");
		//rd.forward(request, response);
		
		response.sendRedirect("listarUsuarios");
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
	}

}
