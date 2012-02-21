package crl.ui.graphicsUI.effects;

import java.awt.Color;

import crl.ui.graphicsUI.GFXUserInterface;
import crl.ui.graphicsUI.SwingSystemInterface;

public class GFXFlashEffect extends GFXEffect{
	private Color color;

    public GFXFlashEffect(String ID, Color color){
    	super (ID);
    	this.color = color;
    }

	public void drawEffect(GFXUserInterface ui, SwingSystemInterface si){
		si.flash(color);
		//animationPause();
	}

}