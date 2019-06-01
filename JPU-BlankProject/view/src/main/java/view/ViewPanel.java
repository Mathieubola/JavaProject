package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import contract.ControllerOrder;
import contract.IEntity;
import contract.IViewPanel;
import entity.Entity;
import entity.Player;


/**
 * <b>This class is for the game, what is print in the windows</b>
 *
 * @see IViewPanel
 */
public class ViewPanel extends JPanel implements IViewPanel {

	private static final long serialVersionUID = 1L;
	/**
	 * <b>The "Zoom", upper it is, bigger the texture will be</b>
	 */
	private int Zoom = 50;
	
	/**
	 * <b>the number of block that will be visible on the view for x axis</b>
	 */
	private int xView = 15;
	
	/**
	 * <b>the number of block that will be visible on the view for y axis</b>
	 */
	private int yView = 15;
	
	/**
	 * <b>The default size of the map in x axis</b>
	 */
	private int xArea = 60;
	
	/**
	 * <b>The default size of the map in y axis</b>
	 */
	private int yArea = 60;
	
	/**
	 * <b>The score of the player</b>
	 */
	private int score = 0;
	
	/**
	 * <b>The variable to increment while the player die for the animation</b>
	 */
	private double MortStep = 0.0;
	
	/**
	 * <b>The variable how will be incremented while the tips for the score is show during the beginning of a level</b>
	 */
	private int tempoScore= 0;
	
	/**
	 * <b>The variable how will be incremented while the big ready appear when you have enough diamonds</b>
	 */
	private int readyTime = 0;
	
	/**
	 * <b>Give the direction of the player so we know witch sprite print</b>
	 */
	private ControllerOrder direction = ControllerOrder.Null;
	
	/**
	 * <b>The variable who will define how many time the player keep a direction before facing the sceen</b>
	 */
	private int directionLife;
	
	/**
	 * <b>Declaration of viewFrame</b>
	 * 
	 * <p>viewFrame make possible the communication for ViewPanel (here) to viewframe</p>
	 * 
	 * @see ViewFrame
	 */
	private ViewFrame viewFrame;
	
	/**
	 * <b>Declaration of entitys</b>
	 * 
	 * <p>entitys is an array that represent the map and the entitys in the map (player, rock, enemy...)</p>
	 * <p>It's defined here with a default empty entity array</p>
	 * 
	 * @see IEntity
	 */
	private IEntity[][] entitys = (IEntity[][]) new Entity[60][60];
	
	/**
	 * <b>Contain the sprite of the rock</b>
	 * 
	 * @see ArrayList
	 */
	private ArrayList<Image> img_Rocher;
	
	/**
	 * <b>Contain the sprite of the Diamond</b>
	 * 
	 * @see ArrayList
	 */
	private ArrayList<Image> img_Diamant;
	
	/**
	 * <b>Contain the sprite of the Portal</b>
	 * 
	 * @see ArrayList
	 */
	private ArrayList<Image> img_Portal;
	
	/**
	 * <b>Contain the sprite of the mob</b>
	 * 
	 * @see ArrayList
	 */
	private ArrayList<Image> img_Enemie_1;
	
	/**
	 * <b>Contain the sprite of the player when he move to the right</b>
	 * 
	 * @see ArrayList
	 */
	private ArrayList<Image> img_Joueur_Right;
	
	/**
	 * <b>Contain the sprite of the player when he move to the left</b>
	 * 
	 * @see ArrayList
	 */
	private ArrayList<Image> img_Joueur_Left;
	
	/**
	 * <b>Contain the sprite of the player when he move upper</b>
	 * 
	 * @see ArrayList
	 */
	private ArrayList<Image> img_Joueur_Up;
	
	/**
	 * <b>Contain the sprite of the player when he move down</b>
	 * 
	 * @see ArrayList
	 */
	private ArrayList<Image> img_Joueur_Down;
	
	/**
	 * <b>Contain the sprite of the player when he died</b>
	 * 
	 * @see ArrayList
	 */
	private ArrayList<Image> img_Joueur_Mort;
	
