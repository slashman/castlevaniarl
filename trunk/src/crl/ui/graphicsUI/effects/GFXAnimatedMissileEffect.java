package crl.ui.graphicsUI.effects;

import java.awt.Image;

import sz.util.Position;
import crl.conf.gfx.data.GFXConfiguration;
import crl.ui.graphicsUI.GFXUserInterface;
import crl.ui.graphicsUI.SwingSystemInterface;

public class GFXAnimatedMissileEffect extends GFXDirectedEffect{
	private Image[] missile;

	public void drawEffect(GFXUserInterface ui, SwingSystemInterface si){
		si.saveBuffer();
		int too = 0;
		
		for (int i = 0; i < depth; i++){
			Position next = effectLine.next();
			too++;
			if (too == missile.length)
				too = 0;
			int height = 0;
			if (ui.getPlayer().getLevel().getMapCell(next) != null)
				height = ui.getPlayer().getLevel().getMapCell(next).getHeight();
			Position relative = Position.subs(next, ui.getPlayer().getPosition());
			Position toPrint = Position.add(ui.PC_POS, relative);
			if (!ui.insideViewPort(toPrint))
				continue;
			si.drawImage(toPrint.x()*configuration.getNormalTileWidth(), 
					     toPrint.y()*configuration.getNormalTileWidth()-4*height, missile[too]);
			si.refresh();
			animationPause();
			si.restore();
			
		}
	}

	public GFXAnimatedMissileEffect(String id, Image[] missile, int delay, GFXConfiguration configuration){
		super(id,delay, configuration);
		setMissile(missile);
	}
	
	public void setMissile(Image[] value) {
		missile = value;
	}


}
