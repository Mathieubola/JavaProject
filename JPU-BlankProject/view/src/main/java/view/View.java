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

/**
 * <b>This class is for the view part</b>
 * 
 * @see IView
 * @see Runable
 */
public class View implements IView, Runnable {
	
	/**
	 * <b>Variable who contain the viewFrame</b>
	 * 
	 * @see IViewFrame
	 */
	private final IViewFrame viewFrame;
	
	/**
	 * <b>Variable who link the kaycode with the direction</b>
	 * 
	 * @see HashMap
	 */
	static HashMap<Integer, ControllerOrder> keyCodeControllerOrder = new HashMap<Integer, ControllerOrder>();
	
	/**
	 * <b>Constructor of View<b>
	 * 
	 * <p>It create also a viewFrame</p>
	 * 
	 * @param model
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
		keyCodeControllerOrder.put(90, ControllerOrder.Up);
		keyCodeControllerOrder.put(81, ControllerOrder.Left);
	    keyCodeControllerOrder.put(83, ControllerOrder.Down);
	    keyCodeControllerOrder.put(68, ControllerOrder.Right);
	}
	
	/**
	 * <b>Trad the keycode to direction</b>
	 * 
	 * @param keyCode
	 * @return
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		if (keyCodeControllerOrder.containsKey(keyCode)) {
			return keyCodeControllerOrder.get(keyCode);
		} else {
			return ControllerOrder.Null;
		}
		
	}
	
	/**
	 * <b>Set the frame visible</b>
	 */
	public void run() {
		this.viewFrame.setVisible(true);
	}
	
	/**
	 * <b>This method sende the message to viewFrame via his methode printMessage</b>
	 * 
	 * @param message
	 */
	public void printMessage(String message) {
		this.viewFrame.printMessage(message);
	}
	
	/**
	 * <b>Setter of Controllergame</b>
	 * 
	 * @see IControllergame
	 * @param controllergame
	 */
	public void setControllergame(final IControllergame controllergame) {
		this.viewFrame.setControllergame(controllergame);
	}
	
	/**
	 * <b>setter of controllerother</b>
	 * 
	 * @see IControllerother
	 * @param controllerother
	 */
	public void setControllerother(final IControllerother controllerother) {
		this.viewFrame.setControllerother(controllerother);
	}
	
	/**
	 * <b>Setter of controllerlayer</b>
	 * 
	 * @param controllerplayer
	 * @see IControllerplayer
	 */
	public void setControllerplayer(final IControllerplayer controllerplayer) {
		this.viewFrame.setControllerplayer(controllerplayer);
	}
	
	/**
	 * <b> Getter of controllerplayer</b>
	 * 
	 * @return controllerplayer
	 */
	public IControllerplayer getControllerplayer() {
		return this.viewFrame.getControllerplayer();
	}


	/**
	 * <b>Getter of viewFrame</b>
	 * 
	 * @return viewFrame
	 */
	public IViewFrame getViewFrame() {
		return viewFrame;
	}

}
