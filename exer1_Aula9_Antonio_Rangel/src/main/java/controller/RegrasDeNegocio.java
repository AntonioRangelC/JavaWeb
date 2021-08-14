package controller;

import java.util.ArrayList;

import model.Aluno;
import model.Universidade;
import view.Visao;

public class RegrasDeNegocio {
	private static final double MEDIA_IRA = 3.0;
	private static int matriculaSistema = 1;
	public static void fazCadastro() {
		Aluno aluno = new Aluno();
		String nome;
		String curso;
		int semestreAtual;
		double IRA;
		
		nome = Leitura.lerString("nome do aluno");
		nome = Validacao.validarString(nome);
		aluno.setNome(nome);
		
		Visao.saltaLinhas(2);
		
		matriculaSistema++;
		aluno.setMatricula(matriculaSistema);
		
		curso = Leitura.lerString("curso do aluno");
		curso = Validacao.validarString(curso);
		aluno.setCurso(curso);
		
		Visao.saltaLinhas(2);
		
		semestreAtual = Leitura.lerInt("semestre atual do aluno");
		semestreAtual = Validacao.validarInt(semestreAtual);
		aluno.setSemestreAtual(semestreAtual);
		
		Visao.saltaLinhas(2);
		
		IRA = Leitura.lerDouble("IRA do aluno");
		IRA = Validacao.validarDouble(IRA);
		aluno.setIRA(IRA);
		
		
		Universidade.alunos.add(aluno);
	}
	
	public static void listarAlunos() {
		System.out.println("Matricula\tNome\t\tCurso\t\tSemestre Atual\tIndice de rendimento academico");
		for(Aluno aluno : Universidade.alunos) {
			System.out.println(aluno.getMatricula() + "\t\t" + aluno.getNome() + "\t" + aluno.getCurso() + "\t\t" + aluno.getSemestreAtual() + "\t\t" + aluno.getIRA());
		}
	}
	
	public static void gerarHTML() {
		System.out.println("<html>");
			System.out.println("<head>");
				System.out.println("<meta charset='UTF-8'>");
				System.out.println("</meta>");
			System.out.println("</head>");
			
			System.out.println("<body>");
				System.out.println("<h1>Lista de alunos cadastrados</h1>");
				System.out.println("<table>");
					System.out.println("<tr>");
						System.out.println("<th>Matricula</th>");
						System.out.println("<th>Nome</th>");
						System.out.println("<th>Curso</th>");
						System.out.println("<th>Semestre Atual</th>");
						System.out.println("<th>Indice de rendimento academico</th>");
					System.out.println("</tr>");
					for(Aluno aluno : Universidade.alunos) {
						System.out.println("<tr>");
							System.out.println("<td> " + aluno.getMatricula() + "</td>");
							System.out.println("<td> " + aluno.getNome() + "</td>");
							System.out.println("<td> " + aluno.getCurso() + "</td>");
							System.out.println("<td>  " + aluno.getSemestreAtual() + "</td>");
							if(aluno.getIRA() < MEDIA_IRA) {
								System.out.println("<td style='color : red;'>   " + aluno.getIRA() + "</td>");
							}
							else if(aluno.getIRA() >= MEDIA_IRA) {
								System.out.println("<td style='color : blue;'>   " + aluno.getIRA() + "</td>");
							}
						System.out.println("</tr>");
					}
				System.out.println("</table>");
			System.out.println("</body>");
		System.out.println("</html>");
	}
}
