package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Destructible;
import entity.Diamond;
import entity.Entity;
import entity.Indestructible;
import entity.Map;
import entity.Player;
import entity.Portal;
import entity.monstre;
import entity.Rock;

/**
 * The DAOMap class is used to get the char wich composes the map and "translate" it into object like diamond or monster...
 *
 */
public class DAOMap {

	/**
	 * declaration of the connection
	 */
	private final Connection connection;
	
	/**
	 * The constructor the DAOMap class
	 * 
	 * @param connection
	 * @throws SQLException
	 */
	public DAOMap(final Connection connection) throws SQLException {
		this.connection = connection;
	}
	
	/**
	 * The getter of the connection attribute
	 * @return connection
	 * 			the connection
	 */
	protected Connection getConnection() {
		return this.connection;
	}
	
	/**
	 * 
	 * @param entity
	 * @return
	 */
	public boolean create(final Map entity) {
		return false;
	}
	
	/**
	 * 
	 * @param entity
	 * @return
	 */
	public boolean delete(final Map entity) {
		return false;
	}
	
	/**
	 * 
	 * @param entity
	 * @return
	 */
	public boolean update(final Map entity ) {
		return false;
	}

/**
 * This method will first connect to the database, prepare the querry with the wanted map, send the query, get the result of the query and then read it to create the entitys depending in the char in the result
 * ('T' for diamond..etc)
 * With the switch case, the method read the result of the query and instanciate a new object depending of the char in the result.
 * The myRs.next() instruct skip the reading to the next char.
 * 
 * @param nbMap
 * @return map
 * 			It return the map translated from the result of the sql query
 */
public Entity[][] getMapsql(int nbMap) {
	
	/**
	 * Instanciation of the map
	 */
	Map map = new Map();
	
	/**
	 * Declaration of the connection 
	 */
	Connection myConn = null;
	
	/**
	 * Declaration of the CallableState
	 */
	CallableStatement myStmt = null;
	
	/**
	 * Declaration of the result of the query
	 */
	ResultSet myRs = null;
	

	try {

		/**
		 * Store the connection information (password, login, url) into myConn
		 */
		myConn = getConnection();
		
		/**
		 * Preparation of the request depending of the map wich is choosen into myStmt
		 */
		myStmt = myConn.prepareCall("{call ProcBoulderdashMap" + nbMap + "()}");
		
		/**
		 * Storing the result of the sql query into myRs
		 */
		myRs = myStmt.executeQuery();
		
		if (myRs.first()) {
			
			/**
			 * Setting up the map with the information in the query result
			 */
			map = new Map(myRs.getString("X"), myRs.getInt("Height"), myRs.getInt("Width"));
		}
		

		for(int y = 0; y < map.getHeight(); y++) {
			for(int x = y == 0 ? 1 : 0; x < map.getWidth(); x++) {
				if (y == 1 && x == 0) {
					map.element[0][0] = new Indestructible();
				}
				switch(myRs.getString("X")) {
				case "#":
					map.element[y][x] = new Indestructible();
					break;
				case "O":
					map.element[y][x] = new Rock();
					break;
				case "T":
					map.element[y][x] = new Diamond();
					break;
				case "_":
					map.element[y][x] = new Destructible();
					break;
				case "@":
					map.element[y][x] = new monstre();
					break;
				case "=":
					map.element[y][x] = new Portal();
					break;
				case "P":
					map.element[y][x] = new Player();
					break;
				default:
					map.element[y][x] = null;
				}
				myRs.next();
			}
			
		}
		return map.element;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	return map.element;
}
}