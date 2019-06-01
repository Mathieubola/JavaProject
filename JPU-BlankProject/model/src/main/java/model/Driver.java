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
import entity.Portal;
import entity.Rock;
import entity.monstre;

/**
 * The driver for the connection to the database
 * 
 */
public class Driver {
	
	static entity.Entity[][] getMap() {
		
		/**
		 * Instanciation of the map
		 */
		Map map = new Map();
		
		Connection myConn = null;
		CallableStatement myStmt = null;
		ResultSet myRs = null;
		int i = 0;
		int j = 0;
		String[][] oui = new String[60][60];
		//Entity[][] element = new Entity[60][60];
		
		try {

			myConn = DriverManager.getConnection("jdbc:mysql://localhost/jpublankproject?autoReconnect=true&useSSL=false","root","");
			myStmt = myConn.prepareCall("{call ProcBoulderdashMap1()}");
			myRs = myStmt.executeQuery();
			
			if (myRs.first()) {

			};
				
				for(i = 0; i < 22; i++) {
					for(j = 0; j < 39; j++)	{
						oui[j][i] = myRs.getString("X");
						switch(myRs.getString("X")) {
						case "#":
							map.element[j][i] = new Indestructible();
							break;
						case "O":
							map.element[j][i] = new Rock();
							break;
						case "T":
							map.element[j][i] = new Diamant();
							break;
						case "_":
							map.element[j][i] = new Destructible();
							break;
						case "@":
							map.element[j][i] = new monstre();
							break;
						case "=":
							map.element[j][i] = new Portal();
							break;
						default:
							map.element[j][i] = null;
						}
						myRs.next();
						System.out.println("Ligne numéro : " + i + " || Colonne numéro : " + j + " contient :" + map.element[j][i] );
					}
					j = 0;
				}

			} catch (final SQLException e) {
				e.printStackTrace();
			}
		return map.element;
	}
	
	public static void main(String[] args) {
		
		Entity[][] oui2 = new Entity[60][60];
		int i = 0;
		int j = 0;
		
		oui2 = getMap();
		for(i = 0; i < 22; i++) {
			for(j = 0; j < 39; j++)	{
System.out.println("Ligne numéro2 : " + i + " || Colonne numéro2 : " + j + " contient2 :" + oui2[j][i] );
			}
			j = 0;
		}

	}

}
