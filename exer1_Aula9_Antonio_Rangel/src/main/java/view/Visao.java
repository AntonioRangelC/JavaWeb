package view;

import controller.Leitura;
import controller.RegrasDeNegocio;

public class Visao {
	
	public static void saltaLinhas (int linhas) {
		for(int linha = 0; linha <= linhas; linha++) 
			System.out.println();
	}
	
	public static void menuPrincipal() {
		char opcao;
		
		do {
			opcao = Leitura.lerChar("\n 1 Inserir novo aluno\n 2 Listar alunos\n 3 Gerar HTML \n 0 Sair\n>> ");
			saltaLinhas(3);
			
			switch (opcao) {
			  case '0':
			  break;
			  case '1':
				RegrasDeNegocio.fazCadastro();
				break;
			  case '2': 
				RegrasDeNegocio.listarAlunos();
				break;
			  case '3':
				RegrasDeNegocio.gerarHTML();
				break;
			 default:
				 System.out.println("Opcao invalida, digite novamente");
			}
			saltaLinhas(2);
		} while (opcao != '0');
	}
	
}
