package data;

import beans.Item;

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

/**
 * Session Bean implementation class ItemDataService
 */
@Stateless
@Local(DataAccessInterface.class)
@LocalBean
public class ItemDataService implements DataAccessInterface<Item> {

    /**
     * Default constructor. 
     */
    public ItemDataService() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see DataAccessInterface#delete(T)
     */
    public boolean delete(Item t) {
        // TODO Auto-generated method stub
			return false;
    }

	/**
     * @see DataAccessInterface#findAll()
     */
    public List<Item> findAll() {
    	Connection conn = null;
    	List<Item> items = new ArrayList<Item>();
		String url = "jdbc:mysql://localhost:3306/cst_235";
		String username = "root";
		String password = "root";
		String sql = "SELECT * FROM item";
		try 
		{
			conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				items.add(new Item(rs.getInt("Unit_ID"), rs.getString("NAME"), rs.getString("DESCRIPTION"), rs.getString("DATE_ADDED"), rs.getString("DATE_REMOVED")));
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
    	return items;
    }

	/**
     * @see DataAccessInterface#create(T)
     */
    public boolean create(Item t) {
        // TODO Auto-generated method stub
			return false;
    }

	/**
     * @see DataAccessInterface#update(T)
     */
    public boolean update(Item t) {
        // TODO Auto-generated method stub
			return false;
    }

	/**
     * @see DataAccessInterface#findById(int)
     */
    public Item findById(int id) {
        // TODO Auto-generated method stub
			return null;
    }

	@Override
	public Item findBy(Item t) {
		// TODO Auto-generated method stub
		return null;
	}

}
