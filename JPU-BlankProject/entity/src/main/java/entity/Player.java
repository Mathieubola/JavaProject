package entity;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import contract.ControllerOrder;

public class Player extends Anime {

	private ArrayList<Image> img_Joueur_Right;
	private ArrayList<Image> img_Joueur_Left;
	private ArrayList<Image> img_Joueur_Mort;
	private Image img_Joueur;
	private ControllerOrder direction;

	public Player(boolean isMovable, boolean isPushable, boolean isPlayer, Image sprite) throws IOException {
		super(false, false, true, ImageIO.read(new File("Player_Null.png")));
		
		try {
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
	
	public void move(ControllerOrder direction) {
		if (this.direction != direction) {
			this.clearSprites();
			switch (direction) {
			case Down:
				
				break;
			case Left:
				
				break;
			case Null:
				
				break;
			case Right:
				
				break;
			case Up:
				
				break;
			
			}
		}
	}
	
}
