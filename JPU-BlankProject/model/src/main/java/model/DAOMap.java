package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Destructible;
import entity.Diamant;
import entity.Entity;
import entity.Indestructible;
import entity.Map;
import entity.Player;
import entity.Portal;
import entity.monstre;
import entity.Rock;

public class DAOMap {

	private final Connection connection;
	
	public DAOMap(final Connection connection) throws SQLException {
		this.connection = connection;
	}
	
	protected Connection getConnection() {
		return this.connection;
	}
	
	public boolean create(final Map entity) {
		return false;
	}
	
	public boolean delete(final Map entity) {
		return false;
	}
	
	public boolean update(final Map entity ) {
		return false;
	}

public Entity[][] getMapsql() {
	Map map = new Map();
	
	Connection myConn = null;
	CallableStatement myStmt = null;
	ResultSet myRs = null;

	try {

		myConn = DriverManager.getConnection("jdbc:mysql://localhost/jpublankproject?autoReconnect=true&useSSL=false","root","");
		myStmt = myConn.prepareCall("{call ProcBoulderdashMap1()}");
		myRs = myStmt.executeQuery();
		
		if (myRs.first()) {
			map = new Map(myRs.getString("X"), myRs.getInt("Height"), myRs.getInt("Width"));
		}
		
		//System.out.println(map.getHeight());
		//System.out.println(map.element.length);
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
					map.element[y][x] = new Diamant();
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
				//System.out.println("Ligne numéro : " + i + " || Colonne numéro : " + j + " contient :" + oui[j][i] );
			}
			
		}
		/*for(int i = 0; i < 22; i++) {
			for(int j = 0; j < 39; j++)	{
System.out.println("Ligne numéro : " + i + " || Colonne numéro : " + j + " contient :" + map.element[i][j] );
			}
		}*/
		return map.element;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	return map.element;
}
}