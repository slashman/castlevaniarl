package crl.cuts.intro;

import crl.conf.console.data.CharCuts;
import crl.cuts.Unleasher;
import crl.game.Game;
import crl.game.SFXManager;
import crl.game.STMusicManagerNew;
import crl.level.Level;
import crl.ui.Display;

public class Intro2 extends Unleasher {

	public void unleash(Level level, Game game) {
		if (level.getFlag("INTRO1")&& level.getCounter("COUNTBACK_INTRO_1").isOver()){
			level.addMessage("You hear howling in the distance!");
			SFXManager.play("wav/howl.wav");
			level.addCounter("COUNTBACK_INTRO_2", 5);
			level.setFlag("INTRO2", true);
			level.removeCounter("COUNTBACK_INTRO_1");
			enabled = false;
		}
	}

}