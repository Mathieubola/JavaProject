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
	
	private Entity[][] entitys = new Entity[width][height]; //Tableau fixe contenant toute les entit� du tableau (les rocher, diamant et tt)
	private Player player;
	
	private ControllerOrder direction;

	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}
	
	public void control() {
		
	}
	
	public void start() {
		view.getViewFrame().getViewPanel().addEntitys(entitys);
		entitys = model.getMap(1);
		
		while (player.isAlive()) {
			this.moveFallingObject();
			this.collision();
			this.updateAnimation();
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
		int Py;
		int Px;
		int[] playerPos;
		for(int y = 0; y < entitys.max; y++) {
			for(int x = 0; x < entitys[y][x].max; x++) {
				if(entitys[y][x].isPlayer() == true) {
					Py = y;
					Px = x;
				}
			}
		}
		
		playerPos[0] = Py;
		playerPos[1] = Px;
		
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
		switch (controllerOrder) {
		case Left:
			player.setX(player.getX() - 1);
			break;
		case Right:
			player.setX(player.getX() + 1);
			break;
		case Up:
			player.setY(player.getY() - 1);
			break;
		case Down:
			player.setY(player.getY() + 1);
			break;
		default:
			break;
		}
	}
	
}
