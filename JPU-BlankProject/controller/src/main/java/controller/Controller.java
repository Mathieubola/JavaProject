package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IEntity;
import contract.IModel;
import contract.IView;
import entity.Player;

public class Controller implements IController {
	
	private IView view;
	private IModel model;
	

	public int score = 0; //Score du joueur
	private int delay = 30; //Delay entre les frames (30 fps -> 1000/30 = 29.333... ~= 30 ms)
	IEntity[][] entitys;
	


	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}
	
	public void control() {
		
	}
	
	public void start() {
	    this.entitys = model.getMap();
		//model.loadmap("X");
		entitys = model.getMap();
		
		
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
        
        for(int y = 0; y < entitys.length; y++) {
            for(int x = 0; x < entitys[y].length; x++) {
                if(entitys[y][x] != null && entitys[y][x].isFalling() && y < entitys.length-1 && entitys[y+1][x] == null) {
                    entitys[y+1][x] = entitys[y][x];
                    entitys[y][x] = null;
                    
                }else if(entitys[y][x] != null && entitys[y][x].isFalling() && y > 1 && x > 1 && entitys[y][x-1] == null && entitys[y-1][x-1] == null && entitys[y-1][x] != null && entitys[y-1][x].getSprite() == 'O') {
                    entitys[y][x-1] = entitys[y][x];
                    entitys[y][x] = null;
                    
                }else if(entitys[y][x] != null && entitys[y][x].isFalling() && y > 1 && x < entitys.length-1 && entitys[y][x+1] == null && entitys[y-1][x+1] == null && entitys[y-1][x] != null && entitys[y-1][x].getSprite() == 'O') {
                    entitys[y][x+1] = entitys[y][x];
                    entitys[y][x] = null;
                    
                }else if(entitys[y][x] != null && entitys[y][x].isFalling() && y < entitys.length-1 && entitys[y+1][x].isPlayer() == true) {
                    Player player = (Player) entitys[y+1][x];
                    player.setAlive(false);
                    
                }
            }
        }
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
		view.getViewFrame().getViewPanel().setEntitys((IEntity[][]) entitys);
		view.getViewFrame().getViewPanel().repaint();
	}
	
	

	private void setView(final IView pview) {
		this.view = pview;
	}

	private void setModel(final IModel model) {
		this.model = model;
	}
	

	public void orderPerform(final ControllerOrder controllerOrder) {
		view.getViewFrame().getViewPanel().setDirection(controllerOrder);
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
		} else {
			if (entitys[yP][xP].isDigable()) {
				if (entitys[yP][xP].getSprite() == 'T') {
					score += 15;
					view.getViewFrame().getViewPanel().setScore(score);
				}
				entitys[yP][xP] = entitys[oyP][oxP];
				entitys[oyP][oxP] = null;
			}
		}
	}
}


