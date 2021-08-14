package dao;

public class DAOException extends Throwable{
	private static final long serialVersionUID = 1L;

	public DAOException(Throwable t)
    {
        super(t);
    }
}
