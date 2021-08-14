package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
import model.Pessoa;
import validator.Validador;


@WebServlet(name="ConsultarPessoa" , urlPatterns="/ConsultarPessoa")
public class ConsultarPessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pessoa pessoa = new Pessoa();
		RegrasDeNegocio regrasNegocio = new RegrasDeNegocio();
		String idPessoa = request.getParameter("idPessoa");
		HttpSession session = request.getSession();
		Validador.validaIdPessoa(idPessoa);
		if(!Validador.getErros().isEmpty()) {
			session.setAttribute("pessoa", null);
			session.setAttribute("erros", Validador.getErros());
			session.setAttribute("idPessoa", idPessoa);
			response.sendRedirect("consultarPessoa.jsp");
			return;
		}
		
		pessoa = buscarPessoaPeloIdPessoa(new Integer(idPessoa));
		if(!Validador.getErros().isEmpty()) {
			session.setAttribute("pessoa", null);
			session.setAttribute("erros", Validador.getErros());
			session.setAttribute("idPessoa", idPessoa);
			response.sendRedirect("consultarPessoa.jsp");
			return;
		}
		
		List<String> emails = buscarEmailsPeloIdPessoa(new Integer(idPessoa));
		if(!Validador.getErros().isEmpty()) {
			session.setAttribute("pessoa", null);
			session.setAttribute("erros", Validador.getErros());
			session.setAttribute("idPessoa", idPessoa);
			response.sendRedirect("consultarPessoa.jsp");
			return;
		}
		
		pessoa.setEmailPrimario(emails.get(0));
		pessoa.setEmailSecundario(emails.get(1));
		
		session.setAttribute("pessoa", pessoa);
		session.setAttribute("regrasNegocio", regrasNegocio);
	    response.sendRedirect("consultarPessoa.jsp");
		
	}
	
	public static Pessoa buscarPessoaPeloIdPessoa(int idPessoa) {
		Pessoa pessoa = new Pessoa();
		try {
			UsuarioDAO dao = (UsuarioDAO)DAOFactory.getInstance().getDAO("dao.UsuarioDAO");
			pessoa = dao.buscarPessoaPeloIdPessoa(idPessoa);
			if(pessoa.getNomeCompleto() == null) {
				Validador.setErros("Pessoa nao encontrada");
			}
			pessoa.setIdPessoa(idPessoa);
		} catch(DAOException e) {
			e.printStackTrace();
		}
		return pessoa;
	}
	
	public static List<String> buscarEmailsPeloIdPessoa(int idPessoa){
		List<String> emails =  new ArrayList<String>();
		try {
			UsuarioDAO dao = (UsuarioDAO)DAOFactory.getInstance().getDAO("dao.UsuarioDAO");
			emails = dao.buscarEmailsPeloId(idPessoa);
		} catch(DAOException e) {
			e.printStackTrace();
		}
		return emails;
		
	}
	
	

}
