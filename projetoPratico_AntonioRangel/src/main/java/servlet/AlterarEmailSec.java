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


@WebServlet(name="AlterarEmailSec" , urlPatterns="/AlterarEmailSec")
public class AlterarEmailSec extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailSec = request.getParameter("emailSec");
		HttpSession session = request.getSession();
		session.setAttribute("emailSec", emailSec);
		response.sendRedirect("alterarEmailSecundario.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String idPessoa = request.getParameter("idPessoa");
		String emailSec = request.getParameter("emailSec");
		Validador.validaEmail(emailSec);
		if(Validador.getErros().isEmpty()) {
			
			alterarEmailSecNoBanco(emailSec, new Integer(idPessoa));
			if(Validador.getErros().isEmpty()) {
				response.sendRedirect("inicio.jsp");
			}
			else if(!Validador.getErros().isEmpty()) {
				session.setAttribute("emailSec", emailSec);
				session.setAttribute("erros", Validador.getErros());
				response.sendRedirect("alterarEmailSecundario.jsp");
			}
		}
		else if(!Validador.getErros().isEmpty()) {
			session.setAttribute("emailSec", emailSec);
			session.setAttribute("erros", Validador.getErros());
			response.sendRedirect("alterarEmailSecundario.jsp");
		}
	}
	
	public void alterarEmailSecNoBanco(String emailSec, int idPessoa) {
		try {
			UsuarioDAO dao = (UsuarioDAO)DAOFactory.getInstance().getDAO("dao.UsuarioDAO");
			dao.alterarEmailSec(emailSec, idPessoa);
			return;
		} catch(DAOException e) {
			e.printStackTrace();
			Validador.erros.clear();
			Validador.setErros("Nao foi possivel alterar o email");
		}
	}

	
	

}
