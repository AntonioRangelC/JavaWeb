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


@WebServlet(name="AlterarEmailPrim" , urlPatterns="/AlterarEmailPrim")
public class AlterarEmailPrim extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailPrim = request.getParameter("emailPrim");
		HttpSession session = request.getSession();
		session.setAttribute("emailPrim", emailPrim);
		response.sendRedirect("alterarEmailPrimario.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String idPessoa = request.getParameter("idPessoa");
		String emailPrim = request.getParameter("emailPrim");
		Validador.validaEmail(emailPrim);
		if(Validador.getErros().isEmpty()) {
			
			alterarEmailPrimNoBanco(emailPrim, new Integer(idPessoa));
			if(Validador.getErros().isEmpty()) {
				response.sendRedirect("inicio.jsp");
			}
			else if(!Validador.getErros().isEmpty()) {
				session.setAttribute("emailPrim", emailPrim);
				session.setAttribute("erros", Validador.getErros());
				response.sendRedirect("alterarEmailPrimario.jsp");
			}
		}
		else if(!Validador.getErros().isEmpty()) {
			session.setAttribute("emailPrim", emailPrim);
			session.setAttribute("erros", Validador.getErros());
			response.sendRedirect("alterarEmailPrimario.jsp");
		}
	}
	
	public void alterarEmailPrimNoBanco(String emailPrim, int idPessoa) {
		try {
			UsuarioDAO dao = (UsuarioDAO)DAOFactory.getInstance().getDAO("dao.UsuarioDAO");
			dao.alterarEmailPrim(emailPrim, idPessoa);
			return;
		} catch(DAOException e) {
			e.printStackTrace();
			Validador.erros.clear();
			Validador.setErros("Nao foi possivel alterar o email");
		}
	}

	
	

}
