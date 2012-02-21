package crl.cuts.mummies;

import java.util.Hashtable;

import sz.util.Position;

import crl.cuts.Unleasher;
import crl.game.CRLException;
import crl.game.Game;
import crl.game.STMusicManagerNew;
import crl.level.Level;
import crl.levelgen.StaticGenerator;
import crl.ui.Display;

public class Mummy1 extends Unleasher {
	public void unleash(Level level, Game game){
		if (level.getBoss() == null){
			Display.thus.showScreen("As you destroy the mummy of Akmodan, the whole room trembles, and a cold hurricaned wind covers all the place, shredding everything on sight. All of a sudden, the floor under you collapses.");
			level.getPlayer().reduceKeys(1);
			level.setMusicKeyMorning("");
			level.setMusicKeyNoon("");
			STMusicManagerNew.thus.stopMusic();
			try {
				StaticGenerator.getGenerator().renderOverLevel(level, newMap, charMap, new Position(0,0));
			} catch (CRLException crle){
				Game.crash("Error on Mummy1 unleasher", crle);
			}
			enabled = false;
		}
	}
	
	String [] newMap = new String[]{
		"---wwwwwwwwwwwwwwwwwwwwwwwwwwwwww---",
		"--ww------.....------------.....ww--",
		"-ww.-----------..o------------...ww-",
		"ww..----------..ooo-------------..ww",
		"w..--o-----------o------------o---.w",
		"w---ooo----------------------ooo---w",
		"w----o------------------------o----w",
		"w----------------------------------w",
		"w.--------------------------------.w",
		"w>.-------------------------------.w",
		"w..------------------------------..w",
		"E.-------------------------------..w",
		"w..-------------------------------.w",
		"w...------------------------------.w",
		"w..--------------------------------w",
		"w----------------------------------w",
		"w----o------------------------o----w",
		"w.--ooo----------------------ooo---w",
		"w...-o-----------o------------o--..w",
		"ww..------------ooo-------------..ww",
		"-ww..------..----o--------...--..ww-",
		"--ww............................ww--",
		"---wwwwwwwwwwwwwwwwwwwwwwwwwwwwww---"
	};
	
	private Hashtable charMap = new Hashtable();
	{
		charMap.put("o", "RUINS_COLUMN");
		charMap.put(".", "RUINS_FLOOR");
		charMap.put("-", "AIR");
		charMap.put("w", "RUINS_WALL");
		charMap.put("h", "RUINS_FLOOR_H");
		charMap.put("s", "RUINS_STAIRS");
		charMap.put("<", "MARBLE_STAIRSUP");
		charMap.put(">", "MARBLE_STAIRSDOWN");
		charMap.put("c", "RUINS_FLOOR FEATURE CANDLE 70");
		charMap.put("C", "RUINS_FLOOR FEATURE COFFIN 100");
		charMap.put("E", "NOTHING");
		charMap.put("D", "RUINS_FLOOR EXIT _NEXT");
	}
}
