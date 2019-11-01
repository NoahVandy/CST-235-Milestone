package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import beans.User;

/**
 * Session Bean implementation class UserDataService
 */
@Stateless
@Local(DataAccessInterface.class)
@LocalBean
public class UserDataService implements DataAccessInterface<User> {

    /**
     * Default constructor. 
     */
    public UserDataService() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see DataAccessInterface#delete(T)
     */
    public boolean delete(User t) {
        // TODO Auto-generated method stub
			return false;
    }

	/**
     * @see DataAccessInterface#findAll()
     */
    public List<User> findAll() {
    	Connection conn = null;
    	List<User> users = new ArrayList<User>();
		String url = "jdbc:mysql://localhost:3306/cst_235";
		String username = "root";
		String password = "root";
		String sql = "SELECT * FROM user";
		try 
		{
			conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				users.add(new User(rs.getInt("USER_CODE"), rs.getString("USERNAME"), rs.getString("PASSWORD"), rs.getString("EMAIL"), rs.getInt("PHONE_NUMBER")));
			}
			rs.close();
			System.out.println("Connected to the database");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(conn != null)
			{
				try
				{
					conn.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		for (User u : users) 
		{
			System.out.println(u.toString());
		}
    	return users;
    }

	/**
     * @see DataAccessInterface#create(T)
     */
    public boolean create(User user) {
    	Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/cst_235";
		String username = "root";
		String password = "root";
		String sql = String.format("INSERT INTO user (USER_CODE, USERNAME, PASSWORD, EMAIL, PHONE_NUMBER) VALUES (%d, '%s', '%s', '%s', '%s')", user.getUserCode(), user.getUsername(), user.getPassword(), user.getEmail(), user.getPhoneNumber());
		try 
		{
			conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
		}  
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(conn != null)
			{
				try
				{
					conn.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		System.out.println(sql);
		return true;
    }

	/**
     * @see DataAccessInterface#update(T)
     */
    public boolean update(User t) {
        // TODO Auto-generated method stub
			return false;
    }

	/**
     * @see DataAccessInterface#findById(int)
     */
    public User findById(int id) {
        // TODO Auto-generated method stub
			return null;
    }

	@Override
	public User findBy(User t) {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/cst_235";
		String username = "root";
		String password = "root";
		User loginUser = null;
		String sql = String.format("SELECT * FROM user WHERE '%s' = USERNAME AND '%s' = PASSWORD", t.getUsername(), t.getPassword());
		try 
		{
			conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("Connected to the database");
			if(rs.next()) {
				loginUser = new User(rs.getInt("USER_CODE"), rs.getString("USERNAME"), rs.getString("PASSWORD"), rs.getString("EMAIL"), rs.getInt("PHONE_NUMBER"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(conn != null)
			{
				try
				{
					conn.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
    	return loginUser;
	}

}
