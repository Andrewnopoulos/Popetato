package game.level.tiles;

import java.util.Random;

import game.graphics.Sprite;
import game.graphics.SpriteSheet;

public abstract class Tile {

	public static final Tile[] tiles = new Tile[256];
	public static Tile grass = new BasicTile(0, new Sprite[]{SpriteSheet.grass1, SpriteSheet.grass2}, 0xff00ff00);
	
	protected Sprite[] sprites;
	protected byte tileID;
	protected int levelColour;
	protected int spriteID;
	
	private Random random = new Random();
	
	public Tile (int id, Sprite[] sprites, int levelColour) {
		this.tileID = (byte)id;
		if(tiles[id] != null) {throw new RuntimeException("Duplicate tile id on " + id);}
		this.sprites = sprites;
		this.levelColour = levelColour;
		tiles[id] = this;
		spriteID = random.nextInt(sprites.length);
	}
	
	public Sprite getSprite() {
		return this.sprites[spriteID];
	}
	
}
