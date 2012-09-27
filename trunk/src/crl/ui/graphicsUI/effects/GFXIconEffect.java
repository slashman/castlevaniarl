package crl.ui.graphicsUI.effects;

import java.awt.Image;

import sz.util.Position;
import crl.conf.gfx.data.GFXConfiguration;
import crl.ui.graphicsUI.GFXUserInterface;
import crl.ui.graphicsUI.SwingSystemInterface;

public class GFXIconEffect extends GFXEffect{
	private Image tile;

    public GFXIconEffect(String ID, Image tile, int delay, GFXConfiguration configuration){
    	super(ID, configuration);
		this.tile = tile;
		setAnimationDelay(delay);
    }

	public void drawEffect(GFXUserInterface ui, SwingSystemInterface si){
		si.saveBuffer();
		//si.setAutoRefresh(false);
		int height = 0;
		if (ui.getPlayer().getLevel().getMapCell(getPosition()) != null)
			height = ui.getPlayer().getLevel().getMapCell(getPosition()).getHeight();
		Position relative = Position.subs(getPosition(), ui.getPlayer().getPosition());
		Position center = Position.add(ui.PC_POS, relative);
		if (ui.insideViewPort(center))
			si.drawImage(center.x*configuration.getNormalTileWidth(), 
					     center.y*configuration.getNormalTileWidth()-4*height, tile);
		si.refresh();
		animationPause();
		si.restore();
	}
}