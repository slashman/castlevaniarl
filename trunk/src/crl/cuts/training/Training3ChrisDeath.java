package crl.cuts.training;

import crl.cuts.Unleasher;
import crl.game.Game;
import crl.level.Level;
import crl.npc.NPC;
import crl.player.Player;
import crl.ui.Display;

public class Training3ChrisDeath extends Unleasher {
	public void unleash(Level level, Game game){
		NPC chris = level.getNPCByID("CHRISTRAIN");
		if (chris == null || chris.isDead()){
			Display.thus.showScreen("What kind of Belmont are you? in a state of madness you betrayed your father and killed him, just to steal the vampire killer whip... Your conscience will haunt you for eternity");
			level.getPlayer().setPlayerClass(Player.CLASS_VAMPIREKILLER);
			level.getPlayer().setWeapon(Player.VAMPIRE_WHIP);
			level.getPlayer().setFlag("ONLY_VK", true);
			enabled = false;
		}
	}
}
