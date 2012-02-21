package crl.action.vkiller;

import sz.util.Position;
import crl.action.HeartAction;
import crl.level.Level;
import crl.monster.VMonster;
import crl.player.Player;
import crl.ui.effects.EffectFactory;

public class SoulBlast extends HeartAction{
	
	public String getID(){
		return "Soul Flame";
	}
	
	public int getHeartCost() {
		return 20;
	}
	
	public void execute(){
		super.execute();
        Level aLevel = performer.getLevel();
        aLevel.addMessage("Soul Blast!");
        int damage = 50 + aLevel.getPlayer().getShotLevel()*2 + aLevel.getPlayer().getSoulPower()*3;
		Position blastPosition = performer.getPosition();
		aLevel.addEffect(EffectFactory.getSingleton().createLocatedEffect(blastPosition, "SFX_SOUL_BLAST"));
		
		VMonster monsters = aLevel.getMonsters();
		for (int i = 0; i < monsters.size(); i++){
			if (monsters.elementAt(i).getPosition().z == performer.getPosition().z && Position.distance(monsters.elementAt(i).getPosition(), performer.getPosition()) < 5){
				StringBuffer buff = new StringBuffer();
				if (monsters.elementAt(i).wasSeen()) {
					buff.append("The "+monsters.elementAt(i).getDescription()+" is hit by the holy blast!");
				}
				monsters.elementAt(i).damage(buff, damage);
				aLevel.addMessage(buff.toString());
			}
		}

	}

	public String getPromptoPosition(){
		return "Where do you want to throw the vial?";
	}
	public int getCost(){
		Player p = (Player) performer;
		return (int)(25 / (p.getShotLevel()+1));
	}
	
}