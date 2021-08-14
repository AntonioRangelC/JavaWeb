package model;

import java.util.Date;

public class Pessoa {
	private Integer idPessoa;
	private String nomeCompleto;
	private double altura;
	private String genero;
	private String emailPrimario;
	private String emailSecundario;
	private java.sql.Date dataNascimento;
	
	public Pessoa () {
		
	}
	
	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}


	public String getEmailPrimario() {
		return emailPrimario;
	}

	public void setEmailPrimario(String emailPrimario) {
		this.emailPrimario = emailPrimario;
	}

	public String getEmailSecundario() {
		return emailSecundario;
	}

	public void setEmailSecundario(String emailSecundario) {
		this.emailSecundario = emailSecundario;
	}

	public java.sql.Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(java.sql.Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Integer getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNome(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
}
