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
import validator.Validador;


@WebServlet(name="cadastrarUsuario",urlPatterns = "/cadastrarUsuario" )
public class CadastraUsuario extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("usuario") == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		session.setAttribute("nome", request.getParameter("nome"));
		session.setAttribute("sobrenome", request.getParameter("sobrenome"));
		String nome1 = (String) session.getAttribute("nome");
		String sobrenome1 = (String) session.getAttribute("sobrenome");
		
		List<String> erros = Validador.validaCamposCadastro(session);
		if(!erros.isEmpty()) {
			
		   session.setAttribute("erros", erros);
		   
		   response.sendRedirect("cadastrarUsuarioJstl.jsp");
	        
		    return;
		}
		
		Usuario usuario = new Usuario(nome1, sobrenome1);
		try
        {
            UsuarioDAO dao = (UsuarioDAO)DAOFactory.getInstance().getDAO("dao.UsuarioDAO");
            dao.cadastrar(usuario);
            session.setAttribute("erros", null);
 
        } catch (DAOException e)
        {
            e.printStackTrace();
        }
		
		
		response.sendRedirect("listarUsuarios");
	
	}

	

}
