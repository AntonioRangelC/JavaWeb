package model;

public class Usuario {
	
	private int id;
	private String nome;
	private String sobrenome;
	
	public Usuario (String nome, String sobrenome) {
		setNome(nome);
		setSobrenome(sobrenome);
	}
	public Usuario()
    {
        // TODO Auto-generated constructor stub
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
