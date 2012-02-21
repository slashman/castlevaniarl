package crl.ui.graphicsUI.effects;

import java.awt.Image;

import sz.csi.ConsoleSystemInterface;
import sz.util.Position;
import crl.ui.UserInterface;
import crl.ui.consoleUI.ConsoleUserInterface;
import crl.ui.consoleUI.effects.CharDirectedEffect;
import crl.ui.graphicsUI.GFXUserInterface;
import crl.ui.graphicsUI.SwingSystemInterface;

public class GFXBeamEffect extends GFXDirectedEffect {
	private Image [] missile;
	
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
				break;
			si.drawImage(toPrint.x()*32, toPrint.y()*32-4*height, missile[too]);
			si.refresh();
			animationPause();
		}
		si.restore();
	}

	public GFXBeamEffect(String ID, Image[] missile, int delay){
		super(ID);
		setMissile(missile);
		setAnimationDelay(delay);
		
	}

	public void setMissile(Image[] value) {
		missile = value;
	}
	
}