package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Map;

abstract class DAOMap extends DAOEntity<Map> {

	public DAOMap(final Connection connection) throws SQLException {
		super(connection);
	}
	
	@Override
	public boolean create(final Map entity) {
		return false;
	}
	
	@Override
	public boolean delete(final Map entity) {
		return false;
	}
	
	@Override
	public boolean update(final Map entity ) {
		return false;
	}

@Override
public Map find(final String name) {
	Map map = new Map();
	
	try {
		final String sql = "{call procBoulderDash(?)}";
		final CallableStatement call = this.getConnection().prepareCall(sql);
		call.setString(1,  name);
		call.execute();
		final ResultSet resultSet = call.getResultSet();
		if (resultSet.first()) {
			map = new Map(name, resultSet.getInt("length"), resultSet.getInt("widht"));
		}
		
			int i = 0, j = 0;
			
			for(i = 0; i < element.length; i++)
			{
				for(j = 0; j < element.width; j++)
				{
					
				}
			}
				
		return map;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
}
}

