package crl.feature.action;

import crl.level.*;
import crl.action.*;

public class Shine extends Action{
	
	public String getID(){
		return "Shine";
	}
	
	private static Shine singleton = new Shine();

	public void execute(){
		//Level aLevel = performer.getLevel();
		//aLevel.addMessage("The holy flame glows!");
        //aLevel.addEffect(new StaticAnimEffect(performer.getPosition(), "\\|/|\\", Appearance.YELLOW));
        //aLevel.addEffect(new StaticAnimEffect(performer.getPosition(), "¤o¤o", Appearance.YELLOW));
	}

	public static Shine getAction(){
		return singleton;
	}
}