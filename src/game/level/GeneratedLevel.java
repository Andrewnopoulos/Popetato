package game.level;

public class GeneratedLevel extends Level {

	public int size;
	public int buildingDensity;
	
	public GeneratedLevel(int size, int buildingDensity) {
		super("/newlevel.png");
		this.imagePath = "/newlevel.png";
		this.size = size;
		this.buildingDensity = buildingDensity;
		
		this.height = 64 * size;
		this.width = 64 * size;
		
		tiles = new byte[this.width * this.height];
		
		generateLand();
		generateRoads();
		generateBuildings();
	}
	
	private void generateLand() {
		
	}
	
	private void generateRoads() {
		
	}
	
	private void generateBuildings() {
		
	}
	
}
