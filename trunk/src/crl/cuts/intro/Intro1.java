package crl.cuts.intro;

import sz.util.Position;
import crl.ai.monster.boss.DraculaAI;
import crl.conf.console.data.CharCuts;
import crl.cuts.Unleasher;
import crl.game.Game;
import crl.level.Level;
import crl.monster.Monster;
import crl.ui.Display;

public class Intro1 extends Unleasher {

	public void unleash(Level level, Game game) {
		Display.thus.showChat("INTRO_1", game);
		level.addCounter("COUNTBACK_INTRO_1", 5);
		level.setFlag("INTRO1", true);
		//level.removeExit("_BACK");
		enabled = false;
	}

}
