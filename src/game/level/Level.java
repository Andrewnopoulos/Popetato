package game.level;

import game.graphics.Screen;
import game.level.tiles.Tile;

import java.awt.image.BufferedImage;


public class Level {

	protected byte[] tiles;
	protected int width, height;
	
	protected String imagePath;
	protected BufferedImage image;
	
	public Level(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public void render(Screen screen) {
		for (int x = 0; x < screen.width; x++) {
			for (int y = 0; y < screen.height; y++) {
				screen.renderTile(getTile(x, y));
			}
		}
	}
	
	private Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return null;
		return Tile.tiles[tiles[x + y * width]];
	}
	
}
