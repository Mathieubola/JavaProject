package controller;

import contract.ControllerOrder;
import contract.IControllerplayer;
import contract.IEntity;
import contract.IModel;
import contract.IView;



/**
 * <b>This class is used to control the player as well as the collision</b>
 * 
 * 
 * @see IControllerplayer
 */
public class Controllerplayer implements IControllerplayer {
	/**
	 * <b>Declaration of the view</b>
	 * 
	 * @see IView
	 */
	private IView view;
	
	/**
	 * <b>Declaration of the model</b>
	 * 
	 * @see IModel
	 */
	private IModel model;
	
	/**
	 * <b>The score of the player (1 diamond = 15 points)</b>
	 */
	public int score = 0; //Score du joueur
	
	/**
	 * <b>Declaration of entitys</b>
	 * 
	 * <p>entitys is an array that represent the map and the entitys in the map (player, rock, enemy...)</p>  
	 * 
	 * @see IEntity
	 */
	IEntity[][] entitys;
	
	private int nbMap = 1;
	
	private int TempoPush = 0;
	

	/**
	 * <b>The controller of the class</b>
	 * 
	 * @param view
	 * @param model
	 */
	public Controllerplayer(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	
	/**
	 * <b>Getting the player position</b>
	 * 
	 * <p>The two for loop aims to "read the map" and checks if the players is here</p>
	 * 
	 * @return When the method find the player it return his coordinates in an int array
	 * 
	 * @see #entitys
	 */
	public int[] getPlayerPosition(IEntity[][] entitys) {
		int[] playerPos = new int[2];
		for(int y = 0; entitys != null && y < entitys.length; y++) {
			for(int x = 0; x < entitys[y].length; x++) {
				if (entitys[y][x] != null) {
					if(entitys[y][x].isPlayer() == true) {
						playerPos[0] = x;
						playerPos[1] = y;
					}
				}
			}
		}
		return playerPos;
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
	
	
	/**
	 * <b>This method is used to move the player depending on the key he pressed</b>
	 * 
	 * <p>This method also checks if the player goes into a diamond and update his score</p>
	 * 
	 * @see controllerOrder
	 * @see view
	 * @see #entitys
	 * @see score
	 */
	public void orderPerform(final ControllerOrder controllerOrder, IEntity[][] entitys) {
		this.entitys = entitys;
		view.getViewFrame().getViewPanel().setDirection(controllerOrder);
		int[] PlayerPos = getPlayerPosition(entitys);
		int xP = PlayerPos[0];
		int yP = PlayerPos[1];
		int oxP = xP;
		int oyP = yP;
		
		switch (controllerOrder) {
		case Left:
			xP -= 1;
			break;
		case Right:
			xP += 1;
			break;
		case Up:
			yP -= 1;
			break;
		case Down:
			yP += 1;
			break;
		default:
			break;
		}
		
		if (entitys[yP][xP] == null) {
			entitys[yP][xP] = entitys[oyP][oxP];
			entitys[oyP][oxP] = null;
		} else {
			if (entitys[yP][xP].isDigable()) {
				if (entitys[yP][xP].getSprite() == 'T') {
					score += 15;
					if (score - 15 < 15 * 10 && score >= 15 * 10) {
						view.getViewFrame().getViewPanel().ready();
					}
					view.getViewFrame().getViewPanel().setScore(score);
				} else if (score >= 15 * 10 && entitys[yP][xP].getSprite() == '=') {
					nbMap++;
					score = 0;
					view.getViewFrame().getViewPanel().setScore(0);
					entitys = model.getMap(nbMap);
					view.getViewFrame().getViewPanel().resetTempoScore();
				}
				if (score > 15 * 10 || entitys[yP][xP] != null && entitys[yP][xP].getSprite() != '=') {
					entitys[yP][xP] = entitys[oyP][oxP];
					entitys[oyP][oxP] = null;
				}
			}
		}
		
		if (entitys[yP][xP] != null && entitys[yP][xP].isPushable() && entitys[yP*2-oyP][xP*2-oxP] == null) {
			TempoPush++;
			if (TempoPush > 2) {
				TempoPush = 0;
				entitys[yP*2-oyP][xP*2-oxP] = entitys[yP][xP];
				entitys[yP][xP] = entitys[oyP][oxP];
				entitys[oyP][oxP] = null;
			}
		}
		this.entitys = entitys;
	}

	public IEntity[][] getEntity() {
		return entitys;
	}
	
	public void setEntity(IEntity[][] entitys) {
		this.entitys = entitys;
	}




}