	/**
	 * <b>Contain the sprite of the player when he face the screen</b>
	 */
	private Image img_Joueur;
	
	/**
	 * <b>Contain the sprite of the unbreakable wall</b>
	 */
	private Image img_Incassable;
	
	/**
	 * <b>Contain the sprite of the dirt</b>
	 */
	private Image img_Terre;
	
	/**
	 * <b>Contain the sprite of the background (when a dirt is dig)</b>
	 */
	private Image img_Terre_Bg;
	
	/**
	 * <b>Contain the end screen</b>
	 */
	private Image img_Wallpaper;

	/**
	 * <b>The constructor of the class</b>
	 * 
	 * <p>Read all the sprite and place them in the right package</p>
	 * 
	 * @param viewFrame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		img_Rocher = new ArrayList<Image>();
		img_Diamant = new ArrayList<Image>();
		img_Portal = new ArrayList<Image>();
		img_Enemie_1 = new ArrayList<Image>();
		img_Joueur_Right = new ArrayList<Image>();
		img_Joueur_Left = new ArrayList<Image>();
		img_Joueur_Up = new ArrayList<Image>();
		img_Joueur_Down = new ArrayList<Image>();
		img_Joueur_Mort = new ArrayList<Image>();
		try {
			img_Wallpaper = ImageIO.read(new File("Wallpaper.jpg"));
			
			img_Rocher.add(ImageIO.read(new File("Stone_0.png")));
			img_Rocher.add(ImageIO.read(new File("Stone_1.png")));
			img_Rocher.add(ImageIO.read(new File("Stone_2.png")));
			img_Rocher.add(ImageIO.read(new File("Stone_3.png")));
			img_Diamant.add(ImageIO.read(new File("Diamant_0.png")));
			img_Diamant.add(ImageIO.read(new File("Diamant_1.png")));
			img_Diamant.add(ImageIO.read(new File("Diamant_2.png")));
			img_Diamant.add(ImageIO.read(new File("Diamant_3.png")));
			img_Portal.add(ImageIO.read(new File("Portal_0.png")));
			img_Portal.add(ImageIO.read(new File("Portal_1.png")));
			img_Portal.add(ImageIO.read(new File("Portal_2.png")));
			img_Portal.add(ImageIO.read(new File("Portal_3.png")));
			img_Incassable = ImageIO.read(new File("Incassable.png"));
			img_Terre = ImageIO.read(new File("Dirt.png"));
			img_Terre_Bg = ImageIO.read(new File("Dirt Background.png"));
			
			img_Enemie_1.add(ImageIO.read(new File("Ennemie_1_0.png")));
			img_Enemie_1.add(ImageIO.read(new File("Ennemie_1_1.png")));
			img_Enemie_1.add(ImageIO.read(new File("Ennemie_1_2.png")));
			img_Enemie_1.add(ImageIO.read(new File("Ennemie_1_3.png")));
			
			img_Joueur = ImageIO.read(new File("Player_Null.png"));
			img_Joueur_Right.add(ImageIO.read(new File("Player_Right_0.png")));
			img_Joueur_Right.add(ImageIO.read(new File("Player_Right_1.png")));
			img_Joueur_Right.add(ImageIO.read(new File("Player_Right_2.png")));
			img_Joueur_Left.add(ImageIO.read(new File("Player_Left_0.png")));
			img_Joueur_Left.add(ImageIO.read(new File("Player_Left_1.png")));
			img_Joueur_Left.add(ImageIO.read(new File("Player_Left_2.png")));
			img_Joueur_Up.add(ImageIO.read(new File("Player_Up_0.png")));
			img_Joueur_Up.add(ImageIO.read(new File("Player_Up_1.png")));
			img_Joueur_Up.add(ImageIO.read(new File("Player_Up_2.png")));
			img_Joueur_Up.add(ImageIO.read(new File("Player_Up_3.png")));
			img_Joueur_Down.add(ImageIO.read(new File("Player_Down_0.png")));
			img_Joueur_Down.add(ImageIO.read(new File("Player_Down_1.png")));
			img_Joueur_Down.add(ImageIO.read(new File("Player_Down_2.png")));
			img_Joueur_Down.add(ImageIO.read(new File("Player_Down_3.png")));
			img_Joueur_Mort.add(ImageIO.read(new File("Player_dead_0.png")));
			img_Joueur_Mort.add(ImageIO.read(new File("Player_dead_1.png")));
			img_Joueur_Mort.add(ImageIO.read(new File("Player_dead_2.png")));
			img_Joueur_Mort.add(ImageIO.read(new File("Player_dead_3.png")));
			img_Joueur_Mort.add(ImageIO.read(new File("Player_dead_4.png")));
			img_Joueur_Mort.add(ImageIO.read(new File("Player_dead_5.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <b>Setter of viewFrame</b>
	 * @param viewFrame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/**
	 * <b>Method execute each time the screen must be refresh</b>
	 * 
	 * <p>It print all the sprite that should be printed</p>
	 * 
	 * @param Graphics
	 */
	protected void paintComponent(final Graphics graphics) {
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		if (directionLife > 0) {
			directionLife--;
		} else {
			direction = ControllerOrder.Null;
		}
		
		if ((int) MortStep < 6) {
			this.displayMap(graphics);
			
			this.displayScore(graphics);
		} else {
			this.displayEcranMort(graphics);
		}
	}
	
