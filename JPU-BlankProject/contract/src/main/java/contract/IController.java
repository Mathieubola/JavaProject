package contract;

public interface IController {
	
	public void control();

	public void orderPerform(ControllerOrder controllerOrder);

	public int[] getPlayerPosition();
}
