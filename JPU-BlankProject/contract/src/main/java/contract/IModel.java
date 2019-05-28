package contract;

import java.util.Observable;

import entity.Entity;


public interface IModel {

	void loadmap(String code);
	Observable getObservable();
	Entity[][] getMap();



	
}
