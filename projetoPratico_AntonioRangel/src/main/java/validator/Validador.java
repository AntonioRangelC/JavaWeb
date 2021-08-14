package validator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controller.RegrasDeNegocio;
import model.Pessoa;

public class Validador {
	private final static int  MIN_CHAR = 3;
	private final static int MIN_CHAR_EMAIL = 6;
	private final static double  MIN_ALTURA = 0.5;
	public static List<String> erros = new ArrayList<String>();
	public static void valida(Pessoa pessoa, String dataNascimento){
		erros.clear();
        
		
		validaNome(pessoa.getNomeCompleto());
        
        validaAltura(pessoa.getAltura());
        
        validaData(dataNascimento, pessoa);
        
        validaEmails(pessoa);
        
        validaGenero(pessoa.getGenero());
        
    }
	
	public static List<String> getErros() {
		return erros;
	}
	
	public static void setErros(String erro) {
		Validador.erros.add(erro);
	}
	
	public static void validaEmails(Pessoa pessoa) {
		if(pessoa.getEmailPrimario().isEmpty()) {
			setErros("Email nao pode ser vazio");
		}
		else {
			erros.clear();
		}
	}
	
	public static void validaIdPessoa(String idPessoa) {
		if(idPessoa.isEmpty()) {
			setErros("Id nao pode ser vazio");
		}
		else {
			String regex = "[0-9]+";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(idPessoa);
			if(!m.matches()) {
				setErros("O id so pode conter numeros");
			}
			else {
				erros.clear();
			}
		}
	}
	
	public static void validaEmail(String email) {
		if(email.isEmpty()) {
			setErros("Email nao pode ser vazio");
		}
		else {
			if(email.length() < MIN_CHAR_EMAIL ) {
				setErros("Email com tamanho invalido");
			}
			else {
				erros.clear();
			}
		}
		
	}
	public static void validaGenero(String genero) {
		if(genero == null) {
			setErros("Selecione um genero, o campo e obrigatorio");
		}
		else {
			erros.clear();
		}
	}
	
	public static void validaAltura(Double altura) {
		if(altura <= MIN_ALTURA) {
			setErros("Altura deve ser maior que 50 centimetros");
		}
		else {
			Validador.erros.clear();
		}
	}
	
	public static void validaAltura(String altura_str) {
		if(altura_str.isEmpty()) {
			setErros("Altura nao pode ser vazia");
		}
		else {
			Double altura = Double.parseDouble(altura_str);
			if(altura <= MIN_ALTURA) {
				setErros("Altura deve ser maior que 50 centimetros");
			}
			else {
				Validador.erros.clear();
			}
		}
		
	}
	
	public static void verificarNomeVazio(String nome) {
		if(nome.isEmpty()) {
            setErros("Nome nao pode ser vazio!!");
        }
		else {
			erros.clear();
		}
	}
	
	public static void validaNome(String nome) {
		
		if(nome.isEmpty()) {
            erros.add("Nome nao pode ser vazio!!");
        }
		else {
			
			if(nome.length() <= MIN_CHAR) {
				erros.add("Nome deve conter mais de 3 caracteres");
			}
			else {
				Validador.erros.clear();
			}
			
		}
        
	}
	
	public static void validaData(String data, Pessoa pessoa) {
		if(data.isEmpty()) {
        	erros.add("Data de nascimento nao pode ser vazia");
        }
		else {
			if(RegrasDeNegocio.estaNoFormatoDMY(data)) {
				data = RegrasDeNegocio.mudarFormatoData(data);
			}
			pessoa.setDataNascimento(java.sql.Date.valueOf(data));
			Validador.erros.clear();
		}
		
		
	}
	
	public static void validaData(String data) {
		if(data.isEmpty()) {
        	erros.add("Data de nascimento nao pode ser vazia");
        }
		else {
			Validador.erros.clear();
		}
		
	}
	
	
		
	
}
