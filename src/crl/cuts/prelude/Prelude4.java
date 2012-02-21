package crl.cuts.prelude;

import sz.util.Position;
import crl.ai.SelectorFactory;
import crl.ai.monster.boss.DraculaAI;
import crl.conf.console.data.CharCuts;
import crl.cuts.Unleasher;
import crl.game.Game;
import crl.game.STMusicManagerNew;
import crl.level.Level;
import crl.ui.Display;

public class Prelude4 extends Unleasher {

	public void unleash(Level level, Game game) {
		if (!level.getFlag("CHRIS_DEAD") || Position.distance(level.getMonsterByID("PRELUDE_DRACULA").getPosition(), game.getPlayer().getPosition()) > 5)
			return;
		Display.thus.showChat("PRELUDE_DRACULA2", game);
		STMusicManagerNew.thus.playKey("CHRIS_DEAD");
		level.setMusicKeyMorning("CHRIS_DEAD");
		((DraculaAI)level.getMonsterByID("PRELUDE_DRACULA").getSelector()).setOnBattle(true);
		enabled = false;
	}

}
