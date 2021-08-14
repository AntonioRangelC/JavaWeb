package servlet;

import java.io.IOException;
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


@WebServlet(name="ListarPessoas" ,urlPatterns="/ListarPessoas")
public class ListarPessoas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegrasDeNegocio regrasNegocio = new RegrasDeNegocio();
		HttpSession session = request.getSession();
		List<Pessoa> pessoas = null;
		try {
			UsuarioDAO dao = (UsuarioDAO)DAOFactory.getInstance().getDAO("dao.UsuarioDAO");
			pessoas = dao.listarPessoas();
		} catch (DAOException e) {
			
			e.printStackTrace();
		}
        Validador.erros.clear();
		if(pessoas.size() != 0) {
			session.setAttribute("regrasNegocio", regrasNegocio);
			session.setAttribute("pessoas", pessoas);
			session.setAttribute("quantidade", calculaQuantidadeDeCadaGenero(pessoas));
			response.sendRedirect("listarPessoas.jsp");
			return;
		}
		else if(pessoas.size() == 0) {
			Validador.setErros("Nao existem pessoas cadastradas");
			session.setAttribute("erros", Validador.getErros());
			session.setAttribute("pessoas", null);
			response.sendRedirect("listarPessoas.jsp");
			return;
		}
	}
	
	
	//esse metodo calcula a quantidade de pessoas de cada genero. E retorna um array que contem a 
	//quantidade de homens na posicao 0 e de mulheres na posicao 1;
	private int[] calculaQuantidadeDeCadaGenero(List<Pessoa> pessoas) {
		int quantidade[] = {0,0};
		int homens=0;
		int mulheres=0;
		for(Pessoa pessoa: pessoas) {
			if(pessoa.getGenero().equals("F")) {
				mulheres++;
			}
			else if(pessoa.getGenero().equals("M")) {
				homens++;
			}
		}
		quantidade[0] = homens;
		quantidade[1] = mulheres;
		return quantidade;
	}
	
	

	

}
