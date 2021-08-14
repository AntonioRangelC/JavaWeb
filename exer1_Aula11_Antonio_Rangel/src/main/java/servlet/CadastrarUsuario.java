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



@WebServlet(name = "CadastrarUsuario", urlPatterns = "/CadastrarUsuario")
public class CadastrarUsuario extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    
	    String nome1 = request.getParameter("nome");
		String sobrenome1 = request.getParameter("sobrenome");
		Validador.valida(request);
		
		List<String> erros = Validador.getErros();
		
		if(!erros.isEmpty()) {
		    request.setAttribute("erros", erros);
		    RequestDispatcher rd = request.getRequestDispatcher("cadastraUsuario.jsp");
	        rd.forward(request, response);
	        return;
		}
		
		Usuario usuario = new Usuario();
		usuario.setNome(nome1);
		usuario.setSobrenome(sobrenome1);
		
		
		try {
			UsuarioDAO dao = (UsuarioDAO)DAOFactory.getInstance().getDAO("dao.UsuarioDAO");
			dao.cadastrarUsuario(usuario);
		} catch (DAOException e) {
			Validador.setErros("Nao foi possivel cadastrar o usuario");
			e.printStackTrace();
		}
		
       
		response.sendRedirect("ListarUsuarios");
	
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		
	}

}
