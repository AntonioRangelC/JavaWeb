package validator;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Validador {
	private static List<String> erros = new ArrayList<String>();
	public static void valida(HttpServletRequest request){
    
        if(request.getParameter("nome").isEmpty()) {
            erros.add("Nome nao pode ser vazio!!");
        }
        if(request.getParameter("sobrenome").isEmpty()) {
            erros.add("Sobrenome nao pode ser vazio!!");
        }
        
    }
	public static List<String> getErros() {
		return erros;
	}
	public static void setErros(String erro) {
		Validador.erros.add(erro);
	}
	
}
