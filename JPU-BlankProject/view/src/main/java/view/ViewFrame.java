package view;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import contract.IControllergame;
import contract.IControllerother;
import contract.IControllerplayer;
import contract.IEntity;
import contract.IModel;
import contract.IViewFrame;
import entity.Player;

/**
 * <b>This class is for the frame (or the windows) that is around the game</b>
 *
 * @see KeyListener
 * @see IViewFrame
 */
public class ViewFrame extends JFrame implements KeyListener, IViewFrame {

	/**
	 * <b>This is the model</b>
	 * 
	 * @see IModel
	 */
	private IModel model;
	
	/**
	 * <b>This is the controllergame variable</b>
	 * 
	 * @see IControllergame
	 */
	private IControllergame controllergame;
	
	/**
	 * <b>This is the controllerother variable</b>
	 * 
	 * @see IControllerother
	 */
	private IControllerother controllerother;
	
	/**
	 * <b>This is the controllerplayer variable</b>
	 * 
	 * @see IControllerplayer
	 */
	private IControllerplayer controllerplayer;
	
	/**
	 * <b>This is the ViewPanel variable</b>
	 */
	private ViewPanel viewPanel;
	
	/**
	 * <b>Declaration of entitys</b>
	 * 
	 * <p>entitys is an array that represent the map and the entitys in the map (player, rock, enemy...)</p>  
	 * 
	 * @see IEntity
	 */
	private IEntity[][] entitys;
	private static final long serialVersionUID = -697358409737458175L;
	
	/**
	 * <b>Use to stop the player moving when he died</b>
	 */
	private int tempoPlayer = 0;
	
	/**
	 * <b>The constructor of the class</b>
	 * 
	 * <p>They are several constructor for this classe. It's contruct just one time but we've keep the other in the case we will need them</p>
	 * 
	 * @param model
	 * @throws HeadlessException
	 */
	public ViewFrame(final IModel model) throws HeadlessException {
		this.buildViewFrame(model);
	}
	
	/**
	 * <b>An another constructor of the class</b>
	 * 
	 * @param model
	 * @param gc
	 */
	public ViewFrame(final IModel model, final GraphicsConfiguration gc) {
		super(gc);
		this.buildViewFrame(model);
	}
	
	/**
	 * <b>Again an another constructor</b>
	 * 
	 * @param model
	 * @param title
	 * @throws HeadlessException
	 */
	public ViewFrame(final IModel model, final String title) throws HeadlessException {
		super(title);
		this.buildViewFrame(model);
	}
	
	/**
	 * <b>The last constructor<b>
	 * 
	 * @param model
	 * @param title
	 * @param gc
	 */
	public ViewFrame(final IModel model, final String title, final GraphicsConfiguration gc) {
		super(title, gc);
		this.buildViewFrame(model);
	}
	
	/**
	 * <b>Getter of controllergame</b>
	 * 
	 * @see IControllergame
	 * @return controllergame
	 */
	protected IControllergame getControllergame() {
		return this.controllergame;
	}
	
	/**
	 * <b>Setter of Controllergame</b>
	 * 
	 * @see IControllergame
	 * @param controllergame
	 */
	public void setControllergame(final IControllergame controllergame) {
		this.controllergame= controllergame;
	}
	
	/**
	 * <b>Getter of controllerother</b>
	 * 
	 * @see IControllerother
	 * @return controllerother
	 */
	protected IControllerother getControllerother() {
		return this.controllerother;
	}
	
	/**
	 * <b>Setter of controllerother</b>
	 * 
	 * @see IControllerother
	 * @param controllerother
	 */
	public void setControllerother(final IControllerother controllerother) {
		this.controllerother = controllerother;
	}
	
	/**
	 * <b>Getter of controllerplayer</b>
	 * 
	 * @see IControllerplayer
	 * @return controllerplayer
	 */
	protected IControllerplayer getControllerplayer() {
		return this.controllerplayer;
	}
	
	/**
	 * <b>Setter of controllerplayer</b>
	 * 
	 * @see IControllerplayer
	 * @param controllerplayer
	 */
	public void setControllerplayer(final IControllerplayer controllerplayer) {
		this.controllerplayer = controllerplayer;
	}
	
	/**
	 * Getter of the model
	 * 
	 * @see IModel
	 * @return model
	 */
	protected IModel getModel() {
		return this.model;
	}
	
	/**
	 * <b>Setter of Model</b>
	 * 
	 * @see IModel
	 * @param model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}
	
	/**
	 * <b>The method who create viewPanel and who set some parameter of JFrame</b>
	 * 
	 * @param model
	 */
	private void buildViewFrame(final IModel model) {
		viewPanel = new ViewPanel(this);
		this.setModel(model);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.addKeyListener(this);
		this.setContentPane(viewPanel);
		this.setSize(viewPanel.getxView() * viewPanel.getZoom(), viewPanel.getyView() * viewPanel.getZoom());
		this.setLocationRelativeTo(null);
	}
	
	/**
	 * <b>This method print the message who's gived on parameter</b>
	 * 
	 * @param message
	 */
	public void printMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	/**
	 * <b>Getter of ViewPanel</b>
	 * 
	 * @return viewPanel
	 */
	public ViewPanel getViewPanel() {
		return viewPanel;
	}
	
	/**
	 * <b>This Method is execute at each key input from the user</b>
	 * 
	 * @param e
	 * @see KeyEvent
	 */
	public void keyPressed(KeyEvent e) {
		int[] playerPos = controllerplayer.getPlayerPosition(entitys);
		Player player = (Player) ( viewPanel.getEntitys()[playerPos[1]][playerPos[0]]);
		if (player.isAlive() && tempoPlayer == 0) {
			tempoPlayer = 5;
			this.getControllerplayer().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()), entitys);
		}
		
		
		
	}

	/**
	 * <b>This Method is execute at each key release from the user</b>
	 * 
	 * @param e
	 * @see KeyEvent
	 */
	public void keyReleased(KeyEvent e) {
		
	}
	
	/**
	 * <b>This Method is execute at each key input from the user</b>
	 * 
	 * @param e
	 * @see KeyEvent
	 */
	public void keyTyped(KeyEvent e) {
		
	}
	
	/**
	 * <b>Setter of entitys</b>
	 * 
	 * @param entitys
	 * @see IEntity
	 */
	public void setEntity(IEntity[][] entitys) {
		tempoPlayer = tempoPlayer > 0 ? tempoPlayer - 1 : 0;
		viewPanel.setEntitys(entitys);
		this.entitys = entitys;
	}




}
