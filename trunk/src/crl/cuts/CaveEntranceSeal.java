package crl.cuts;

import crl.game.Game;
import crl.level.Level;

public class CaveEntranceSeal extends Unleasher {

	public void unleash(Level level, Game game) {
		//level.removeExit("MUMMIES_LAIR");
		enabled = false;
	}

}