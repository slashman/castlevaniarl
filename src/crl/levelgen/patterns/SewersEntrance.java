package crl.levelgen.patterns;

public class SewersEntrance extends StaticPattern
{
	public String getMapKey(){
		return null;
	}
	
	public String getMusicKeyMorning() {
		return "";
	}

	public String getMusicKeyNoon() {
		return null;
	}
	
	

	public SewersEntrance () {
		cellMap = new String [][]{
		{
			"###########",
			"###.-S-.###",
			"##...-...##",
			"#...---...#",
			"#..-----..#",
			"#..--E--..#",
			"#..-----..#",
			"#...---...#",
			"##.......##",
			"###.....###",
			"###########",
           
		}
	};

		charMap.put("#", "SEWERS_WALL");
		charMap.put(".", "SEWERS_FLOOR");
		charMap.put("-", "SEWERS_FLOOR");
		charMap.put("S", "SEWERS_UP EXIT TOWN0");
		charMap.put("E", "SEWERS_DOWN EXIT SEWERS0");
	}

	
	public String getDescription() {
		return "Petra Sewers";
	}
}