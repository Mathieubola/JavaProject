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

public class ViewFrame extends JFrame implements KeyListener, IViewFrame {

	private IModel model;
	private IControllergame controllergame;
	private IControllerother controllerother;
	private IControllerplayer controllerplayer;
	private ViewPanel viewPanel;
	private IEntity[][] entitys;
	private static final long serialVersionUID = -697358409737458175L;
	private int tempoPlayer = 0;
	
	public ViewFrame(final IModel model) throws HeadlessException {
		this.buildViewFrame(model);
	}
	
	public ViewFrame(final IModel model, final GraphicsConfiguration gc) {
		super(gc);
		this.buildViewFrame(model);
	}
	
	public ViewFrame(final IModel model, final String title) throws HeadlessException {
		super(title);
		this.buildViewFrame(model);
	}
	
	public ViewFrame(final IModel model, final String title, final GraphicsConfiguration gc) {
		super(title, gc);
		this.buildViewFrame(model);
	}
	
	protected IControllergame getControllergame() {
		return this.controllergame;
	}
	
	public void setControllergame(final IControllergame controllergame) {
		this.controllergame= controllergame;
	}
	
	protected IControllerother getControllerother() {
		return this.controllerother;
	}
	
	public void setControllerother(final IControllerother controllerother) {
		this.controllerother = controllerother;
	}
	
	protected IControllerplayer getControllerplayer() {
		return this.controllerplayer;
	}
	
	public void setControllerplayer(final IControllerplayer controllerplayer) {
		this.controllerplayer = controllerplayer;
	}
	
	protected IModel getModel() {
		return this.model;
	}
	
	private void setModel(final IModel model) {
		this.model = model;
	}
	
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
	
	public void printMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	public ViewPanel getViewPanel() {
		return viewPanel;
	}
	

	public void keyPressed(KeyEvent e) {
		int[] playerPos = controllerplayer.getPlayerPosition(entitys);
		Player player = (Player) ( viewPanel.getEntitys()[playerPos[1]][playerPos[0]]);
		if (player.isAlive() && tempoPlayer == 0) {
			tempoPlayer = 5;
			this.getControllerplayer().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()), entitys);
		}
		
		
		
	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {
		
	}
	
	public void setEntity(IEntity[][] entitys) {
		tempoPlayer = tempoPlayer > 0 ? tempoPlayer - 1 : 0;
		viewPanel.setEntitys(entitys);
		this.entitys = entitys;
	}




}
