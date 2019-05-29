package contract;

import java.util.Observable;

import contract.IEntity;;


public interface IModel {

	void loadmap(String code);
	Observable getObservable();
	IEntity[][] getMap();



	
}
