package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import entity.Entity;
import entity.Player;

public class Controller implements IController {
	
	private IView view;
	private IModel model;
	
	private int width = 60; //Hauteur du terrain
	private int height = 60; //Largeur du terrain
	private int score = 0; //Score du joueur
	private int delay = 30; //Delay entre les frames (30 fps -> 1000/30 = 29.333... ~= 30 ms)
	
	private Entity[][] entitys = new Entity[width][height]; //Tableau fixe contenant toute les entité du tableau (les rocher, diamant et tt)
	private Player player;

	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}
	
	public void control() {
		
	}
	
	public void start() {
		view.getViewFrame().getViewPanel().addEntitys(entitys);
		entitys = model.getMap(1);
		
		
		while (getPlayerPosition().length == 2) {
			this.moveFallingObject();
			this.collision();
			this.updateAnimation();
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void movePlayer() {
		//En fonction de la direction
	}
	
	public void moveFallingObject() {
		//Faire tomber les diams et les pierre
	}
	
	public void collision() {
		//Checker si on c'est pas pris un rochet sur la geul ou si on est pas sur un crystal ou un portail

	}
	
	public int[] getPlayerPosition() {
		int[] playerPos = new int[2];
		for(int y = 0; y < entitys.length; y++) {
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
	
	public void updateAnimation() {
		view.getViewFrame().getViewPanel().repaint();
	}
	
	

	private void setView(final IView pview) {
		this.view = pview;
	}

	private void setModel(final IModel model) {
		this.model = model;
	}
	

	public void orderPerform(final ControllerOrder controllerOrder) {
		int[] PlayerPos = getPlayerPosition();
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
		}
	}
	
}
