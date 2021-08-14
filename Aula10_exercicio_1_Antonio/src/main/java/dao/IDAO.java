
package dao;

import java.sql.Connection;

public interface IDAO {
	void setConnection( Connection con );
	Connection getConnection ();
}
