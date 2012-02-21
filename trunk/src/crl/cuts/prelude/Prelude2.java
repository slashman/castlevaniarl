package crl.cuts.prelude;

import sz.util.Position;
import crl.ai.SelectorFactory;
import crl.ai.monster.boss.DraculaAI;
import crl.conf.console.data.CharCuts;
import crl.cuts.Unleasher;
import crl.game.Game;
import crl.level.Level;
import crl.monster.Monster;
import crl.ui.Appearance;
import crl.ui.AppearanceFactory;
import crl.ui.Display;

public class Prelude2 extends Unleasher {

	public void unleash(Level level, Game game) {
		Monster dracula = level.getMonsterByID("PRELUDE_DRACULA");
		int distance = Position.distance(dracula.getPosition(), game.getPlayer().getPosition()); 
		if (distance > 3 && !((DraculaAI)dracula.getSelector()).isOnBattle())
			return;
		Display.thus.showChat("PRELUDE_DRACULA1", game);
		level.getMapCell(level.getExitFor("#DRACPOS")).setAppearance(AppearanceFactory.getAppearanceFactory().getAppearance("DRACULA_THRONE2_X"));
		((DraculaAI)dracula.getSelector()).setOnBattle(true);
		dracula.setVisible(true);
		enabled = false;
	}

}
