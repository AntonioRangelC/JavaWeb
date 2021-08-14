package dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import validator.Validador;

import model.Pessoa;



public class UsuarioDAO extends DAOBase{
	UsuarioDAO() {
        
	}
	
	public void cadastrarPessoa(Pessoa pessoa) throws DAOException{
		String sqlInserirPessoa = "INSERT INTO PROJETOPRATICO.PESSOA (nome, altura, genero, dataNascimento) VALUES (?,?,?,?)";
		String sqlRecuperarId = "SELECT idPessoa FROM PROJETOPRATICO.PESSOA WHERE nome = (?)";
		String sqlInserirEmails = "INSERT INTO PROJETOPRATICO.EMAILS (idPessoa, emailPrim, emailSec) VALUES (?,?,?)";
		
		Connection con = getConnection();
		try {
			PreparedStatement preparador;
			
			preparador = con.prepareStatement(sqlInserirPessoa);
			inserirTabelaPessoa(con, preparador, pessoa);
			
			preparador = con.prepareStatement(sqlRecuperarId);
			int idPessoa = recuperarId(pessoa, con, preparador);
			
			System.out.println("id recuperado " + idPessoa);
			
			preparador = con.prepareStatement(sqlInserirEmails);
			inserirTabelaEmails(con, preparador, pessoa, idPessoa);
			
			
			preparador.close();
		}catch(SQLException e) {
			System.out.println("Sem inserção!\n" + e.getMessage());
			Validador.setErros("Nao foi possivel obter conexao");
			
			e.printStackTrace();
			throw new DAOException(e);
		} finally {
			closeConnection(con);
		}
	}
	
	
	
	public List<Pessoa> buscarPessoasPeloNome(String nome){
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		 
		String sql = "SELECT * FROM PROJETOPRATICO.PESSOA WHERE nome LIKE ? ORDER BY altura DESC";
		Connection con =  getConnection();
		try {
			 PreparedStatement preparador; 
			 preparador = con.prepareStatement(sql);
			 preparador.setString(1, "%"+nome+"%");
		     ResultSet resultado = preparador.executeQuery();
		     
	         while (resultado.next()){
	        	 Pessoa pessoa = new Pessoa();
	             pessoa.setIdPessoa(resultado.getInt("idPessoa"));
	             pessoa.setNome(resultado.getString("nome"));
	             pessoa.setAltura(resultado.getDouble("altura"));
	             pessoa.setGenero(resultado.getString("genero"));
	             pessoa.setDataNascimento(resultado.getDate("dataNascimento"));
	        
	             pessoas.add(pessoa);
	         }
	         resultado.close();
	         preparador.close();
		} catch(SQLException e) {
			Validador.setErros("Nao foi possivel recuperar os dados");
			e.printStackTrace();
		} finally {
			closeConnection(con);
				
		}
		
		return pessoas;	
		
	}
	
	public void alterarGenero(String genero, int idPessoa) throws DAOException{
		String sqlAlterarGenero = "UPDATE PROJETOPRATICO.PESSOA SET genero = ? WHERE idPessoa = ?";
		Connection con = getConnection();
		try {
			PreparedStatement preparador;
			preparador = con.prepareStatement(sqlAlterarGenero);
			preparador.setString(1,genero);
			preparador.setInt(2, idPessoa);
			preparador.execute();
			preparador.close();
		} catch(SQLException e) {
			Validador.setErros("Nao foi possivel obter conexao");
			e.printStackTrace();
			throw new DAOException(e);
		} finally {
			closeConnection(con);
		}
	}
	
	public void alterarDataNascimento(Date dataNascimento, int idPessoa) throws DAOException{
		String sqlAlterarDataNascimento = "UPDATE PROJETOPRATICO.PESSOA SET dataNascimento = ? WHERE idPessoa = ?";
		Connection con = getConnection();
		try {
			PreparedStatement preparador;
			preparador = con.prepareStatement(sqlAlterarDataNascimento);
			preparador.setDate(1, dataNascimento);
			preparador.setInt(2, idPessoa);
			preparador.execute();
			preparador.close();
		} catch(SQLException e) {
			Validador.setErros("Nao foi possivel obter conexao");
			e.printStackTrace();
			throw new DAOException(e);
		} finally {
			closeConnection(con);
		}
	}
	
