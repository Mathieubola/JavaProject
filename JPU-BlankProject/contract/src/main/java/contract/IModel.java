package contract;

import java.util.Observable;

import entity.Map;


public interface IModel {


	Map getMap();


	void loadmap(String code);

	Observable getObservable();
}
