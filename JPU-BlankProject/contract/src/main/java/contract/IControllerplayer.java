package contract;

public interface IControllerplayer {

	int[] getPlayerPosition(IEntity[][] entitys);

	void orderPerform(ControllerOrder keyCodeToControllerOrder, IEntity[][] entity);

	IEntity[][] getEntity();
	
	void setEntity(IEntity[][] entitys);

}
