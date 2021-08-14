package dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DAOBase implements IDAO {
	protected Connection con;

	@Override
	public void setConnection(Connection con) {
		this.con = con;
	}

	@Override
	public Connection getConnection() {
		return con;
	}
	
	@Override
	public void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.print("Falha ao fechar a conexão.\n" + e.getMessage());
			}
		}
	}

}