package game.graphics;

public class Sprite {

	public int width;
	public int height;
	private final int x, y; // position of sprite on spritesheet
	public int[] pixels;
	private SpriteSheet sheet;
	
	public Sprite(int width, int height, int x, int y, SpriteSheet sheet) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.sheet = sheet;
		pixels = new int[width*height];
		load();
	}
	
	private void load() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				pixels[x + y * width] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.width];
			}
		}
	}
	
}
