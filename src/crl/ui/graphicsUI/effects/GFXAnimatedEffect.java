package crl.ui.graphicsUI.effects;

import java.awt.Image;

import sz.util.Position;
import crl.conf.gfx.data.GFXConfiguration;
import crl.ui.graphicsUI.GFXUserInterface;
import crl.ui.graphicsUI.SwingSystemInterface;

public class GFXAnimatedEffect extends GFXEffect{
	private Image[] frames;
	
	private int xoff, yoff;
	
	public GFXAnimatedEffect(String ID, Image[] frames, int delay, GFXConfiguration configuration){
		super (ID, delay, configuration);
		this.frames = frames;
	}
	
	public GFXAnimatedEffect(String ID, Image[] frames, int delay, int xoff, int yoff, GFXConfiguration configuration){
		this (ID, frames, delay, configuration);
		this.xoff = xoff;
		this.yoff = yoff;
	}

	public void drawEffect(GFXUserInterface ui, SwingSystemInterface si){
		int height = 0;
		if (ui.getPlayer().getLevel().getMapCell(getPosition()) != null)
			height = ui.getPlayer().getLevel().getMapCell(getPosition()).getHeight();
		Position relative = Position.subs(getPosition(), ui.getPlayer().getPosition());
		Position absolute = Position.add(ui.PC_POS, relative);
		if (!ui.insideViewPort(absolute))
			return;
		si.saveBuffer();
		for (int j = 0; j<frames.length; j++){
			si.drawImage(absolute.x*configuration.getNormalTileWidth()+xoff, 
					     absolute.y*configuration.getNormalTileWidth()-4*height+yoff, frames[j]);
			si.refresh();
			animationPause();
			si.restore();
		}
	}
}
