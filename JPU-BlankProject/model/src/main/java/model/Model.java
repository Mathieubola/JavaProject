package model;

import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;

import entity.Entity;
import entity.Map;



public final class Model extends Observable implements IModel {
	
	@SuppressWarnings("unused")
	private Map map;

	Entity[][] oui;

	public Model() {
		this.map = new Map();
	}

	public Entity[][] getMap(int nbMap) {
			try {
				DAOMap daomap = new DAOMap(DBConnection.getInstance().getConnection());
				oui = daomap.getMapsql(nbMap);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return oui;
		
	}


	public Observable getObservable() {
		return this;
	}

	@Override
	public void loadmap(String code) {
		
	}

}
