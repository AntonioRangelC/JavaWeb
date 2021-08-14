package controller;

import java.util.Scanner;

public class Leitura {
	public static String lerString(String mensagem) {
		System.out.println("Digite o " + mensagem);
		return new Scanner(System.in).nextLine().trim();
	}
		
	public static char lerChar(String mensagem) {
		System.out.print("Digite uma opcao " + mensagem);
		return new Scanner(System.in).next().trim().toUpperCase().charAt(0);
	}
	
	public static int lerInt(String mensagem) {
		System.out.println("Digite o " + mensagem);
		return new Scanner(System.in).nextInt();
	}
	
	public static double lerDouble(String mensagem) {
		System.out.println("Digite o " + mensagem);
		return new Scanner(System.in).nextDouble();
	}
}
