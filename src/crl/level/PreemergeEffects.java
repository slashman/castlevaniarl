package crl.level;

import crl.action.*;
import crl.ui.*;
import crl.ui.effects.*;


public class PreemergeEffects extends Action{
	private static PreemergeEffects singleton = new PreemergeEffects();
	
	public String getID(){
		return "Preemerge";
	}

	public void execute(){
		Level aLevel = performer.getLevel();
		Emerger em = (Emerger) performer;
		//aLevel.addMessage("You see something crawling out of the soil!", em.getPoint());
        //aLevel.addEffect(new StaticAnimEffect(em.getPoint(), "^", Appearance.BROWN));
		
        drawEffect(EffectFactory.getSingleton().createLocatedEffect(em.getPoint(), "SFX_MONSTER_CRAWLING"));
	}

	public static PreemergeEffects getAction(){
		return singleton;
	}
}