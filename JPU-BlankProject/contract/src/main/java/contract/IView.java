package contract;


public interface IView {
	
	void printMessage(final String message);
	
	IViewFrame getViewFrame();

	IControllerplayer getControllerplayer();
	
}
