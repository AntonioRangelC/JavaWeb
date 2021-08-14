package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOException;
import dao.DAOFactory;
import dao.UsuarioDAO;
import validator.Validador;


@WebServlet(name="AlterarAltura" ,urlPatterns="/AlterarAltura")
public class AlterarAltura extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("altura", request.getParameter("altura"));
		response.sendRedirect("alterarAltura.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String idPessoa = request.getParameter("idPessoa");
		String altura_str = request.getParameter("altura");
		Validador.validaAltura(altura_str);
		if(Validador.getErros().isEmpty()) {
			alterarAlturaNoBanco(Double.parseDouble(altura_str), new Integer(idPessoa));
			if(Validador.getErros().isEmpty()) {
				response.sendRedirect("inicio.jsp");
			}
			else if(!Validador.getErros().isEmpty()) {
				session.setAttribute("altura", altura_str);
				session.setAttribute("erros", Validador.getErros());
				response.sendRedirect("alterarAltura.jsp");
			}
		}
		else if(!Validador.getErros().isEmpty()) {
			session.setAttribute("altura", altura_str);
			session.setAttribute("erros", Validador.getErros());
			response.sendRedirect("alterarAltura.jsp");
		}
	}
	
	public static void alterarAlturaNoBanco(Double altura, int idPessoa) {
		try {
			UsuarioDAO dao = (UsuarioDAO)DAOFactory.getInstance().getDAO("dao.UsuarioDAO");
			dao.alterarAltura(altura, idPessoa);
			return;
		} catch(DAOException e) {
			e.printStackTrace();
			Validador.erros.clear();
			Validador.setErros("Nao foi possivel alterar a altura");
		}
	}

}
