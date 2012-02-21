package crl.cuts.ingame.death;

import crl.cuts.Unleasher;
import crl.game.Game;
import crl.level.Level;
import crl.ui.Display;

public class Death2 extends Unleasher {

	public void unleash(Level level, Game game) {
		if (level.getFlag("DEATH_LEVEL")&& level.getCounter("COUNTBACK_DEATH").isOver()){
			Display.thus.showChat("DEATH1", game);
			enabled = false;
		}
	}

}
