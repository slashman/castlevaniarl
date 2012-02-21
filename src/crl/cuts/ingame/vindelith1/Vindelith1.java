package crl.cuts.ingame.vindelith1;

import crl.cuts.Unleasher;
import crl.game.Game;
import crl.level.Level;

public class Vindelith1 extends Unleasher {

	public void unleash(Level level, Game game) {
		level.addCounter("COUNTBACK_VINDELITHMEETING", 0);
		level.setFlag("VINDELITHMEETING", true);
		enabled = false;
	}

}
