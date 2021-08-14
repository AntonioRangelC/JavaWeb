package servlet;

import java.io.IOException;
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


@WebServlet("/PesquisarPessoa")
public class PesquisarPessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		RegrasDeNegocio regrasNegocio = new RegrasDeNegocio();
		String nome = request.getParameter("nome");
		System.out.println(nome);
		HttpSession session = request.getSession();
		Validador.verificarNomeVazio(nome);
		if(!Validador.getErros().isEmpty()) {
			session.setAttribute("pessoas", null);
			session.setAttribute("erros", Validador.getErros());
			session.setAttribute("nome", nome);
			response.sendRedirect("pesquisarPessoa.jsp");
			return;
		}
		
		pessoas = buscarPessoaPeloNome(nome);
		if(pessoas.size() == 0) {
			Validador.erros.clear();
			Validador.setErros("Nenuma pessoa foi encontrada");
		}
		if(!Validador.getErros().isEmpty()) {
			session.setAttribute("pessoas", null);
			session.setAttribute("erros", Validador.getErros());
			session.setAttribute("nome", nome);
			response.sendRedirect("pesquisarPessoa.jsp");
			return;
		}
		
		
		
		session.setAttribute("pessoas", pessoas);
		session.setAttribute("nome", nome);
		session.setAttribute("regrasNegocio", regrasNegocio);
	    response.sendRedirect("pesquisarPessoa.jsp");
	}
	
	public static List<Pessoa> buscarPessoaPeloNome(String nome) {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		try {
			UsuarioDAO dao = (UsuarioDAO)DAOFactory.getInstance().getDAO("dao.UsuarioDAO");
			pessoas = dao.buscarPessoasPeloNome(nome);
		} catch(DAOException e) {
			e.printStackTrace();
		}
		
		return pessoas;
	}

}
