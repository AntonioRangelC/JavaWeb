package model;

public class Aluno {
	private String nome;
	private int matricula;
	private String curso;
	private int semestreAtual;
	private double IRA;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getMatricula() {
		return matricula;
	}
	
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public String getCurso() {
		return curso;
	}
	
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	public int getSemestreAtual() {
		return semestreAtual;
	}
	
	public void setSemestreAtual(int semestreAtual) {
		this.semestreAtual = semestreAtual;
	}
	
	public double getIRA() {
		return IRA;
	}
	
	public void setIRA(double iRA) {
		IRA = iRA;
	}
}
