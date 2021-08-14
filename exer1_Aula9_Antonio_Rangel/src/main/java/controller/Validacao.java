package controller;

public class Validacao {
	private final static int MIN_CARACTERES = 3;
	private final static int MIN_INTEIRO = 0;
	private final static double MIN_DOUBLE = 0.0;
	
	public static String validarString(String caracteres) {
		while(caracteres.length() < MIN_CARACTERES) {
			System.out.println("O nome precisa ter pelo menos 3 caracteres");
			caracteres = Leitura.lerString("o nome do aluno");
		}
		return caracteres;

	}
	
	public static int validarInt(int inteiro) {
		while(inteiro <= MIN_INTEIRO) {
			System.out.println("O semestre precisa ser maior que 0");
			inteiro = Leitura.lerInt("semestre atual do aluno");
		}
		return inteiro;
	}
	
	public static double validarDouble(double numero) {
		while(numero < MIN_DOUBLE) {
			System.out.println("O IRA nao pode ser menor que 0");
			numero = Leitura.lerDouble("IRA do aluno");
		}
		return numero;
	}
}
