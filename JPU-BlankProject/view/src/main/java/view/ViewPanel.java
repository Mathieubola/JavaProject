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

public class ViewPanel extends JPanel implements IViewPanel {

	private static final long serialVersionUID = 1L;
	private int Zoom = 50;
	private int xView = 15;
	private int yView = 15;
	private int xArea = 60;
	private int yArea = 60;
	
	private int score = 0;
	private double MortStep = 0.0;
	private ControllerOrder direction = ControllerOrder.Null;
	private int directionLife;
	
	private ViewFrame viewFrame;
	private IEntity[][] entitys = (IEntity[][]) new Entity[60][60];
	
	private ArrayList<Image> img_Rocher;
	private ArrayList<Image> img_Diamant;
	private ArrayList<Image> img_Portal;
	private ArrayList<Image> img_Enemie_1;
	private ArrayList<Image> img_Joueur_Right;
	private ArrayList<Image> img_Joueur_Left;
	private ArrayList<Image> img_Joueur_Up;
	private ArrayList<Image> img_Joueur_Down;
	private ArrayList<Image> img_Joueur_Mort;
	private Image img_Joueur;
	private Image img_Incassable;
	private Image img_Terre;
	private Image img_Terre_Bg;
	private Image img_Wallpaper;

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

	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

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
	
	private void displayScore(Graphics graphics) {
		graphics.setColor(Color.white);
		graphics.fillRoundRect(this.getWidth() / 2 - Zoom * 2, -1 * Zoom, Zoom * 4, Zoom * 2, Zoom / 2, Zoom / 2);
		graphics.setColor(Color.black);
		graphics.fillRoundRect(this.getWidth() / 2 - Zoom * 2 +2, -1 * Zoom +2, Zoom * 4 -4, Zoom * 2 -4, Zoom / 2, Zoom / 2);
		graphics.setColor(Color.white);
		graphics.setFont(new Font("Arial", 15, 25));
		graphics.drawString("Score : " + score, this.getWidth() / 2 - Zoom - 10, Zoom / 2);
	}
	
	private void displayMap(Graphics graphics) {
		int[] PlayerPos = viewFrame.getController().getPlayerPosition();
		
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
									int[] pp = viewFrame.getController().getPlayerPosition();
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
		
		
	public void displayEcranMort(Graphics graphics) {
		graphics.setColor(Color.white);
		graphics.setFont(new Font("Arial", 15, 50));
		graphics.drawString("U R dad", this.getWidth()/2-150, this.getHeight()/2-25);
		graphics.drawImage(img_Wallpaper, 0, 0, 750, 750, this);
	}

	public void setEntitys(IEntity[][] entitys) {
		this.entitys = entitys;
	}
	
	public IEntity[][] getEntitys() {
		return entitys;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	public void setDirection(ControllerOrder direction) {
		this.direction = direction;
		directionLife = 30;
	}
	
	public int getZoom() {
		return Zoom;
	}
	public int getxView() {
		return xView;
	}
	public int getyView() {
		return yView;
	}
	public int getxArea() {
		return xArea;
	}
	public int getyArea() {
		return yArea;
	}


	
}
