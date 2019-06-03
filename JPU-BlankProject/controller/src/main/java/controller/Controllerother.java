package controller;

import contract.IControllerother;
import contract.IEntity;
import contract.IModel;
import contract.IView;
import entity.Falling;
import entity.Player;
import entity.monstre;
import entity.Diamond;
/**
 * <b>This class is for enemies or objects  as well as their collisions</b>
 * 
 * 
 * @see IControllerother
 */
public class Controllerother implements IControllerother {
	
	
	/**
	 * <b>Declaration of entitys</b>
	 * 
	 * <p>entitys is an array that represent the map and the entitys in the map (player, rock, enemy...)</p>  
	 * 
	 * @see IEntity
	 */
	IEntity[][] entitys;
	
	private int moveMonsterTimer = 0;
	
	IView view;
	

	/**
	 * <b>The controller of the class</b>
	 * 
	 * @param view
	 * @param model
	 */
	public Controllerother(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}
	

	
	/**
	 * <b>This method is used to make the rocks and diamonds fall down</b>
	 * 
	 * <p>The loops are used to "read the map"</p>
	 * <p>Then it checks if the entities should fall and how it should fall</p>
	 * <p>This method also checks if the player is dying or not</p>
	 * 
	 * @see #entitys
	 */

	public void moveFallingObject(IEntity[][] entitys) {
        for(int y = 0; entitys != null && y < entitys.length; y++) {
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
                    } else if (y < entitys.length-1 && entitys[y+1][x].getSprite() == '@' && falling.getKilling() == true) {
                    	entitys[y+1][x] = new Diamond();
                    } else if (entitys[y+1][x] != null && !entitys[y+1][x].isPlayer()) {
                        falling.setKilling(false);
                    }
                }
            }
        }
    }
	

	
	/**
	 * Setter of view
	 * 
	 * @param pview
	 */
	private void setView(final IView pview) {
		this.view = pview;
	}

	/**
	 * 
	 * @param Setter of model
	 */
	private void setModel(final IModel model) {
	}
	
	/**
	 * <b>This method is used to move the enemy</b>
	 * 
	 * <p>The loops are used to "read the map"</p>
	 * 
	 * @see monster
	 * @see #entitys
	 */
	public void moveMonster(IEntity[][] entitys) {
		moveMonsterTimer = moveMonsterTimer > 20 ? 0 : moveMonsterTimer + 1;
		if (moveMonsterTimer == 0) {
			for(int y = 0; entitys != null && y < entitys.length; y++) {
				for(int x = 0; x < entitys[y].length; x++) {
					if(entitys[y][x] != null && entitys[y][x].getSprite() == '@') {
						monstre monstre = (monstre) entitys[y][x];
						int direction = monstre.getDirection();
						switch(direction) {
						case 0:
							if(entitys[y-1][x] == null && entitys[y][x-1] != null) {
								entitys[y-1][x] = entitys[y][x];
			                    entitys[y][x] = null;
							}else if(entitys[y-1][x] != null && entitys[y-1][x].isPlayer() && entitys[y][x-1] != null) {
								Player player = (Player) entitys[y-1][x];
								player.setAlive(false);
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
							}else if(entitys[y][x+1] != null && entitys[y][x+1].isPlayer() && entitys[y-1][x] != null) {
								Player player = (Player) entitys[y][x+1];
								player.setAlive(false);
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
							}else if(entitys[y+1][x] != null && entitys[y+1][x].isPlayer() && entitys[y][x+1] != null) {
								Player player = (Player) entitys[y+1][x];
								player.setAlive(false);
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
							}else if(entitys[y][x-1] != null && entitys[y][x-1].isPlayer() && entitys[y+1][x] != null) {
								Player player = (Player) entitys[y][x-1];
								player.setAlive(false);
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
		this.entitys = entitys;
	}




	
	
}
