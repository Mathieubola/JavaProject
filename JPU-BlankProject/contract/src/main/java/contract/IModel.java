package contract;

import java.util.Observable;

import entity.Entity;


public interface IModel {


	Entity[][] getMap();


	void loadmap(String code);

	Observable getObservable();
}
