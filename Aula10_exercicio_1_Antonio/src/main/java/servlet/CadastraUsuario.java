package servlet;

import java.io.IOException;
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


@WebServlet(name="cadastrarUsuario",urlPatterns = "/cadastrarUsuario" )
public class CadastraUsuario extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome1 = request.getParameter("nome");
		String sobrenome1 = request.getParameter("sobrenome");
		
		List<String> erros = Validador.valida(request);
		if(!erros.isEmpty()) {
		    request.setAttribute("erros", erros);
		   // response.sendRedirect("/formCadastrarUsuario"); nao mantem a requisicao
		    RequestDispatcher rd = request.getRequestDispatcher("/cadastrarUsuario.jsp");
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        
	}

}
