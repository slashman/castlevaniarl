package crl.cuts.villa;

import sz.util.Position;
import crl.ai.npc.VillagerAI;
import crl.conf.console.data.CharCuts;
import crl.cuts.Unleasher;
import crl.game.Game;
import crl.item.ItemFactory;
import crl.level.Level;
import crl.monster.Monster;
import crl.ui.Display;

public class Villa1 extends Unleasher {

	public void unleash(Level level, Game game) {
		Monster maiden = level.getNPCByID("MAIDEN");
		if (maiden == null)
			return;
		int distance = Position.distance(maiden.getPosition(), game.getPlayer().getPosition());
		if (((VillagerAI)maiden.getSelector()).isHostile()){
			enabled = false;
			return;
		}
		if (distance > 2)
			return;
		Display.thus.showChat("MAIDEN1", game);
		level.getPlayer().addKeys(1);
		//level.removeMonster(level.getNPCByID("MAIDEN"));
		enabled = false;
	}

}
