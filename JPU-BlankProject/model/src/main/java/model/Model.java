package model;

import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;
import entity.Entity;
import entity.Map;


public final class Model extends Observable implements IModel {
	private Map map;


	public Model() {
		this.map = new Map();
	}

	public Entity[][] getMap() {
		return this.map.element;
	}


	private void setmap(final Map map) {
		this.map = map;
		this.setChanged();
		this.notifyObservers();
	}


	public void loadmap(final String name) {
		try {
			final DAOMap daomap = new DAOMap(DBConnection.getInstance().getConnection());
			this.setmap(daomap.find(name));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}


	public Observable getObservable() {
		return this;
	}
}
