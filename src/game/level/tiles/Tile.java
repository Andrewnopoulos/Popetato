package game.level.tiles;

import java.util.Random;

import game.graphics.Sprite;
import game.graphics.SpriteSheet;

public abstract class Tile {

	public static final Tile[] tiles = new Tile[256];
	public static Tile grass1 = new BasicTile(1, new Sprite[]{SpriteSheet.grass2}, 0xff00ff00);
	public static Tile grass2 = new BasicTile(2, new Sprite[]{SpriteSheet.grass1}, 0xff007f00);
	public static Tile voidTile = new BasicTile(0, new Sprite[]{SpriteSheet.voidTile}, 0xff000000);
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
		System.out.println(spriteID);
	}
	
	public Sprite getSprite() {
		return this.sprites[spriteID];
	}
	
}
