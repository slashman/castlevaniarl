package crl.levelgen.patterns;

import java.util.Hashtable;

import crl.cuts.Unleasher;
import crl.cuts.dracula.Dracul2;
import crl.cuts.dracula.Dracula0;
import crl.cuts.dracula.Dracula1;

import sz.util.Position;


public class Keep extends StaticPattern{
	public String getMapKey(){
		return "KEEP";
	}
	
public Keep (){
	cellMap = new String [][]{{
		"        wwoowwwooww        ",
		"    wooww..=====..wwoow    ",
		"   ww......=={==......ww   ",
		"  ww.......==E==.......ww  ",
		"  w........=====........w  ",
		"  w.......i=====i.......w  ",
		"  w........=====........w  ",
		"  w........=====........w  ",
		"  w........=====........w  ",
		" ww.......i=====i.......ww ",
		" w.s....s..=====..s....s.w ",
		" w.........=====.........w ",
		"ww.........=====.........ww",
		"w.........i=====i.........w",
		"w..........=====..........w",
		"w..........=====..........w",
		"w..........=====..........w",
		"w.........i=====i.........w",
		"o..s....s..=====..s....s..w",
		"o..........=====..........w",
		"o..........=====..........w",
		"o..s....s..=====..s....s..o",
		"w.........i=====i.........o",
		"w..........=====..........o",
		"w..........=====..........o",
		"w..........=====......i...w",
		"w.........i=====i.........w",
		"w..........=====..........w",
		"w..........=====..........w",
		"ww.s....s..=====..s....s.ww",
		" w........i=====i........w ",
		" w.........=====.........w ",
		" ww........=====........ww ",
		"  w........=====........w  ",
		"  w........=====........w  ",
		"  w........=====........w  ",
		"  ww.wwww..=====..wwww.ww  ",
		"   w...wwwww===wwwww...w   ",
		"    w|||ww..===..ww|||w    ",
		"         w..===..w         ",
		"         w..===..w         ",
		"         w..===..w         ",
		"         w..===..w         ",
		"         o.i===i.o         ",
		"         o..===..o         ",
		"         o..===..o         ",
		"         w..===..w         ",
		"         w..===..w         ",
		"         w..===..w         ",
		"         w..===..w         ",
		"         w..===..w         ",
		"         o..===..o         ",
		"         o.i===i.o         ",
		"         o..===..o         ",
		"         w..===..w         ",
		"         w..===..w         ",
		"         w..===..w         ",
		"         w..===..w         ",
		"         w..===..w         ",
		"         o..===..o         ",
		"         o..===..o         ",
		"         o.i===i.o         ",
		"         w..===..w         ",
		"         w..===..w         ",
		"         w..===..w         ",
		"         w..===..w         ",
		"         w..===..w         ",
		"         w..===..w         ",
		"         w..===..w         ",
		"         wwww=wwww         ",
		"          wwxxxww          ",
		"          wwxxxww          ",
		"            xxx            ",
		"            xxx            ",
		"            xxx            ",
		"            xxx            ",
		"            xxx            ",
		"            xxx            ",
		"            xxx            ",
		"            xxx            ",
		"            xxx            ",
		"            xxx            ",
		"            xxx            ",
		"            xxx            ",
		"            xxx            ",
		"            xxx            ",
		"            xxx            ",
		"            xxx            ",
		"            xxx            ",
		"            xxx            ",
		"            wSw            "
					}};

						charMap.put(".", "KEEP_FLOOR");
						charMap.put("w", "KEEP_WALL");
						charMap.put("=", "KEEP_CARPET");
						charMap.put("E", "DRACULA_THRONE2 EXIT #DRACPOS");
						charMap.put("i", "KEEP_FLOOR FEATURE CANDLE");
						charMap.put("S", "KEEP_FLOOR EXIT _START");
						charMap.put("s", "GODNESS_STATUE");
						charMap.put("o", "BARRED_WINDOW");
						charMap.put("{", "DRACULA_THRONE1");
						charMap.put("[", "DRACULA_THRONE2");
						charMap.put("|", "BALCONY");
						charMap.put("x", "STONE_STAIRWAY");
						charMap.put("c", "CLOCK_TOWER");
			
			unleashers = new Unleasher[]{
				new Dracula0(),
				new Dracula1(),
				new Dracul2()
			};
}

	public Position getBossPosition(){
		return new Position(17,13);
	}
	
	public String getBoss(){
		return "DRACULA";
	}
	public String getDescription() {
		return "Castle Keep";
	}
	public String getMusicKeyMorning() {
		return "KEEP"; /*Turns to DRACULA when the battle starts*/
	}
	public String getMusicKeyNoon() {
		return null;
	}
	
}