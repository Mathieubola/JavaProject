package entity;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Diamant extends Falling {

	public Diamant() throws IOException {
		super(false, ImageIO.read(new File("Diamant_0.png")));
		
		try {
			this.addSprite(ImageIO.read(new File("Diamant_1.png")));
			this.addSprite(ImageIO.read(new File("Diamant_2.png")));
			this.addSprite(ImageIO.read(new File("Diamant_3.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
