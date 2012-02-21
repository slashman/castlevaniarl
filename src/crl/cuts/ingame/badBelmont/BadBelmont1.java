package crl.cuts.ingame.badBelmont;

import crl.cuts.Unleasher;
import crl.game.Game;
import crl.game.STMusicManagerNew;
import crl.level.Level;
import crl.ui.Display;

public class BadBelmont1 extends Unleasher {

	public void unleash(Level level, Game game) {
		Display.thus.showChat("BADSOLIEYU1", game);
		if (level.getPlayer().hasItemByID("JUKEBOX")){
			level.addMessage("The jukebox plays a mellow melody");
			Display.thus.showChat("SAVESOLIEYU", game);
			level.removeMonster(level.getMonsterByID("BADBELMONT"));
			level.getPlayer().setFlag("SAVED_SOLIEYU", true);
			level.removeBoss();
			level.getPlayer().addHistoricEvent("saved Solieyu Belmont from certain doom");
			level.getPlayer().addKeys(1);
		} else {
			level.setMusicKeyMorning("BADBELMONT");
			level.setMusicKeyNoon("BADBELMONT");
			STMusicManagerNew.thus.playKey("BADBELMONT");
		}
		enabled = false;
	}

}