	/**
	 * <b>Method who display the score and the Tips at the beginning</b>
	 * 
	 * @param graphics
	 */
	private void displayScore(Graphics graphics) {
		graphics.setColor(Color.white);
		graphics.fillRoundRect(this.getWidth() / 2 - Zoom * 2, -1 * Zoom, Zoom * 4, Zoom * 2, Zoom / 2, Zoom / 2);
		graphics.setColor(Color.black);
		graphics.fillRoundRect(this.getWidth() / 2 - Zoom * 2 + 2, -1 * Zoom + 2, Zoom * 4 -4, Zoom * 2 - 4, Zoom / 2, Zoom / 2);
		graphics.setColor(Color.white);
		graphics.setFont(new Font("Arial", 15, 25));
		graphics.drawString("Score : " + score, this.getWidth() / 2 - Zoom - 10, Zoom / 2);
		
		if (tempoScore < 175) {
			if ((int) (tempoScore / 10) % 2 == 0) {
				graphics.setColor(Color.white);
			} else {
				graphics.setColor(Color.red);//Samil dislike the lightings of the text ... :(
			}
			graphics.drawString("You need a score of " + 15 * 10 + " or more to pass through the portal", 20, this.getHeight() - 20);
			tempoScore++;
		}
		
		if (readyTime > 0) {
			readyTime--;
			if ((int) (readyTime / 5) % 2 == 0) {
				graphics.setColor(Color.white);
			} else {
				graphics.setColor(Color.red);
			}
			graphics.setFont(new Font("Arial", 15, 100));
			graphics.drawString("Ready", this.getWidth() / 2 - 3 * 50, this.getHeight() / 2);
		}
		
	}
	
