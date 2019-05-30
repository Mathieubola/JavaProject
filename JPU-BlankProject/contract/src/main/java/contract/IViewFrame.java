package contract;

public interface IViewFrame {

	void setVisible(boolean b);

	void printMessage(String message);
	
	void setControllergame(IControllergame controllergame);
	void setControllerplayer(IControllerplayer controllerplayer);
	void setControllerother(IControllerother controllerother);
	

	IViewPanel getViewPanel();
	
	void setEntity(IEntity[][] entitys);

}
