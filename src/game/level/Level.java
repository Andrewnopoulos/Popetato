package game.level;

import game.graphics.Screen;
import game.level.tiles.Tile;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Level {

	protected byte[] tiles;
	protected int width, height;
	
	protected String imagePath;
	protected BufferedImage image;
	
	private Random rand = new Random();
	
	public Level(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public void GenerateLevel() {
		this.width = 64;
		this.height = 64;
		this.tiles = new byte[64*64];
		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = (byte)(rand.nextInt(2)+1);
		}
	}
	
	public void render(int xScroll, int yScroll, Screen screen) {
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;
		
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				screen.renderTile(x<<4, y<<4, getTile(x,y));
			}
		}
	}
	
	public Tile getTile(int xPos, int yPos) {
		if (xPos < 0 || yPos < 0 || xPos >= width || yPos >= height) {
			return Tile.voidTile;
		}
		return Tile.tiles[tiles[xPos + yPos * width]];
	}
}
