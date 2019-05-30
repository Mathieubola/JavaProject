package contract;

public interface IControllerplayer {

	int[] getPlayerPosition(IEntity[][] entitys);

	void collision();

	void orderPerform(ControllerOrder keyCodeToControllerOrder, IEntity[][] entity);
	
	
	

}
