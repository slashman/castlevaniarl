package crl.levelgen.patterns;

import crl.cuts.Unleasher;
import sz.util.Position;

public class LegionLair extends StaticPattern {

	public String getMapKey(){
		return "CATACOMBS";
	}
	
	public String getDescription() {
		return "Tomb of Souls";
	}

	public String getMusicKeyMorning() {
		return "BOSS2";
	}

	public String getMusicKeyNoon() {
		return null;
	}

	public LegionLair(){
		cellMap= new String [][]{{
	
			"wwwwwwwwwwwwwwwwwwwww",
			"www...............www",
			"ww.................ww",
			"w...................w",
			"w...................w",
			"w...................w",
			"w...................w",
			"w...................w",
			"w...................w",
			"w...................w",
			"w...................w",
			"S...................E",
			"w...................w",
			"w...................w",
			"w...................w",
			"w...................w",
			"w...................w",
			"w...................w",
			"w...................w",
			"ww.................ww",
			"www...............www",
			"wwwwwwwwwwwwwwwwwwwww",
	}};

		charMap.put(".", "CAVE_FLOOR");
		charMap.put("w", "CAVE_WALL");
		charMap.put("S", "CAVE_FLOOR EXIT _BACK");
		charMap.put("E", "CAVE_FLOOR EOL MAGIC_DOOR COST 1");
	}
	
	public String getBoss(){
		return "LEGION";

	}
	public Position getBossPosition(){
		return new Position(10,10);
	}
}