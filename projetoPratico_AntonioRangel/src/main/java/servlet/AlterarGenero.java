package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.RegrasDeNegocio;
import dao.DAOException;
import dao.DAOFactory;
import dao.UsuarioDAO;
import validator.Validador;


@WebServlet(name="AlterarGenero" , urlPatterns="/AlterarGenero")
public class AlterarGenero extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String genero = request.getParameter("genero");
		HttpSession session = request.getSession();
		session.setAttribute("genero", genero);
		response.sendRedirect("alterarGenero.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String idPessoa = request.getParameter("idPessoa");
		String genero = request.getParameter("genero");
		Validador.validaGenero(genero);
		if(Validador.getErros().isEmpty()) {
			
			alterarGeneroNoBanco(genero, new Integer(idPessoa));
			if(Validador.getErros().isEmpty()) {
				response.sendRedirect("inicio.jsp");
			}
			else if(!Validador.getErros().isEmpty()) {
				session.setAttribute("genero", genero);
				session.setAttribute("erros", Validador.getErros());
				response.sendRedirect("alterarGenero.jsp");
			}
		}
		else if(!Validador.getErros().isEmpty()) {
			session.setAttribute("genero", genero);
			session.setAttribute("erros", Validador.getErros());
			response.sendRedirect("alterarGenero.jsp");
		}
	}
	
	public void alterarGeneroNoBanco(String genero, int idPessoa) {
		try {
			UsuarioDAO dao = (UsuarioDAO)DAOFactory.getInstance().getDAO("dao.UsuarioDAO");
			dao.alterarGenero(genero, idPessoa);
			
			return;
		} catch(DAOException e) {
			e.printStackTrace();
			Validador.erros.clear();
			Validador.setErros("Nao foi possivel alterar o genero");
		}
	}

}
