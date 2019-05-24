package entity;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class rock extends Falling {

	public rock() throws IOException {
		super(true, ImageIO.read(new File("Stone_0.png")));
		
		try {
			this.addSprite(ImageIO.read(new File("Stone_1.png")));
			this.addSprite(ImageIO.read(new File("Stone_2.png")));
			this.addSprite(ImageIO.read(new File("Stone_3.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
