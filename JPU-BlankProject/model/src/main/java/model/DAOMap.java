package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Destructible;
import entity.Diamant;
import entity.Indestructible;
import entity.Map;
import entity.Portal;
import entity.monstre;
import entity.rock;

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

public Map find(final String name) {
	Map map = new Map();
	
	try {
		final String sql = "{call procBoulderDash(?)}";
		final CallableStatement call = this.getConnection().prepareCall(sql);
		call.setString(1,  name);
		call.execute();
		final ResultSet resultSet = call.getResultSet();
		if (resultSet.first()) {
			map = new Map(resultSet.getString("X"), resultSet.getInt("length"), resultSet.getInt("width"));
		}
		
			int i = 0, j = 0;
			
			for(i = 0; i < map.getLength(); i++)
			{
				for(j = 0; j < map.getWidth(); j++)
				{
					switch(resultSet.getString("X")) {
					case "#":
						map.element[j][i] = new Indestructible();
						break;
					case "O":
						map.element[j][i] = new rock();
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
					}
					resultSet.next();
				}
				resultSet.next();
			}
				
		return map;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
}
}

