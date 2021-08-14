package model;

public class Usuario {
	public String nome;
	public String sobrenome;
	public int id;
	public Usuario() {
		
	}
	public Usuario(String nome, String sobrenome, int id) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
}
