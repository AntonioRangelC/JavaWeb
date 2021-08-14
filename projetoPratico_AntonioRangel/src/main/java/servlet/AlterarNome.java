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


@WebServlet(name="AlterarNome" , urlPatterns="/AlterarNome")
public class AlterarNome extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("nome", request.getParameter("nome"));
		response.sendRedirect("alterarNome.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String idPessoa = request.getParameter("idPessoa");
		String nome = request.getParameter("nome");
		Validador.validaNome(nome);
		if(Validador.getErros().isEmpty()) {
			nome = RegrasDeNegocio.formatarNome(nome);
			alterarNomeNoBanco(nome, new Integer(idPessoa));
			if(Validador.getErros().isEmpty()) {
				response.sendRedirect("inicio.jsp");
			}
			else if(!Validador.getErros().isEmpty()) {
				session.setAttribute("nome", nome);
				session.setAttribute("erros", Validador.getErros());
				response.sendRedirect("alterarNome.jsp");
			}
		}
		else if(!Validador.getErros().isEmpty()) {
			session.setAttribute("nome", nome);
			session.setAttribute("erros", Validador.getErros());
			response.sendRedirect("alterarNome.jsp");
		}
	}
	
	public static void alterarNomeNoBanco(String nome, int idPessoa) {
		try {
			UsuarioDAO dao = (UsuarioDAO)DAOFactory.getInstance().getDAO("dao.UsuarioDAO");
			dao.alterarNome(nome, idPessoa);
			
			return;
		} catch(DAOException e) {
			e.printStackTrace();
			Validador.erros.clear();
			Validador.setErros("Nao foi possivel alterar o nome");
		}
	}

}
