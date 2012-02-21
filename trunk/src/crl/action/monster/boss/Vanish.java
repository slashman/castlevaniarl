package crl.action.monster.boss;

import crl.action.Action;
import crl.level.Level;
import crl.monster.Monster;
import crl.ui.effects.EffectFactory;

public class Vanish extends Action{
	public String getID(){
		return "VANISH";
	}
	
	public void execute(){
        Level aLevel = performer.getLevel();
        aLevel.addMessage("Dracula disappears!");
        Monster mon = (Monster)performer;
        mon.setVisible(false);
        //drawEffect(new SplashEffect(performer.getPosition(), ".oO", Appearance.WHITE));
        drawEffect(EffectFactory.getSingleton().createLocatedEffect(performer.getPosition(), "SFX_VANISH"));
        mon.setPosition(0,0,0);
	}
}