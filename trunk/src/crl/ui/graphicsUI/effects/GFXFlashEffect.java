package crl.ui.graphicsUI.effects;

import java.awt.Color;

import crl.conf.gfx.data.GFXConfiguration;
import crl.ui.graphicsUI.GFXUserInterface;
import crl.ui.graphicsUI.SwingSystemInterface;

public class GFXFlashEffect extends GFXEffect{
	private Color color;

    public GFXFlashEffect(String ID, Color color, GFXConfiguration configuration){
    	super (ID, configuration);
    	this.color = color;
    }

	public void drawEffect(GFXUserInterface ui, SwingSystemInterface si){
		si.flash(color);
		//animationPause();
	}

}