package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import entity.Entity;

public class ViewPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private ViewFrame viewFrame;
	private Entity[][] entitys;
	private int Zoom = 30;
	
	private ArrayList<Image> img_Rocher;
	private ArrayList<Image> img_Diamant;
	private ArrayList<Image> img_Portal;
	private ArrayList<Image> img_Enemie_1;
	private ArrayList<Image> img_Joueur_Right;
	private ArrayList<Image> img_Joueur_Left;
	private ArrayList<Image> img_Joueur_Mort;
	private Image img_Joueur;
	private Image img_Incassable;
	private Image img_Terre;
	private Image img_Terre_Bg;

	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		try {
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
			img_Enemie_1.add(ImageIO.read(new File("Ennemie_1_4.png")));
			
			img_Joueur = ImageIO.read(new File("Player_Null.png"));
			img_Joueur_Right.add(ImageIO.read(new File("Player_Right_0.png")));
			img_Joueur_Right.add(ImageIO.read(new File("Player_Right_1.png")));
			img_Joueur_Right.add(ImageIO.read(new File("Player_Right_2.png")));
			img_Joueur_Left.add(ImageIO.read(new File("Player_Left_0.png")));
			img_Joueur_Left.add(ImageIO.read(new File("Player_Left_1.png")));
			img_Joueur_Left.add(ImageIO.read(new File("Player_Left_2.png")));
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
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		if (entitys.length > 0) {
			if (entitys[0].length > 0) {
				
				for (int i = 0; i < entitys.length; i++) {
					for (int j = 0; j < entitys[i].length; j++) {
						
						graphics.drawImage(img_Terre_Bg, j*Zoom, i*Zoom, Zoom, Zoom, this);
						if (entitys[i][j] != null) {
							Image sprite = img_Terre_Bg;
							
							switch (entitys[i][j].getSprite()) {
							case '#':
								sprite = img_Incassable;
								break;
							case 'O':
								sprite = img_Rocher.get(entitys[i][j].update());
								break;
							case 'T':
								sprite = img_Diamant.get(entitys[i][j].update());
								break;
							case '_':
								sprite = img_Terre;
								break;
							case '@':
								sprite = img_Enemie_1.get(entitys[i][j].update());
								break;
							case '=':
								sprite = img_Portal.get(entitys[i][j].update());
								break;
							case 'P':
								sprite = img_Portal.get(entitys[i][j].update());
								break;
							}
							if (entitys[i][j].getSprite() != ' ') {
								graphics.drawImage(sprite, j*Zoom, i*Zoom, Zoom, Zoom, this);
							}
							
						}
						
					}
				}
				
			}
		}
		
	}

	public void addEntitys(Entity[][] entitys) {
		this.entitys = entitys;
	}
	
}
