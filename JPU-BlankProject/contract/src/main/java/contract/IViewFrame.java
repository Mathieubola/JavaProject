package contract;

public interface IViewFrame {

	void setVisible(boolean b);

	void printMessage(String message);

	void setController(IController controller);

	IViewPanel getViewPanel();

}
