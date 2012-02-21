package crl.cuts.prelude;

import sz.util.Position;
import crl.action.ActionFactory;
import crl.ai.monster.boss.DraculaAI;
import crl.cuts.Unleasher;
import crl.game.Game;
import crl.game.PlayerGenerator;
import crl.level.Level;
import crl.monster.Monster;
import crl.player.Player;
import crl.ui.UserInterface;
import crl.ui.effects.EffectFactory;

public class Prelude3 extends Unleasher{

	public void unleash(Level level, Game game) {
		Monster dracula = level.getMonsterByID("PRELUDE_DRACULA"); 
		if (dracula.getHits () > dracula.getMaxHits()/2)
			return;
		
		level.addMessage("Dracula invokes a deadly beam of chaos energy!!!");
        level.addEffect(EffectFactory.getSingleton().createLocatedEffect(level.getPlayer().getPosition(), "SFX_KILL_CHRIS"));
        
		Player p = level.getPlayer();
		game.setPlayer(PlayerGenerator.thus.createSpecialPlayer("SOLIEYU"));
		level.removeActor(p);
		p.die();
		level.getPlayer().setPosition(level.getExitFor("_START"));
		level.getPlayer().see();
		UserInterface.getUI().refresh();
		level.setFlag("CHRIS_DEAD", true);
		((DraculaAI)level.getMonsterByID("PRELUDE_DRACULA").getSelector()).reset();
		dracula.setPosition(level.getExitFor("#DRACPOS"));
		dracula.setVisible(true);
		enabled = false;
	}
}
