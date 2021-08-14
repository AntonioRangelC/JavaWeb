
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import util.PropertiesFile;
//import javax.sql.DataSource;

public class DAOFactory {// FABRICA DE DAOS


    private static DAOFactory daoFactory = null;

    private DAOFactory() {}

    public static DAOFactory getInstance() {
        if( daoFactory == null ) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public IDAO getDAO( String daoClassName) throws DAOException //"br.com.mainclass.sistema.dao.UsuarioDAO"
            //throws	ClassNotFoundException,//se nao conseguir achar a classe.
            //IllegalAccessException,//se nao conseguir acessar um m�todo da classe.
            //SQLException,
            //InstantiationException //se nao conseguir instanciar um objeto da classe.
    {

        //Inst�ncia din�mica de uma classe.
        Class<?> daoClass;
            try
            {
                daoClass = Class.forName( daoClassName );
            
            IDAO result = (IDAO) daoClass.newInstance(); // new UsuarioDAO();
            // IDAO result = new UsuarioDAO();
            result.setConnection( getConnection() );
            return result;
            } catch (ClassNotFoundException | 
                    InstantiationException | 
                    IllegalAccessException e)
            {

                e.printStackTrace();
                throw new DAOException(e);
            }
      
        
    }

    private Connection getConnection() throws DAOException {
        PropertiesFile pf = new PropertiesFile();
        pf.load("conexoes.properties");
        try
        {
            Class.forName(pf.getValue("DRIVER_CLASS"));
            String url  = "jdbc:mysql://"+pf.getValue("SERVER_DATABASE")+":"+pf.getValue("PORT_DATABASE")+"/"+pf.getValue("NAME_DATABASE");
            String user = pf.getValue("USER");
            String pass = pf.getValue("PASS");
            Connection con=DriverManager.getConnection(url,user,pass); 
            return con;
        } catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
            throw new DAOException(e);
           
        }  
       
    }
}
