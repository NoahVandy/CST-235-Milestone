package business;

public class DatabaseException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2337769903979403513L;
	
	public DatabaseException(Throwable e)
	{
		super(e);
	}

}
