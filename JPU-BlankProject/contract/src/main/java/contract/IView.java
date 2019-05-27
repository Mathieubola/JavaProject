package contract;

import view.ViewFrame;

public interface IView {
	
	void printMessage(final String message);
	
	ViewFrame getViewFrame();
	
}
