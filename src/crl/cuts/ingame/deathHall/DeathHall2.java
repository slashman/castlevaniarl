package crl.cuts.ingame.deathHall;

import crl.cuts.Unleasher;
import crl.game.Game;
import crl.level.Level;
import crl.ui.Display;

public class DeathHall2 extends Unleasher {

	public void unleash(Level level, Game game) {
		if (level.getFlag("DEATH_HALL")&& level.getCounter("COUNTBACK_DEATHHALL").isOver()){
			Display.thus.showChat("DEATH_HALL", game);
			level.removeMonster(level.getMonsterByID("DEATH"));
			enabled = false;
		}
	}

}
