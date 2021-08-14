package servlet;

import java.io.IOException;
import java.sql.Date;

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


@WebServlet(name="AlterarDataNascimento" , urlPatterns="/AlterarDataNascimento")
public class AlterarDataNascimento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegrasDeNegocio regrasNegocio = new RegrasDeNegocio();
		String dataNascimento_str = request.getParameter("dataNascimento");
		Date dataNascimento = Date.valueOf(dataNascimento_str);
		HttpSession session = request.getSession();
		
		session.setAttribute("dataNascimento", dataNascimento);
		session.setAttribute("regrasNegocio", regrasNegocio);
		
		response.sendRedirect("alterarDataNascimento.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String dataNascimento_str = request.getParameter("dataNascimento");
		String idPessoa = request.getParameter("idPessoa");
		Validador.validaData(dataNascimento_str);
		if(Validador.getErros().isEmpty()) {
			dataNascimento_str = RegrasDeNegocio.mudarFormatoData(dataNascimento_str);
			alterarDataNascimentoBanco(Date.valueOf(dataNascimento_str), new Integer(idPessoa));
			if(Validador.getErros().isEmpty()) {
				response.sendRedirect("inicio.jsp");
			}
			else if(!Validador.getErros().isEmpty()) {
				session.setAttribute("dataNascimento", dataNascimento_str);
				session.setAttribute("erros", Validador.getErros());
				response.sendRedirect("alterarDataNascimento.jsp");
			}
		}
		else if(!Validador.getErros().isEmpty()) {
			session.setAttribute("dataNascimento", dataNascimento_str);
			session.setAttribute("erros", Validador.getErros());
			response.sendRedirect("alterarDataNascimento.jsp");
		}
	}
	
	public static void alterarDataNascimentoBanco(Date dataNascimento, int idPessoa) {
		try {
			UsuarioDAO dao = (UsuarioDAO)DAOFactory.getInstance().getDAO("dao.UsuarioDAO");
			dao.alterarDataNascimento(dataNascimento, idPessoa);
			return;
		} catch(DAOException e) {
			e.printStackTrace();
			Validador.erros.clear();
			Validador.setErros("Nao foi possivel alterar a data de nascimento");
		}
	}

}
