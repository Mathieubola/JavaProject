package model;

import java.sql.SQLException;
import java.util.Observable;
import java.util.Random;

import contract.IModel;
import entity.Destructible;
import entity.Diamant;
import entity.Entity;
import entity.Indestructible;
import entity.Map;
import entity.Player;
import entity.Rock;


public final class Model extends Observable implements IModel {
	@SuppressWarnings("unused")
	private Map map;


	public Model() {
		this.map = new Map();
	}

	/*public Entity[][] getMap() {
		return this.map.element;
	}*/
	public Entity[][] getMap() {
        //return this.map.element;
        Entity[][] map = new Entity[60][60];
        Random rand = new Random();
        double alea;
        for (int i = 0; i < 60; i++) {
            for (int j = 0; j < 60; j++) {
                alea = rand.nextDouble();
                if (i == 0 || i == 59 || j == 0 || j == 59) {
                	map[i][j] = new Indestructible();
                } else if (alea < 0.8) {
                    map[i][j] = new Destructible();
                } else if (alea < 0.9) {
                    map[i][j] = new Diamant();
                } else {
                    map[i][j] = new Rock();
                }
            }
        }
        map[30][30] = new Player();
        return map;
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
