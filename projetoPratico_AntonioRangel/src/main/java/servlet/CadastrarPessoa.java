package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pessoa;
import dao.DAOException;
import dao.DAOFactory;
import dao.UsuarioDAO;
import validator.Validador;


@WebServlet(name="CadastrarPessoa", urlPatterns="/CadastrarPessoa")
public class CadastrarPessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String dataNascimento_str = request.getParameter("dataNascimento");
		System.out.println("data " + dataNascimento_str);
		String altura_str = request.getParameter("altura");	
		String genero = request.getParameter("genero");
		String emailPrimario = request.getParameter("emailPrim");
		String emailSecundario = request.getParameter("emailSec");
		double altura = 0.0;
		
		if(!altura_str.isEmpty()) {
			altura = Double.parseDouble(altura_str);
		}
		
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		pessoa.setAltura(altura);
		pessoa.setGenero(genero);
		pessoa.setEmailPrimario(emailPrimario);
		pessoa.setEmailSecundario(emailSecundario);
		
		Validador.valida(pessoa, dataNascimento_str); 
		
		HttpSession session = request.getSession();
		session.setAttribute("nome", nome);
		session.setAttribute("dataNascimento", pessoa.getDataNascimento());	
		session.setAttribute("altura", altura);	
		session.setAttribute("genero", genero);	
		session.setAttribute("emailPrim", emailPrimario);
		session.setAttribute("emailSec", emailSecundario);
		
		if(!Validador.getErros().isEmpty()) {
		    session.setAttribute("erros", Validador.getErros());
		    response.sendRedirect("cadastraPessoa.jsp");
	        return;
		}
		
		
		try {
			UsuarioDAO dao = (UsuarioDAO)DAOFactory.getInstance().getDAO("dao.UsuarioDAO");
			dao.cadastrarPessoa(pessoa);
			session.setAttribute("nome", null);
			session.setAttribute("dataNascimento", null);	
			session.setAttribute("altura", null);	
			session.setAttribute("genero", null);	
			session.setAttribute("emailPrim", null);
			session.setAttribute("emailSec", null);
			session.setAttribute("respostaPositiva", "Usuario cadastrado com sucesso");
			response.sendRedirect("cadastraPessoa.jsp");
			return;
		} catch (DAOException e) {
			e.printStackTrace();
			Validador.erros.clear();
			Validador.setErros("Nao foi possivel cadastrar a pessoa");
			session.setAttribute("erros", Validador.getErros());
			response.sendRedirect("cadastraPessoa.jsp");
			return;
		}
 
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
