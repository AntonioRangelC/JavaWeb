package validator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Validador
{

    @SuppressWarnings("unchecked")
	public static List<String> validaCamposCadastro(HttpSession session)
    {
        List<String> erros = new ArrayList<String>();
        if(((String) session.getAttribute("nome")).isEmpty()) {
            erros.add("Nome nao pode ser vazio!!");
        }
        if(((String) session.getAttribute("sobrenome")).isEmpty()) {
            erros.add("Sobrenome nao pode ser vazio!!");
        }
       
        return erros;
        
    }
    
    public static List<String> validaCamposLogin(HttpServletRequest request){
    	List<String> erros = new ArrayList<String>();
    	if(request.getParameter("usuario").isEmpty()) {
        	erros.add("Usuario nao pode ser vazio");
        }
        if(request.getParameter("senha").isEmpty()) {
        	erros.add("Senha nao pode ser vazia");
        }
        return erros;
    }
    
    public static void autenticar(HttpSession session, HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {
    	List<String> erros = new ArrayList<String>();
    	String usuario =  request.getParameter("usuario");
		String senha =  request.getParameter("senha");
    	if(usuario.equals("antonio") && senha.equals("123")) {
    		session.setAttribute("usuario", usuario);
    		session.setAttribute("erros", null);
            response.sendRedirect("inicio.jsp");
		}
		else {
			erros = (List<String>) session.getAttribute("erros");
			erros.add("Usuario ou senha incorretos");
			session.setAttribute("erros", erros);
			response.sendRedirect("login.jsp");
		}
    }
    
}