	public void alterarAltura(Double altura, int idPessoa) throws DAOException {
		String sqlAlterarAltura = "UPDATE PROJETOPRATICO.PESSOA SET altura = ? WHERE idPessoa = ?";
		Connection con = getConnection();
		try {
			PreparedStatement preparador;
			preparador = con.prepareStatement(sqlAlterarAltura);
			preparador.setDouble(1, altura);
			preparador.setInt(2, idPessoa);
			preparador.execute();
			preparador.close();
		} catch(SQLException e) {
			Validador.setErros("Nao foi possivel obter conexao");
			e.printStackTrace();
			throw new DAOException(e);
		} finally {
			closeConnection(con);
		}
	}
	
	public void alterarNome(String nome, int idPessoa) throws DAOException {
		String sqlAlterarNome = "UPDATE PROJETOPRATICO.PESSOA SET nome = ? WHERE idPessoa = ?";
		Connection con = getConnection();
		try {
			PreparedStatement preparador;
			preparador = con.prepareStatement(sqlAlterarNome);
			preparador.setString(1, nome);
			preparador.setInt(2, idPessoa);
			preparador.execute();
			preparador.close();
		} catch(SQLException e) {
			Validador.setErros("Nao foi possivel obter conexao");
			e.printStackTrace();
			throw new DAOException(e);
		} finally {
			closeConnection(con);
		}
	}
	
	public void alterarEmailPrim(String emailPrim, int idPessoa) throws DAOException {
		String sqlAlterarEmailPrim = "UPDATE PROJETOPRATICO.EMAILS SET emailPrim = ? WHERE idPessoa = ?";
		Connection con = getConnection();
		try {
			PreparedStatement preparador;
			
			preparador = con.prepareStatement(sqlAlterarEmailPrim);
			preparador.setString(1, emailPrim);
			preparador.setInt(2, idPessoa);
			preparador.execute();
			preparador.close();
		} catch(SQLException e) {
			Validador.setErros("Nao foi possivel obter conexao");
			e.printStackTrace();
			throw new DAOException(e);
		} finally {
			 closeConnection(con);
		}
		
	}
	
	public void alterarEmailSec(String emailSec, int idPessoa) throws DAOException {
		String sqlAlterarEmailSec = "UPDATE PROJETOPRATICO.EMAILS SET emailSec = ? WHERE idPessoa = ?";
		Connection con = getConnection();
		try {
			PreparedStatement preparador;
			
			preparador = con.prepareStatement(sqlAlterarEmailSec);
			preparador.setString(1, emailSec);
			preparador.setInt(2, idPessoa);
			preparador.execute();
			preparador.close();
		} catch(SQLException e) {
			Validador.setErros("Nao foi possivel obter conexao");
			e.printStackTrace();
			throw new DAOException(e);
		} finally {
			 closeConnection(con);
		}
		
	}
	
	
	public void excluirPessoa(Integer idExclusao) throws DAOException{
		String sqlExcluirPessoa = "DELETE FROM PROJETOPRATICO.PESSOA WHERE idPessoa = ?";
		String sqlExcluirEmails = "DELETE FROM PROJETOPRATICO.EMAILS WHERE idPessoa = ?";
		Connection con = getConnection();
		  try {
	        
	            PreparedStatement ps = con.prepareStatement(sqlExcluirEmails);
	            ps.setInt(1,idExclusao);
	            ps.executeUpdate();
	            
	            ps = con.prepareStatement(sqlExcluirPessoa);
	            ps.setInt(1,idExclusao);
	            ps.executeUpdate();
	            ps.close();
	            System.out.println(idExclusao+" excluido com sucesso");
	        } catch (SQLException e){
	        	Validador.setErros("Nao foi possivel obter conexao");
	            e.printStackTrace();
	            throw new DAOException(e);
	        } finally {
	        	closeConnection(con);
	        }
	}
	
