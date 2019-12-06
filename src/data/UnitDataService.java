package data;
import beans.Unit;
import business.DatabaseException;

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
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/cst_235";
        String username = "root";
        String password = "root";
        String sql = String.format("DELETE FROM unit WHERE UNIT_NUMBER = '%d' AND USER_CODE = '%d'", t.getUnitNumber(), t.getUnitCode());
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
				units.add(new Unit(rs.getInt("ID"), rs.getInt("UNIT_NUMBER"), rs.getInt("USER_CODE")));
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
    public boolean update(Unit unit) {
    	Connection conn = null;
    	String url = "jdbc:mysql://localhost:3306/cst_235";
		String username = "root";
		String password = "root";
		String sql = String.format("UPDATE `unit` SET `UNIT_NUMBER` = '%d' WHERE `unit`.`ID` = '%d';", unit.getUnitNumber(), unit.getUnitId());
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
				foundUnit = new Unit(rs.getInt("ID"), rs.getInt("UNIT_NUMBER"), rs.getInt("USER_CODE"));
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
    	return foundUnit;
    }

	@Override
	public Unit findBy(Unit t) {
		Connection conn = null;
    	Unit foundUnit = new Unit();
    	String url = "jdbc:mysql://localhost:3306/cst_235";
		String username = "root";
		String password = "root";
		String sql = String.format("SELECT * FROM `unit` WHERE `UNIT_NUMBER` = '%d'", t.getUnitNumber());
		try 
		{
			conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				foundUnit = new Unit(rs.getInt("ID"), rs.getInt("UNIT_NUMBER"), rs.getInt("USER_CODE"));
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
    	return foundUnit;
	}

	@Override
	public boolean updateRest(Unit t, Unit t1) {
		// TODO Auto-generated method stub
		return false;
	}


}
