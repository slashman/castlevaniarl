package crl.levelgen.patterns;

import crl.cuts.Unleasher;
import crl.cuts.ingame.deathHall.*;

public class DeathHall extends StaticPattern
{
	public String getMapKey(){
		return "HALL";
	}

	public DeathHall () {
		cellMap = new String [][]{
		{
			"#######################",
			"#,,,,,,,,,,,,,,,,,,,,,#",
			"#,,,,,,,,,,,,,,,,,,,,,#",
			"#,,,,,,,,,,,,,,,,,,,,,#",
			"####===#########===####",
			"#@......~@~.~@~......@#",
			"#.....................#",
			"#.....................#",
			"#---------------------#",
			"S----1----------------E",
			"#---------------------#",
			"#.....................#",
			"#.....................#",
			"#@......~@~.~@~......@#",
			"####===#########===####",
			"#,,,,,,,,,,,,,,,,,,,,,#",
			"#,,,,,,,,,,,,,,,,,,,,,#",
			"#,,,,,,,,,,,,,,,,,,,,,#",
			"#######################",
		}
	};

		charMap.put("o", "MARBLE_COLUMN");
		charMap.put(".", "MARBLE_FLOOR");
		charMap.put(",", "GARDEN_GRASS_ORNAMENTAL");
		charMap.put("S", "RED_CARPET EXIT _BACK");
		charMap.put("E", "RED_CARPET EXIT _NEXT");
		charMap.put("#", "CASTLE_WALL");
		charMap.put("=", "BIG_WINDOW");
		charMap.put("~", "MARBLE_FLOOR FEATURE RED_CURTAIN");
		charMap.put("@", "GODNESS_STATUE");
		charMap.put("-", "RED_CARPET");
		charMap.put("1", "RED_CARPET MONSTER DEATH");
		
		unleashers = new Unleasher[] {
			new DeathHall1(),
			new DeathHall2(),
		};
	}

	
	
	public String getDescription() {
		return "Hall";
	}

	public String getMusicKeyMorning() {
		return "";
	}

	public String getMusicKeyNoon() {
		return null;
	}
	
}