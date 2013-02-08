package game.graphics;

import game.level.tiles.Tile;

public class Screen {

	public int[] pixels;
	public int width, height;
	
	public int xOffset = 0, yOffset = 0;
	
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
	
	public void renderTile(int xp, int yp, Tile tile) {
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0; y < tile.getSprite().height; y++) {
			int ya = y + yp;
			for (int x = 0; x < tile.getSprite().width; x++) {
				int xa = x + xp;
/* TODO */		if (xa < -tile.getSprite().width || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				pixels[xa + ya * width] = tile.getSprite().pixels[x + y * tile.getSprite().width];
				
			}
		}
	}
	
	public void changeOffset(int xd, int yd) {
		this.xOffset += xd;
		this.yOffset += yd;
	}
	public void setOffset(int x, int y) {
		this.xOffset = x;
		this.yOffset = y;
	}
}
