package data;
import beans.Unit;

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
 * Session Bean implementation class UnitDataService
 */
@Stateless
@Local(DataAccessInterface.class)
@LocalBean
public class UnitDataService implements DataAccessInterface <Unit> {

    /**
     * Default constructor. 
     */
    public UnitDataService() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see DataAccessInterface#delete(T)
     */
    public boolean delete(Unit t) {
        // TODO Auto-generated method stub
			return false;
    }

	/**
     * @see DataAccessInterface#findAll()
     */
    public List<Unit> findAll() {
    	Connection conn = null;
    	List<Unit> units = new ArrayList<Unit>();
		String url = "jdbc:mysql://localhost:3306/cst_235";
		String username = "root";
		String password = "root";
		String sql = "SELECT * FROM unit";
		try 
		{
			conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				units.add(new Unit(rs.getInt("UNIT_NUMBER"), rs.getInt("USER_CODE")));
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
		for (Unit u : units) 
		{
			System.out.println(u.toString());
		}
    	return units;
    }

	/**
     * @see DataAccessInterface#create(T)
     */
    public boolean create(Unit t) {
    	Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/cst_235";
		String username = "root";
		String password = "root";
		String sql = String.format("INSERT INTO unit (UNIT_NUMBER, USER_CODE) VALUES (%d, %d)", t.getUnitNumber(), t.getUnitCode());
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
    public boolean update(Unit t) {
        // TODO Auto-generated method stub
			return false;
    }

	/**
     * @see DataAccessInterface#findById(int)
     */
    public Unit findById(int unitId) {
    	Connection conn = null;
    	Unit foundUnit = new Unit();
    	String url = "jdbc:mysql://localhost:3306/cst_235";
		String username = "root";
		String password = "root";
		String sql = String.format("SELECT * FROM unit WHERE `ID` = '%d' LIMIT 1", unitId);
		try 
		{
			conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				foundUnit = new Unit(rs.getInt("UNIT_NUMBER"), rs.getInt("USER_CODE"));
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
		System.out.println(foundUnit.toString());
    	return foundUnit;
    }

	@Override
	public Unit findBy(Unit t) {
		// TODO Auto-generated method stub
		return null;
	}

}
