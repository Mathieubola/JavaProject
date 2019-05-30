package view;

import java.util.HashMap;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IControllergame;
import contract.IControllerother;
import contract.IControllerplayer;
import contract.IModel;
import contract.IView;
import contract.IViewFrame;

public class View implements IView, Runnable {
	
	private final IViewFrame viewFrame;
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
		if (keyCodeControllerOrder.containsKey(keyCode)) {
			return keyCodeControllerOrder.get(keyCode);
		} else {
			return ControllerOrder.Null;
		}
		
	}

	public void run() {
		this.viewFrame.setVisible(true);
	}

	public void printMessage(String message) {
		this.viewFrame.printMessage(message);
	}
	
	public void setControllergame(final IControllergame controllergame) {
		this.viewFrame.setControllergame(controllergame);
	}
	public void setControllerother(final IControllerother controllerother) {
		this.viewFrame.setControllerother(controllerother);
	}
	public void setControllerplayer(final IControllerplayer controllerplayer) {
		this.viewFrame.setControllerplayer(controllerplayer);
	}


	
	public IViewFrame getViewFrame() {
		return viewFrame;
	}

}
