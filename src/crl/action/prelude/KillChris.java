package crl.action.prelude;

import sz.util.Position;
import crl.action.Action;
import crl.level.Level;
import crl.monster.Monster;
import crl.player.Player;
import crl.ui.effects.EffectFactory;

public class KillChris extends Action{
	private int range;
	private String message;
	private String effectType;
	private String effectString;
	
	public String getID(){
		return "PRELUDE_KILL_CHRIS";
	}
	
	public void execute(){
		
		Monster aMonster = (Monster) performer;
        Level aLevel = performer.getLevel();
        Player aPlayer = aLevel.getPlayer();
        aLevel.addMessage("Dracula invokes a deadly beam of chaos energy!!!");
        drawEffect(EffectFactory.getSingleton().createLocatedEffect(new Position(aPlayer.getPosition().x, aPlayer.getPosition().y), "SFX_KILL_CHRIS"));
	}
	

	public int getCost(){
		return 50;
	}

}