package crl.cuts.dracula;

import crl.cuts.Unleasher;
import crl.game.Game;
import crl.game.STMusicManagerNew;
import crl.level.Level;
import crl.monster.Monster;
import crl.ui.Display;

public class Dracula3 extends Unleasher{

	public void unleash(Level level, Game game) {
		Monster dracula = level.getMonsterByID("DEMON_DRACULA");
		if (dracula != null)
			return;
		STMusicManagerNew.thus.stopMusic();
		Display.thus.showChat("DRACULA3", game);
		STMusicManagerNew.thus.playKey("VICTORY");
		game.wonGame();
		enabled = false;
	}
}