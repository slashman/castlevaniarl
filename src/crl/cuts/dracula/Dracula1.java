package crl.cuts.dracula;

import sz.util.Position;
import crl.ai.monster.boss.DraculaAI;
import crl.conf.console.data.CharCuts;
import crl.cuts.Unleasher;
import crl.game.Game;
import crl.game.STMusicManagerNew;
import crl.level.Level;
import crl.monster.Monster;
import crl.ui.AppearanceFactory;
import crl.ui.Display;

public class Dracula1 extends Unleasher {

	public void unleash(Level level, Game game) {
		Monster dracula = level.getMonsterByID("DRACULA");
		int distance = Position.distance(dracula.getPosition(), game.getPlayer().getPosition()); 
		if (distance > 3 && !((DraculaAI)dracula.getSelector()).isOnBattle())
			return;
		Display.thus.showChat("DRACULA1", game);
		level.getMapCell(level.getExitFor("#DRACPOS")).setAppearance(AppearanceFactory.getAppearanceFactory().getAppearance("DRACULA_THRONE2_X"));
		((DraculaAI)dracula.getSelector()).setOnBattle(true);
		dracula.setVisible(true);
		level.setMusicKeyMorning("DRACULA");
		STMusicManagerNew.thus.playKey("DRACULA");
		enabled = false;
	}

}
