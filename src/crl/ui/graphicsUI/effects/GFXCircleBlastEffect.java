package crl.ui.graphicsUI.effects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

import sz.util.Position;
import crl.conf.gfx.data.GFXConfiguration;
import crl.ui.graphicsUI.GFXUserInterface;
import crl.ui.graphicsUI.SwingSystemInterface;

public class GFXCircleBlastEffect extends GFXEffect{
	private Color blastColor;
	private int ADVANCE = 9;

    public GFXCircleBlastEffect(String ID, Color blastColor, int delay, GFXConfiguration configuration){
    	super(ID, delay, configuration);
    	this.blastColor = blastColor;
    }
    
	public void drawEffect(GFXUserInterface ui, SwingSystemInterface si){
		ui.refresh();
		si.saveBuffer();
		Position relative = Position.subs(getPosition(), ui.getPlayer().getPosition());
		Position center = Position.add(ui.PC_POS, relative);
		Graphics2D g = si.getGraphics2D();
		Stroke oldStroke = g.getStroke();
		g.setStroke(new BasicStroke(10));
		g.setColor(blastColor);
		int xcenter = center.x * this.configuration.getNormalTileWidth() + this.configuration.getHalfTileWidth();
		int ycenter = center.y * this.configuration.getNormalTileWidth() + this.configuration.getHalfTileWidth();
		for (int i = 0; i < 30; i++){
			g.fillOval(xcenter-i*(ADVANCE+i), ycenter-i*(ADVANCE+i),i*(ADVANCE+i)*2,i*(ADVANCE+i)*2);
			si.refresh();
			animationPause();
			//si.restore();
		}
		g.setStroke(oldStroke);
		si.cls();
		si.restore();
		si.refresh();
	}
}