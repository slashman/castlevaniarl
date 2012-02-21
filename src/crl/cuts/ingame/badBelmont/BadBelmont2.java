package crl.cuts.ingame.badBelmont;

import sz.util.Position;
import crl.action.ActionFactory;
import crl.ai.monster.boss.DraculaAI;
import crl.conf.console.data.CharCuts;
import crl.cuts.Unleasher;
import crl.game.Game;
import crl.game.PlayerGenerator;
import crl.level.Level;
import crl.monster.Monster;
import crl.player.Player;
import crl.ui.Display;

public class BadBelmont2 extends Unleasher{

	public void unleash(Level level, Game game) {
		if (level.getPlayer().getFlag("SAVED_SOLIEYU")){
			enabled = false;
			return;
		}
		Monster belmont = level.getMonsterByID("BADBELMONT");
		if (belmont != null)
			return;
		Display.thus.showChat("BADSOLIEYU2", game);
		enabled = false;
	}
}