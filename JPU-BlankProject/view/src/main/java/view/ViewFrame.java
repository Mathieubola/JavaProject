package view;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import contract.IController;
import contract.IModel;

public class ViewFrame extends JFrame implements KeyListener {

	private IModel model;
	private IController controller;
	private ViewPanel viewPanel;
	private static final long serialVersionUID = -697358409737458175L;
	
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
	
	private IController getController() {
		return this.controller;
	}
	
	protected void setController(final IController controller) {
		this.controller = controller;
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
		this.setSize(400 + this.getInsets().left + this.getInsets().right, 60 + this.getInsets().top + this.getInsets().bottom);
		this.setLocationRelativeTo(null);
	}
	
	public void printMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	public ViewPanel getViewPanel() {
		return viewPanel;
	}
	
	public void keyPressed(KeyEvent e) {
		this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {
		
	}

}