	public int recuperarId(Pessoa pessoa, Connection con, PreparedStatement preparador) throws SQLException {
		
		int id = 0;
		preparador.setString(1, pessoa.getNomeCompleto());
		ResultSet resultado = preparador.executeQuery();
		while(resultado.next()) {
			id = resultado.getInt("idPessoa");
		}
		
		return id;
	}
	
	public void inserirTabelaPessoa(Connection con, PreparedStatement preparador, Pessoa pessoa) throws SQLException  {
		
		preparador.setString(1, pessoa.getNomeCompleto());
		preparador.setDouble(2, pessoa.getAltura());
		preparador.setString(3, pessoa.getGenero());
		preparador.setDate(4, pessoa.getDataNascimento());
		preparador.execute();
	}
	
	public void inserirTabelaEmails(Connection con, PreparedStatement preparador, Pessoa pessoa, int idPessoa) throws SQLException {
		
		preparador.setInt(1, idPessoa);
		preparador.setString(2, pessoa.getEmailPrimario());
		preparador.setString(3, pessoa.getEmailSecundario());
		preparador.execute();
	}
	
	public List<Pessoa> listarPessoas() throws DAOException{
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		 
		String sql = "SELECT * FROM PESSOA ORDER BY nome ASC";
		Connection con =  getConnection();
		try {
			 PreparedStatement preparador; 
			 preparador = con.prepareStatement(sql);
		     ResultSet resultado = preparador.executeQuery();
		     
	         while (resultado.next()){
	        	 Pessoa pessoa = new Pessoa();
	             pessoa.setIdPessoa(resultado.getInt("idPessoa"));
	             pessoa.setNome(resultado.getString("nome"));
	             pessoa.setAltura(resultado.getDouble("altura"));
	             pessoa.setGenero(resultado.getString("genero"));
	             pessoa.setDataNascimento(resultado.getDate("dataNascimento"));
	        
	             pessoas.add(pessoa);
	         }
	         resultado.close();
	         preparador.close();
		} catch(SQLException e) {
			Validador.setErros("Nao foi possivel recuperar os dados");
			e.printStackTrace();
		} finally {
			closeConnection(con);
				
		}
		
		return pessoas;	
	}
	
	//esta funcao retorna uma lista com duas strings, a primeira posicao contem o email primario, e a segunda 
	// contem o email secundario
	public List<String> buscarEmailsPeloId(int idPessoa) throws DAOException{
		String sqlBuscar = "SELECT emailPrim, emailSec FROM PROJETOPRATICO.EMAILS WHERE idPessoa = ?";
		List<String> emails = new ArrayList<String>();
		Connection con =  getConnection();
		try {
			PreparedStatement ps;
			ps = con.prepareStatement(sqlBuscar);
			ps.setInt(1, idPessoa);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				emails.add(rs.getString("emailPrim"));
				emails.add(rs.getString("emailSec"));
			}
			
			ps.close();
		} catch(SQLException e) {
			Validador.setErros("Nao foi possivel recuperar os emails");
			e.printStackTrace();
		} finally {
			closeConnection(con);
		}
		return emails;
	}
	
	public Pessoa buscarPessoaPeloIdPessoa(int idPessoa) throws DAOException{
		String sqlBuscarPorId = "SELECT * FROM PROJETOPRATICO.PESSOA WHERE idPessoa = ?";
		Pessoa pessoa = new Pessoa();
		Connection con =  getConnection();
		
		
		try {
			PreparedStatement preparador;
			preparador = con.prepareStatement(sqlBuscarPorId);
			preparador.setInt(1, idPessoa);
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()) {
				pessoa.setNome(resultado.getString("nome"));
				pessoa.setAltura(resultado.getDouble("altura"));
	            pessoa.setGenero(resultado.getString("genero"));
	            pessoa.setDataNascimento(resultado.getDate("dataNascimento"));
			}
			
			preparador.close();
			resultado.close();
		} catch (SQLException e) {
			Validador.setErros("Nao foi possivel recuperar o cadastro");
			e.printStackTrace();
		} finally {
			closeConnection(con);
		}
		return pessoa;
	}
}
