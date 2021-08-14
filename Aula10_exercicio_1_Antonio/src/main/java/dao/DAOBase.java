package dao;




import java.sql.Connection;

public  class DAOBase implements IDAO {
	protected Connection con;// OU PACOTE OU HERANÇA

    @Override
    public void setConnection(Connection con)
    {
        this.con = con;
        
    }

    @Override
    public Connection getConnection()
    {
        return con;
    }
	
}