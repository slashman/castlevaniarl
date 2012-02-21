package crl.cuts.training;

import sz.util.Position;
import crl.cuts.Unleasher;
import crl.game.Game;
import crl.level.Level;
import crl.ui.Display;

public class Training2 extends Unleasher {
	public void unleash(Level level, Game game){
		Position x = level.getExitFor("#END");
		if (level.getPlayer().getPosition().equals(x)){
			game.exitGame();
			enabled = false;
		}
	}
}
