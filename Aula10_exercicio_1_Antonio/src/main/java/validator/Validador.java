package validator;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Validador
{

    public static List<String> valida(HttpServletRequest request)
    {
        List<String> erros = new ArrayList<String>();
        if(request.getParameter("nome").isEmpty()) {
            erros.add("Nome não pode ser vazio!!");
        }
        if(request.getParameter("sobrenome").isEmpty()) {
            erros.add("Sobrenome não pode ser vazio!!");
        }
        if(request.getParameter("nome").toLowerCase().contains("flamengo")) {
            erros.add("Nome inválido!!");
        }
        return erros;
        
    }
    
}
