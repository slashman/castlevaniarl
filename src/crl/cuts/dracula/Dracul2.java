package crl.cuts.dracula;

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
import crl.ui.UserInterface;

public class Dracul2 extends Unleasher{

	public void unleash(Level level, Game game) {
		Monster dracula = level.getMonsterByID("DRACULA");
		if (dracula != null)
			return;
		Display.thus.showChat("DRACULA2", game);
		Player player = level.getPlayer();
		player.informPlayerEvent(Player.EVT_GOTO_LEVEL, "VOID0");
		player.see();
		UserInterface.getUI().refresh();
		player.setPosition(new Position(player.getLevel().getExitFor("#START")));
		enabled = false;
	}
}