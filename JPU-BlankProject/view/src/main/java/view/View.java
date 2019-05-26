package view;

import java.util.HashMap;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

public class View implements IView, Runnable {
	
	private final ViewFrame viewFrame;
	static HashMap<Integer, ControllerOrder> keyCodeControllerOrder = new HashMap<Integer, ControllerOrder>();
	
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
		keyCodeControllerOrder.put(90, ControllerOrder.Up);
		keyCodeControllerOrder.put(81, ControllerOrder.Left);
	    keyCodeControllerOrder.put(83, ControllerOrder.Down);
	    keyCodeControllerOrder.put(68, ControllerOrder.Right);
	}
	
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		return keyCodeControllerOrder.get(keyCode);
	}

	public void run() {
		this.viewFrame.setVisible(true);
	}

	public void printMessage(String message) {
		this.viewFrame.printMessage(message);
	}
	
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
	
	public ViewFrame getViewFrame() {
		return viewFrame;
	}

}
