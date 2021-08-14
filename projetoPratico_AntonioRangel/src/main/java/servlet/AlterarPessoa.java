package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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


@WebServlet(name="AlterarPessoa" , urlPatterns="/AlterarPessoa")
public class AlterarPessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String idPessoa = request.getParameter("idPessoa");
		
		
		List<String> emails = buscarEmailsPeloId(new Integer(idPessoa));
		String emailPrim = emails.get(0);
		String emailSec = emails.get(1);
		
		Pessoa pessoa = buscarPessoaPeloId(new Integer(idPessoa));
		
		session.setAttribute("nome", pessoa.getNomeCompleto());
		session.setAttribute("idPessoa", idPessoa);
		session.setAttribute("altura", pessoa.getAltura());
		session.setAttribute("genero", pessoa.getGenero());
		session.setAttribute("dataNascimento", pessoa.getDataNascimento());
		session.setAttribute("emailPrim", emailPrim);
		session.setAttribute("emailSec", emailSec);
		
		if(!Validador.getErros().isEmpty()) {
		    session.setAttribute("erros", Validador.getErros());
		    response.sendRedirect("alterarPessoa.jsp");
	        return;
		}
		
		response.sendRedirect("alterarPessoa.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String acao = request.getParameter("acao");
		String idPessoa = request.getParameter("idPessoa");
		switch(acao) {
		
			case "alterarNome":
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
				break;
				
			case "alterarAltura":
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
				break;
				
			case "dataNascimento":
				String dataNascimento_str = request.getParameter("dataNascimento");
				Validador.validaData(dataNascimento_str);
				if(Validador.getErros().isEmpty()) {
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
				break;
		
		
		}
		/*
		String dataNascimento_str = request.getParameter("dataNascimento");
			
		String genero = request.getParameter("genero");
		String emailPrimario = request.getParameter("emailPrim");
		String emailSecundario = request.getParameter("emailSec");
		String idPessoa = request.getParameter("idPessoa");
		double altura = 0.0;
		
		
		
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		pessoa.setAltura(altura);
		pessoa.setGenero(genero);
		pessoa.setEmailPrimario(emailPrimario);
		pessoa.setEmailSecundario(emailSecundario);
		pessoa.setIdPessoa(new Integer(idPessoa));
		
		Validador.valida(pessoa, dataNascimento_str); 
		
		
		session.setAttribute("nome", nome);
		session.setAttribute("dataNascimento", pessoa.getDataNascimento());	
		session.setAttribute("altura", altura);	
		session.setAttribute("genero", genero);	
		session.setAttribute("emailPrim", emailPrimario);
		session.setAttribute("emailSec", emailSecundario);
		
		if(!Validador.getErros().isEmpty()) {
		    session.setAttribute("erros", Validador.getErros());
		    response.sendRedirect("alterarPessoa.jsp");
	        return;
		}
		
		
		try {
			UsuarioDAO dao = (UsuarioDAO)DAOFactory.getInstance().getDAO("dao.UsuarioDAO");
			dao.alterarPessoa(pessoa);
			dao.alterarEmails(emailPrimario, emailSecundario, new Integer(idPessoa));
			session.setAttribute("respostaPositiva", "Usuario alterado com sucesso");
			response.sendRedirect("alterarPessoa.jsp");
			return;
		} catch (DAOException e) {
			e.printStackTrace();
			Validador.setErros("Nao foi possivel alterar os dados");
			session.setAttribute("erros", Validador.getErros());
			response.sendRedirect("alterarPessoa.jsp");
			return;
		}*/
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
	
	public static List<String> buscarEmailsPeloId(int idPessoa) {
		List<String> emails = new ArrayList<String>();
		try {
			UsuarioDAO dao = (UsuarioDAO)DAOFactory.getInstance().getDAO("dao.UsuarioDAO");
			emails = dao.buscarEmailsPeloId(idPessoa);
		} catch(DAOException e) {
			e.printStackTrace();
		}
		
		return emails;
		
		
	}
	
	public static Pessoa buscarPessoaPeloId(int idPessoa) {
		Pessoa pessoa = new Pessoa();
		try {
			UsuarioDAO dao = (UsuarioDAO)DAOFactory.getInstance().getDAO("dao.UsuarioDAO");
			pessoa = dao.buscarPessoaPeloIdPessoa(idPessoa);
		} catch(DAOException e) {
			e.printStackTrace();
		}
		
		return pessoa;
	}

}
