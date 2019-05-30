package controller;

import contract.IControllergame;
import contract.IControllerother;
import contract.IControllerplayer;
import contract.IEntity;
import contract.IModel;
import contract.IView;


/**
 * <b>This class is used to link the view and the model and control the game</b>
 * 
 * 
 * @see IControllergame
 */
public class Controllergame implements IControllergame {
	/**
	 * <b>Declaration of the view</b>
	 * 
	 * @see IView
	 */
	private IView view;
	/**
	 * <b>Declaration of the player controller</b>
	 * 
	 * @see IView
	 */
	private IControllerplayer controllerplayer;
	/**
	 * <b>Declaration of the objects controller</b>
	 * 
	 * @see IView
	 */
	private IControllerother controllerother;
	/**
	 * <b>Declaration of the game controller</b>
	 * 
	 * @see IView
	 */
	private IControllergame controllergame;
	
	
	/**
	 * <b>Declaration of the model</b>
	 * 
	 * @see IModel
	 */
	private IModel model;
	
	/**
	 * <b>The score of the player (1 diamond = 15 points)</b>
	 */
	public int score = 0; //Player's Score
	
	/**
	 * <b>The delay between 2 frames</b>
	 * 
	 * <p>For example 30 Fps ==> 1000/30 = 29.333 ~= 30 ms</p>
	 */
	private int delay = 30; //Delay between frames (30 fps -> 1000/30 = 29.333... ~= 30 ms)
	
	/**
	 * <b>Declaration of entitys</b>
	 * 
	 * <p>entitys is an array that represent the map and the entitys in the map (player, rock, enemy...)</p>  
	 * 
	 * @see IEntity
	 */
	IEntity[][] entitys;
	
	private int nbMap = 1;
	
	

	/**
	 * <b>The controller of the class</b>
	 * 
	 * @param view
	 * @param model
	 */
	public Controllergame(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
		
		controllerplayer = (IControllerplayer) new Controllerplayer(view, model);
		controllerother = (IControllerother) new Controllerother(view, model);
		controllergame = this;
	}
	
	/**
	 * 
	 */
	public void control() {
		
	}
	
	/**
	 * 
	 */
	public void start() {
		entitys = model.getMap(nbMap);
		
		while (controllerplayer.getPlayerPosition(entitys).length == 2) {
			
			this.controllerother.moveFallingObject(entitys);
			this.controllerplayer.collision();
			this.controllergame.updateAnimation();
			this.view.getViewFrame().setEntity(entitys);
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * <b> updating the display</b>
	 * 
	 * <p>This method send the entitys array to the view and ask the view to update the display of the game</p>
	 * 
	 * @see #view
	 */
	public void updateAnimation() {
		view.getViewFrame().getViewPanel().setEntitys((IEntity[][]) entitys);
		view.getViewFrame().getViewPanel().repaint();
	}
	
	
	/**
	 * 
	 * @param pview
	 */
	private void setView(final IView pview) {
		this.view = pview;
	}

	/**
	 * 
	 * @param model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}






	
	


}
