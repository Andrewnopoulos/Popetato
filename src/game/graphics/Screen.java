package game.graphics;

import game.level.tiles.Tile;

public class Screen {

	public int[] pixels;
	public int width, height;
	
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}
	
	public void render() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0xff000000;
		}
	}
	
	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0; // sets screen to black
		}
	}
	
	public void renderTile(Tile tile) {
		for (int y = 0; y < tile.getSprite().height; y++) {
			for (int x = 0; x < tile.getSprite().width; x++) {
				pixels[x + y * width] = tile.getSprite().pixels[x + y * tile.getSprite().width];
			}
		}
	}
}
