package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioDAO extends DAOBase
{
    static final String sqlCadastrarUsuario = "INSERT INTO cadastro.usuario VALUES(?,?,?)";
    static final String sqlListarTodos      = "SELECT * FROM cadastro.usuario";
    static final String sqlDeleteUm      = "DELETE FROM cadastro.usuario WHERE ID = ?";
    
    //colocando o construtor como default (sem modificador de acesso) somente dentro do pacote pode ser instanciado.
    UsuarioDAO() {
        
    }
    public void cadastrar(Usuario usuario) throws DAOException {
        
        try
        {
            PreparedStatement ps = getConnection().prepareStatement(sqlCadastrarUsuario);
            ps.setInt(1,usuario.getId());
            ps.setString(2,usuario.getNome());
            ps.setString(3,usuario.getSobrenome());
            ps.executeUpdate();
            ps.close();
            System.out.println("cadastrado");
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new DAOException(e);
        }
    }
    
    public List<Usuario> listar() throws DAOException {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try
        {
            PreparedStatement ps = getConnection().prepareStatement(sqlListarTodos);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                Usuario usuario = new Usuario();
                put(rs,usuario);
                usuario.setId(rs.getInt("ID"));
                usuario.setNome(rs.getString("NOME"));
                usuario.setSobrenome(rs.getString("SOBRENOME"));
                usuarios.add(usuario);
                System.out.println(usuario.getId() + " " + usuario.getNome() + " " + usuario.getSobrenome());
            }
            ps.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new DAOException(e);
        }
        return usuarios;
    }
    private void put(ResultSet rs, Usuario usuario) throws SQLException
    {
        usuario.setId(rs.getInt("ID"));
        usuario.setNome(rs.getString("NOME"));
        usuario.setSobrenome(rs.getString("SOBRENOME"));
    }
    public void excluir(Integer idExclusao) throws DAOException
    {
        try
        {
            PreparedStatement ps = getConnection().prepareStatement(sqlDeleteUm);
            ps.setInt(1,idExclusao);
            ps.executeUpdate();
            ps.close();
            System.out.println(idExclusao+" excluido com sucesso");
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new DAOException(e);
        }
        
    }
    
}
