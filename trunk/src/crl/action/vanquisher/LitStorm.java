package crl.action.vanquisher;

import sz.util.Position;
import crl.action.Action;
import crl.action.HeartAction;
import crl.actor.Actor;
import crl.level.Level;
import crl.monster.Monster;
import crl.monster.VMonster;
import crl.player.Player;
import crl.ui.effects.EffectFactory;

public class LitStorm extends HeartAction{
	public int getHeartCost() {
		return 10;
	}
	public String getID(){
		return "LitStorm";
	}
	
	public void execute(){
		super.execute();
		Level aLevel = performer.getLevel();
        Player aPlayer = aLevel.getPlayer();
		aLevel.addMessage("You invoke the spell of lighting!");

		for (int i = 0; i < 3; i++){
			Monster nearestMonster = aPlayer.getNearestMonster();
			if (nearestMonster == null || Position.flatDistance(nearestMonster.getPosition(), aPlayer.getPosition())>10){
			} else {
				StringBuffer buff = new StringBuffer();
				if (nearestMonster.wasSeen())
					buff.append("Lighting zaps the "+nearestMonster.getDescription()+"!");
				nearestMonster.damage(buff, 5+aPlayer.getSoulPower()*2);
				aLevel.addMessage(buff.toString());
				drawEffect(EffectFactory.getSingleton().createDirectedEffect(aPlayer.getPosition(), nearestMonster.getPosition(), "SFX_LIT_SPELL", Position.flatDistance(performer.getPosition(), nearestMonster.getPosition())));
				
			}
		}
	}

	public int getCost(){
		Player p = (Player) performer;
		return (int)(p.getCastCost() * 1.5);
	}
	

	
}