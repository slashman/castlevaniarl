package crl.cuts.entrance;

import sz.util.Position;
import crl.ai.monster.boss.DraculaAI;
import crl.ai.npc.VillagerAI;
import crl.conf.console.data.CharCuts;
import crl.cuts.Unleasher;
import crl.game.Game;
import crl.game.STMusicManagerNew;
import crl.level.Level;
import crl.monster.Monster;
import crl.ui.Display;
import crl.ui.UserInterface;

public class Entrance1 extends Unleasher {

	public void unleash(Level level, Game game) {
		Monster clara = level.getNPCByID("UNIDED_CLAW");
		int distance = Position.distance(clara.getPosition(), game.getPlayer().getPosition());
		if (((VillagerAI)clara.getSelector()).isHostile()){
			enabled = false;
			return;
		}
		if (distance > 2)
			return;
		Display.thus.showChat("CLARA1", game);
		level.removeMonster(clara);
		UserInterface.getUI().refresh();
		enabled = false;
	}

}
