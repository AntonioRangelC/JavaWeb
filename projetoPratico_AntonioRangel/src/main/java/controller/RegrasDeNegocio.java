package controller;

import model.Pessoa;

public class RegrasDeNegocio {
	
	public static String formatarNome(String nome) {
		
		
		nome = nome.trim();
		nome = nome.toLowerCase();
		String primLetra = nome.substring(0,1);
		String restoStr = nome.substring(1);
		primLetra = primLetra.toUpperCase();
		nome = primLetra + restoStr;
		return nome;
	}
	public String  mudarFormatoDataParaDMY(java.sql.Date data) {
		//2000-02-23
		String novoFormato = data.toString();
		String ano = novoFormato.substring(0, 4);
		String mes = novoFormato.substring(5, 7);
		String dia = novoFormato.substring(8);
		novoFormato = dia + "/" + mes + "/" + ano;
		return novoFormato;
	}
	
	public static boolean estaNoFormatoDMY(String data) {
		
		int tamanho = data.length();
		char[] stringAuxiliar = new char[tamanho];
		stringAuxiliar = data.toCharArray();
		if((stringAuxiliar[2] == '/' || stringAuxiliar[2] == '-') && (stringAuxiliar[5] == '/' || stringAuxiliar[5] == '-') ) {
			return true;
		}
		else {
			return false;
		}
	}
	//este metodo muda o formato da data para YMD separado por '-'
	public static String mudarFormatoData(String data) {
		
		String dia = data.substring(0, 2);
		String mes = data.substring(3, 5);
		String ano = data.substring(6);
		
		String novoFormato = ano + "-" + mes + "-" + dia;
		return novoFormato;
		
	}
}

