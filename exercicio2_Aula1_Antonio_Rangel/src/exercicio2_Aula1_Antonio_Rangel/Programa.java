package exercicio2_Aula1_Antonio_Rangel;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Programa {

	public static void main(String[] args) {
		int escolha;
		
		final double MINIMO_NUM = 0;
		final int MINIMO_CAR = 0;
		do {
			System.out.println("Escolha uma opção:\n");
			System.out.println("1. Cadastrar nova pessoa\n");
			System.out.println("2. Listar pessoas cadastradas\n");
			System.out.println("3. Sair");
			escolha = Leitor.lerInt();
			if(escolha == 1) {
				
				String nome = Leitor.lerString(MINIMO_CAR, "Insira o nome: ");
				double peso = Leitor.lerDouble(MINIMO_NUM, "Insira o valor da altura em metros: ");
				double altura = Leitor.lerDouble(MINIMO_NUM, "Insira o valor do peso em kilogramas: ");
				Pessoa pessoa = new Pessoa();
				pessoa.setAltura(altura);
				pessoa.setPeso(peso);
				pessoa.setNome(nome);
				double IMC = Matematica.calculaIMC(pessoa.getPeso(), pessoa.getAltura());
				pessoa.setIMC(IMC);
				Prefeitura.adicionarPessoa(pessoa);
			}
			else if(escolha == 2) {
				Prefeitura.mostrarPessoas();
			}
		} while(escolha != 3);
		
	}

}

class Prefeitura{
	static List<Pessoa> listaDePessoas = new ArrayList<Pessoa>();
	public static void adicionarPessoa(Pessoa pessoa) {
		listaDePessoas.add(pessoa);
	}
	public static void mostrarPessoas() {
		int aux;
		double maiorIMC = Matematica.acharMaiorIMC(listaDePessoas);
		double menorIMC = Matematica.acharMenorIMC(listaDePessoas);
		double mediaIMC = Matematica.calcularMediaIMC(listaDePessoas);
		System.out.println("Maior IMC: " + maiorIMC);
		System.out.println("Menor IMC: " + menorIMC);
		System.out.println("Média de IMC: " + mediaIMC);
		for(aux = 0; aux < listaDePessoas.size(); aux++) {
			System.out.println((aux+1) + ". " + listaDePessoas.get(aux).nome);
			System.out.println("    Peso: " + listaDePessoas.get(aux).peso);
			System.out.println("    Altura: " + listaDePessoas.get(aux).altura);
			System.out.println("    IMC: " + listaDePessoas.get(aux).IMC);
		}
	}
}

class Pessoa{
	String nome;
	double peso;
	double altura;
	double IMC;
	public double getPeso() {
		return this.peso;
	}
	
	public double getAltura() {
		return this.altura;
	}
	
	public double getIMC() {
		return this.IMC;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}
	
	public void setAltura(double novaAltura) {
		this.altura = novaAltura;
	}
	
	public void setPeso(double novoPeso) {
		this.peso = novoPeso;
	}
	
	public void setIMC(double novoIMC) {
		this.IMC = novoIMC;
	}
	
}

class Leitor{
	static Scanner scanner = new Scanner(System.in);
	public static int lerInt() {
		int valor = scanner.nextInt();
		return valor;
	}
	
	public static String lerString(int min, String mensagem) {
		
		String string;
		do {
			string = lerString(mensagem);
		} while(string.length() == min);
		
		return string;
	}
	
	public static String lerString(String mensagem) {
		System.out.println(mensagem);
		String string = scanner.nextLine();
		return string;
	}

	public static double lerDouble(double min, String mensagem) {

        double valor;
        

        do{
            valor = lerDouble(mensagem);

        } while (valor <= min);

        return valor;

    }

	public static double lerDouble(String mensagem) {

        System.out.println(mensagem);
        double valor = scanner.nextDouble();
        return valor;

    }

    

}

class Matematica{
	public static double calculaIMC(double peso, double altura) {
		double resultado = peso / (altura * altura);
		return resultado;
	}
	
	public static double acharMaiorIMC(List<Pessoa> listaPessoas) {
		List<Double> listaValoresIMC = preencherListaIMC(listaPessoas);
		double maiorIMC = Collections.max(listaValoresIMC);
		return maiorIMC;
	}
	
	public static double acharMenorIMC(List<Pessoa> listaPessoas) {
		List<Double> listaValoresIMC = preencherListaIMC(listaPessoas);
		double menorIMC = Collections.min(listaValoresIMC);
		return menorIMC;
	}
	
	public static List<Double> preencherListaIMC(List<Pessoa> listaPessoas) {
		List<Double> listaValoresIMC = new ArrayList<Double>();
		int aux, tamanho = listaPessoas.size();
		for(aux = 0; aux < tamanho; aux++) {
			listaValoresIMC.add(listaPessoas.get(aux).IMC);
		}
		return listaValoresIMC;
	}
	
	public static double calcularMediaIMC(List<Pessoa> listaPessoas) {
		List<Double> listaValoresIMC = preencherListaIMC(listaPessoas);
		int aux, tamanho = listaPessoas.size();
		double soma = 0, media;
		for(aux = 0; aux < tamanho ; aux++) {
			soma += listaValoresIMC.get(aux);
		}
		media = soma / tamanho;
		return media;
	}
	
}

