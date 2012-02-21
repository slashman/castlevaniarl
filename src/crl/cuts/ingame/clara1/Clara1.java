package crl.cuts.ingame.clara1;

import crl.cuts.Unleasher;
import crl.game.Game;
import crl.level.Level;
import crl.ui.Display;
import crl.ui.UserInterface;

public class Clara1 extends Unleasher {

	public void unleash(Level level, Game game) {
			Display.thus.showChat("VINDELITH3", game);
			level.removeMonster(level.getNPCByID("VINDELITH"));
			level.removeMonster(level.getNPCByID("UNIDED_CLARA"));
			UserInterface.getUI().refresh();
			enabled = false;
	}

}
