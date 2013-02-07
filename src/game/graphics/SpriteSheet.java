package game.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	public static SpriteSheet baseSheet = new SpriteSheet("/sheet.png");
	public static Sprite grass1 = new Sprite(16, 16, 0, 0, SpriteSheet.baseSheet);
	public static Sprite grass2 = new Sprite(16, 16, 16, 0, SpriteSheet.baseSheet);
	
	public String path;
	public int[] pixels;
	public int width, height;
	
	public SpriteSheet(String path) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(SpriteSheet.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (image == null) {
			return;
		}
		
		this.path = path;
		this.width = image.getWidth();
		this.height = image.getHeight();
		
		pixels = image.getRGB(0, 0, width, height, null, 0, width);
	}
	
}
