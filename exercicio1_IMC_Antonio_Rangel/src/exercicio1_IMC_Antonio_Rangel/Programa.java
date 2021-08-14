package exercicio1_IMC_Antonio_Rangel;

import java.io.InputStream;
import java.util.Scanner;

public class Programa {
	

	public static void main(String[] args) {
		final double MINIMO = 0;
		double peso = Leitor.lerDouble(MINIMO, "Insira o valor da sua altura em metros: ");
		double altura = Leitor.lerDouble(MINIMO, "Insira o valor da seu peso em kilogramas: ");
		Pessoa pessoa = new Pessoa();
		pessoa.setAltura(altura);
		pessoa.setPeso(peso);
		double resultado = Matematica.calculaIMC(pessoa.getPeso(), pessoa.getAltura());
		Visualizador.mostraResultado(resultado);
	}
	

}

class Pessoa{
	double peso;
	double altura;
	
	public double getPeso() {
		return this.peso;
	}
	
	public double getAltura() {
		return this.altura;
	}
	
	public void setAltura(double novaAltura) {
		this.altura = novaAltura;
	}
	
	public void setPeso(double novoPeso) {
		this.peso = novoPeso;
	}
	
}

class Visualizador{
	public static void mostraResultado(double resultado) {
		System.out.println("O IMC é: " + resultado + " kg/m²");
	}
}

class Matematica{
	public static double calculaIMC(double peso, double altura) {
		double resultado = peso / (altura * altura);
		return resultado;
	}
	
}

class Leitor{

    public static double lerDouble(double min, String mensagem) {

        double valor;
        

        do{
            valor = lerDouble(mensagem);

        } while (valor <= min);

        return valor;

    }

	public static double lerDouble(String mensagem) {

        System.out.println(mensagem);
        Scanner scanner = new Scanner(System.in);
        double valor = scanner.nextDouble();
        return valor;

    }
	
	

    
}
