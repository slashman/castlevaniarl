package crl.cuts.ingame.vindelith1;

import crl.action.Action;
import crl.cuts.Unleasher;
import crl.game.Game;
import crl.level.Level;
import crl.npc.NPC;
import crl.ui.Display;
import crl.ui.UserAction;
import crl.ui.UserInterface;
import crl.ui.effects.EffectFactory;

public class Vindelith2 extends Unleasher {

	public void unleash(Level level, Game game) {
		//if (level.getFlag("VINDELITHMEETING")&& level.getCounter("COUNTBACK_VINDELITHMEETING").isOver()){
			Display.thus.showChat("VINDELITH1", game);
			NPC claw = level.getNPCByID("UNIDED_CLAW");
			NPC vind = level.getNPCByID("UNIDED_VINDELITH");
			level.addEffect(EffectFactory.getSingleton().createDirectionalEffect(claw.getPosition(), Action.RIGHT, 1, "SFX_WP_BASELARD"));
			level.addEffect(EffectFactory.getSingleton().createDirectionalEffect(vind.getPosition(), Action.LEFT, 2, "SFX_WP_BASELARD"));
			level.addEffect(EffectFactory.getSingleton().createDirectionalEffect(claw.getPosition(), Action.RIGHT, 1, "SFX_WP_BASELARD"));
			level.addEffect(EffectFactory.getSingleton().createDirectionalEffect(vind.getPosition(), Action.LEFT, 2, "SFX_WP_BASELARD"));
			level.addEffect(EffectFactory.getSingleton().createDirectionalEffect(claw.getPosition(), Action.RIGHT, 1, "SFX_WP_BASELARD"));
			Display.thus.showChat("VINDELITH2", game);
			level.removeMonster(level.getNPCByID("UNIDED_VINDELITH"));
			level.removeMonster(claw);
			UserInterface.getUI().refresh();
			enabled = false;
		//}
	}

}
