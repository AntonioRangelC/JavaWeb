package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Usuario;
import validator.Validador;

public class UsuarioDAO extends DAOBase{
	UsuarioDAO() {
		        
	}
	public void cadastrarUsuario(Usuario usuario) throws DAOException{
		String sql = "INSERT INTO cadastro.usuario VALUES(?,?,?)";
		
		 
		Connection con = getConnection();
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, usuario.getId());
			preparador.setString(2, usuario.getNome());
			preparador.setString(3, usuario.getSobrenome());
			preparador.executeUpdate();
			preparador.close();
			System.out.println("Gravado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Sem inserção!\n" + e.getMessage());
			Validador.setErros("Nao foi possivel obter conexao");
			e.printStackTrace();
			throw new DAOException(e);
		} finally {
			closeConnection(con);
		}
		
	}
	
	public ArrayList<Usuario> listaUsuarios() throws DAOException{
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario usuario = new Usuario();
		String sqlConsulta = "SELECT * FROM cadastro.usuario";
		
		Connection con =  getConnection();
		
		try {
			PreparedStatement preparador = con.prepareStatement(sqlConsulta);
			ResultSet listaUsuario = preparador.executeQuery();
			while (listaUsuario.next()) {
				usuario.setId(Integer.parseInt(listaUsuario.getString("id")));
				usuario.setNome(listaUsuario.getString("nome"));
				usuario.setSobrenome(listaUsuario.getString("sobrenome"));
				usuarios.add(usuario);
				
			}
			preparador.close();
			listaUsuario.close();
		} catch (SQLException e) {
			Validador.setErros("Nao foi possivel obter conexao");
			e.printStackTrace();
			throw new DAOException(e);
		} finally {
			closeConnection(con);
		}
		return usuarios;
	}
}
