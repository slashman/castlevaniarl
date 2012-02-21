package crl.levelgen.patterns;

import crl.cuts.Unleasher;
import crl.cuts.ingame.deathHall.*;
import crl.cuts.ingame.vindelith1.Vindelith1;
import crl.cuts.ingame.vindelith1.Vindelith2;

public class VindelithMeeting extends StaticPattern
{
	public String getMapKey(){
		return "LAB";
	}

	public VindelithMeeting () {
		cellMap = new String [][]{
		{
			"                                ",
			"                                ",
			"                                ",
			"                                ",
			"   ###+#######+#######+###      ",
			"   #.....................#      ",
			"   #.....................#      ",
			"##+#.....................#      ",
			"#........................###+###",
			"S..............................E",
			"#........................###+###",
			"##+#.12..................#      ",
			"   #.....................#      ",
			"   #.....................#      ",
			"   ###+#######+#######+###      ",
			"                                ",
			"                                ",
			"                                ",
			"                                ",

		}
	};

		charMap.put(".", "RED_FLOOR");
		charMap.put("S", "RED_FLOOR EXIT _BACK");
		charMap.put("E", "RED_FLOOR EXIT _NEXT");
		charMap.put("#", "RED_WALL");
		charMap.put("+", "SMALL_WINDOW");
		charMap.put("2", "RED_FLOOR NPC UNIDED_VINDELITH");
		charMap.put("1", "RED_FLOOR NPC UNIDED_CLAW");
		
		unleashers = new Unleasher[] {
			new Vindelith1(),
			new Vindelith2(),
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