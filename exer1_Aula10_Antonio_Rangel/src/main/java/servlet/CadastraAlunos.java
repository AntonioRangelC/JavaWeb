package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dados.Aluno;


@WebServlet("/CadastraAlunos")
public class CadastraAlunos extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeCompleto = request.getParameter("nome");
		String matricula_str = request.getParameter("matricula");
		String curso = request.getParameter("curso");
		String semestre_str = request.getParameter("semestreAtual");
		String IRA_str = request.getParameter("IRA");
		
		int matricula = Integer.parseInt(matricula_str);
		int semestreAtual = Integer.parseInt(semestre_str);
		double IRA = Double.parseDouble(IRA_str);
		
		Aluno aluno = new Aluno(
				nomeCompleto,
				matricula,
				curso,
				semestreAtual,
				IRA
		);
		PrintWriter saida = response.getWriter();
		
		saida.println("<html>");
			saida.println("<head>");
				saida.println("<meta charset=\"UTF-8\">");
				saida.println("<title>Registro</title>");
			saida.println("</head>");
			saida.println("<body>");
				saida.println("<h1>Dados do aluno</h1>");
				saida.println("<p>Nome: " +aluno.getNome() + "</p>");
				saida.println("<p>Matricula: " +aluno.getMatricula() + "</p>");
				saida.println("<p>Curso: " +aluno.getCurso() + "</p>");
				saida.println("<p>Semestre atual: " +aluno.getSemestreAtual() + "</p>");
				saida.println("<p>IRA: " +aluno.getIRA() + "</p>");
			saida.println("</body");
		saida.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
