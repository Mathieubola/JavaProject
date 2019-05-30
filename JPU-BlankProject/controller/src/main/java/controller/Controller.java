package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IEntity;
import contract.IModel;
import contract.IView;
import entity.Falling;
import entity.Player;
import entity.monstre;

/**
 * <b>This class is used to link the view and the model, controll the player as well as the collision</b>
 * 
 * 
 * @see IContrller
 */
public class Controller implements IController {
	
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
	 * <b>The delay between 2 frames</b>
	 * 
	 * <p>For example 30 fps ==> 1000/30 = 29.333 ~= 30 ms</p>
	 */
	private int delay = 30; //Delay entre les frames (30 fps -> 1000/30 = 29.333... ~= 30 ms)
	
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
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
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
		//model.loadmap("X");
		entitys = model.getMap(nbMap);
		
		while (getPlayerPosition().length == 2) {
			this.moveFallingObject();
			this.collision();
			this.updateAnimation();
			this.moveMonster();
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * <b>not used</b>
	 */
	public void movePlayer() {
		//En fonction de la direction
	}
	
	/**
	 * <b>This method is used to make the rocks and diamonds falling down</b>
	 * 
	 * <p>The two for loop aims to "read the map"</p>
	 * <p>Then it checks if the entitys should fall and how it should fall</p>
	 * <p>This method also checks if the player is dying or not</p>
	 * 
	 * @see #entitys
	 */

	public void moveFallingObject() {
        for(int y = 0; y < entitys.length; y++) {
            for(int x = 0; x < entitys[y].length; x++) {
                if(entitys[y][x] != null && entitys[y][x].isFalling()) {
                    Falling falling = (Falling) entitys[y][x];
                    if(y < entitys.length-1 && entitys[y+1][x] == null) { // chute tout droit
                        entitys[y+1][x] = entitys[y][x];
                        entitys[y][x] = null;
                        falling.setKilling(true);
                    }else if(y > 1 && x > 1 && entitys[y][x-1] == null && entitys[y-1][x-1] == null && entitys[y-1][x] != null && entitys[y-1][x].getSprite() == 'O') {
                        entitys[y][x-1] = entitys[y][x]; //    
                        entitys[y][x] = null;                        
                    }else if(y > 1 && x < entitys.length-1 && entitys[y][x+1] == null && entitys[y-1][x+1] == null && entitys[y-1][x] != null && entitys[y-1][x].getSprite() == 'O') {
                        entitys[y][x+1] = entitys[y][x];
                        entitys[y][x] = null;
                    }else if(y < entitys.length-1 && entitys[y+1][x].isPlayer() == true && falling.getKilling() == true) {
                        Player player = (Player) entitys[y+1][x];
                        player.setAlive(false);
                    } else if (entitys[y+1][x] != null && !entitys[y+1][x].isPlayer()) {
                        falling.setKilling(false);
                    }
                }
            }
        }
    }
	
	/**
	 * not used
	 */
	public void collision() {
		//Checker si on c'est pas pris un rochet sur la geul ou si on est pas sur un crystal ou un portail

	}
	
	/**
	 * <b>This method is used to move the enemy</b>
	 * 
	 * <p>The two for loops aims to "read the map"</p>
	 * 
	 * @see monster
	 * @see #entitys
	 */
	public void moveMonster() {
		int Mx;
		int My;
		for(int y = 0; y < entitys.length; y++) {
			for(int x = 0; x < entitys[y].length; x++) {
				if(entitys[y][x] != null && entitys[y][x].getSprite() == '@') {
					monstre monstre = (monstre) entitys[y][x];
					int direction = monstre.getDirection();
					switch(direction) {
					case 0:
						if(entitys[y-1][x] == null && entitys[y][x-1] != null) {
							entitys[y-1][x] = entitys[y][x];
		                    entitys[y][x] = null;
						}else if(entitys[y][x-1] == null) {
							entitys[y][x-1] = entitys[y][x];
		                    entitys[y][x] = null;
		                    monstre.setDirection(3);
						}else if(entitys[y-1][x] != null && entitys[y][x-1] != null) {
							monstre.setDirection(2);
						}
						break;
						
					case 1:
						if(entitys[y][x+1] == null && entitys[y-1][x] != null) {
							entitys[y][x+1] = entitys[y][x];
		                    entitys[y][x] = null;
						}else if(entitys[y-1][x] == null) {
							entitys[y-1][x] = entitys[y][x];
		                    entitys[y][x] = null;
		                    monstre.setDirection(0);
						}else if(entitys[y][x+1] != null && entitys[y-1][x] != null) {
							monstre.setDirection(3);
						}					
						break;
						
					case 2:
						if(entitys[y+1][x] == null && entitys[y][x+1] != null) {
							entitys[y+1][x] = entitys[y][x];
		                    entitys[y][x] = null;
						}else if(entitys[y][x+1] == null) {
							entitys[y][x+1] = entitys[y][x];
		                    entitys[y][x] = null;
		                    monstre.setDirection(1);
						}else if(entitys[y+1][x] != null && entitys[y][x+1] != null) {
							monstre.setDirection(0);
						}
						break;
						
					case 3:
						if(entitys[y][x-1] == null && entitys[y+1][x] != null) {
							entitys[y][x-1] = entitys[y][x];
		                    entitys[y][x] = null;
						}else if(entitys[y+1][x] == null) {
							entitys[y+1][x] = entitys[y][x];
		                    entitys[y][x] = null;
		                    monstre.setDirection(2);
						}else if(entitys[y][x-1] != null && entitys[y+1][x] != null) {
							monstre.setDirection(1);
						}	
						break;
					}

					
				}
				
			}
		}
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
	public int[] getPlayerPosition() {
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
	
	
	/**
	 * <b>This method is used to move the player depending on the key he pressed</b>
	 * 
	 * <p>This method also check if the player go into a diamond and update his score</p>
	 * 
	 * @see controllerOrder
	 * @see view
	 * @see #entitys
	 * @see score
	 */
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
					if (score - 15 < 15 * 5 && score >= 15 * 5) {
						view.getViewFrame().getViewPanel().ready();
					}
					view.getViewFrame().getViewPanel().setScore(score);
				} else if (score >= 15 * 5 && entitys[yP][xP].getSprite() == '=') {
					nbMap++;
					score = 0;
					entitys = model.getMap(nbMap);
					view.getViewFrame().getViewPanel().resetTempoScore();
				}
				if (score > 15 * 5 || entitys[yP][xP] != null && entitys[yP][xP].getSprite() != '=') {
					entitys[yP][xP] = entitys[oyP][oxP];
					entitys[oyP][oxP] = null;
				}
			}
		}
		
		if (entitys[yP][xP] != null && entitys[yP][xP].isPushable() && entitys[yP*2-oyP][xP*2-oxP] == null) {
			TempoPush++;
			if (TempoPush > 20) {
				TempoPush = 0;
				entitys[yP*2-oyP][xP*2-oxP] = entitys[yP][xP];
				entitys[yP][xP] = entitys[oyP][oxP];
				entitys[oyP][oxP] = null;
			}
		}
	}
}


