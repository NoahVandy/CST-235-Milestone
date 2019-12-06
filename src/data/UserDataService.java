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
import business.DatabaseException;

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
		}
		catch(SQLException e)
		{
			throw new DatabaseException(e);
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
					throw new DatabaseException(e);
				}
			}
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
			throw new DatabaseException(e);
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
					throw new DatabaseException(e);
				}
			}
		}
		return true;
    }

	/**
     * @see DataAccessInterface#update(T)
     */
    public boolean updateRest(User originalUser, User updatedUser) {
    	Connection conn = null;
    	String url = "jdbc:mysql://localhost:3306/cst_235";
		String username = "root";
		String password = "root";
		String sql = String.format("UPDATE `user` SET `USER_CODE` = '%d', `USERNAME` = '%s', `PASSWORD` = '%s', `EMAIL` = '%s', `PHONE_NUMBER` = '%d' WHERE `USER_CODE` = '%d';", updatedUser.getUserCode(), updatedUser.getUsername(), updatedUser.getPassword(), updatedUser.getEmail(), updatedUser.getPhoneNumber(), originalUser.getUserCode());
		try 
		{
			conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		}
		catch(SQLException e)
		{
			throw new DatabaseException(e);
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
					throw new DatabaseException(e);
				}
			}
		}
    	return true;
    }

	/**
     * @see DataAccessInterface#findById(int)
     */
    public User findById(int id) {
    	Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/cst_235";
		String username = "root";
		String password = "root";
		User user = null;
		String sql = String.format("SELECT * FROM `user` WHERE '%d' = `USER_CODE`;", id);
		try 
		{
			conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				user = new User(rs.getInt("USER_CODE"), rs.getString("USERNAME"), rs.getString("PASSWORD"), rs.getString("EMAIL"), rs.getInt("PHONE_NUMBER"));
			}
		}
		catch(SQLException e)
		{
			throw new DatabaseException(e);
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
					throw new DatabaseException(e);
				}
			}
		}
    	return user;
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
			if(rs.next()) {
				loginUser = new User(rs.getInt("USER_CODE"), rs.getString("USERNAME"), rs.getString("PASSWORD"), rs.getString("EMAIL"), rs.getInt("PHONE_NUMBER"));
			}
		}
		catch(SQLException e)
		{
			throw new DatabaseException(e);
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
					throw new DatabaseException(e);
				}
			}
		}
    	return loginUser;
	}

	@Override
	public boolean update(User t) {
		// TODO Auto-generated method stub
		return false;
	}

}