	/**
	 * <b>This method display the map with the player and the mob</b>
	 * 
	 * @param graphics
	 */
	private void displayMap(Graphics graphics) {
		int [] PlayerPos = viewFrame.getControllerplayer().getPlayerPosition(entitys);
		
		if (entitys.length > 0 && PlayerPos.length == 2) {
			if (entitys[0].length > 0) {
				
				for (int y = PlayerPos[1] - yView / 2, coy = 0 ; y <= PlayerPos[1] + yView / 2; y++, coy++) {
					
					for (int x = PlayerPos[0] - xView / 2, cox = 0; x <= PlayerPos[0] + xView / 2; x++, cox++) {
						
						if (y >= 0 && y < entitys.length && x >= 0 && x < entitys[y].length) {
							graphics.drawImage(img_Terre_Bg, cox*Zoom, coy*Zoom, Zoom, Zoom, this);
							if (entitys[y][x] != null) {
								Image sprite = img_Terre_Bg;
								
								switch (entitys[y][x].getSprite()) {
								case '#':
									sprite = img_Incassable;
									break;
								case 'O':
									sprite = img_Rocher.get(entitys[y][x].update());
									break;
								case 'T':
									sprite = img_Diamant.get(entitys[y][x].update());
									break;
								case '_':
									sprite = img_Terre;
									break;
								case '@':
									sprite = img_Enemie_1.get(entitys[y][x].update());
									break;
								case '=':
									sprite = img_Portal.get(entitys[y][x].update());
									break;
								case 'P':
									int[] pp = viewFrame.getControllerplayer().getPlayerPosition(entitys);
									if (!entitys[pp[1]][pp[0]].isPlayer()) {
										break;
									}
									Player player = (Player) entitys[pp[1]][pp[0]];
									if (player.isAlive()) {
										switch (direction) {
										case Left:
											sprite = img_Joueur_Left.get(entitys[y][x].update());
											break;
										case Right:
											sprite = img_Joueur_Right.get(entitys[y][x].update());
											break;
										case Up:
											sprite = img_Joueur_Up.get(entitys[y][x].update());
											break;
										case Down:
											sprite = img_Joueur_Down.get(entitys[y][x].update());
											break;
										default:
											sprite = img_Joueur;
											break;
										}
									} else {
										if ((int) MortStep < 6) {
											sprite = img_Joueur_Mort.get((int) MortStep);
											MortStep += 0.1;
										}
									}
									break;
								}
								if (entitys[y][x].getSprite() != ' ') {
									graphics.drawImage(sprite, cox*Zoom, coy*Zoom, Zoom, Zoom, this);
								}
							}
						}
						
					}
				}
				
			}
		}
	}
		
	/**
	 * <b>This methode display the deathScrenn</b>
	 * 
	 * @param graphics
	 */
	public void displayEcranMort(Graphics graphics) {
		graphics.setColor(Color.white);
		graphics.setFont(new Font("Arial", 15, 60));
		graphics.drawImage(img_Wallpaper, 0, 0, 750, 750, this);
	}

	/**
	 * <b>Setter of entitys</b>
	 * 
	 * @param entitys
	 * @see IEntity
	 */
	public void setEntitys(IEntity[][] entitys) {
		this.entitys = entitys;
	}
	
	/**
	 * <b>Getter of entitys</b>
	 * 
	 * @see IEntity
	 * @return entitys
	 */
	public IEntity[][] getEntitys() {
		return entitys;
	}
	
	/**
	 * <b>Setter of score</b>
	 * 
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	/**
	 * <b>Setter of direction</b>
	 * 
	 * @param direction
	 */
	public void setDirection(ControllerOrder direction) {
		this.direction = direction;
		directionLife = 30;
	}
	
	/**
	 * <b>This method reset the tempoScore variable</b>
	 */
	public void resetTempoScore() {
		tempoScore = 0;
	}
	
	/**
	 * <b>This function set the readyTime variable to 50</b>
	 * 
	 * <p>The purpose is to print the ready when the player has enough diamond</p>
	 */
	public void ready() {
		readyTime = 50;
	}
	
	/**
	 * <b>Getter of Zoom</b>
	 * 
	 * @return Zoom
	 */
	public int getZoom() {
		return Zoom;
	}
	
	/**
	 * <b>Getter of xView</b>
	 * @return xView
	 */
	public int getxView() {
		return xView;
	}
	
	/**
	 * <b>Getter of yView</b>
	 * @return yView
	 */
	public int getyView() {
		return yView;
	}
	
	/**
	 * <b>Getter of xArea</b>
	 * @return xArea
	 */
	public int getxArea() {
		return xArea;
	}
	
	/**
	 * <b>Getter of yArea</b>
	 * @return yArea
	 */
	public int getyArea() {
		return yArea;
	}


	
}
