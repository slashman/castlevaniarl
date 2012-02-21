package crl.ui.graphicsUI.effects;

import java.awt.Image;

import sz.util.Position;
import crl.ui.UserInterface;
import crl.ui.graphicsUI.GFXUserInterface;
import crl.ui.graphicsUI.SwingSystemInterface;

public class GFXSplashEffect extends GFXEffect{
	private Image[] tiles;

	//private transient SwingSystemInterface si;
	

    public GFXSplashEffect(String ID, Image[] tiles, int delay){
    	super(ID,delay);
		this.tiles = tiles;
    }
    
	public void drawEffect(GFXUserInterface ui, SwingSystemInterface si){
		si.saveBuffer();
		//ui.refresh();
		Position relative = Position.subs(getPosition(), ui.getPlayer().getPosition());
		Position center = Position.add(ui.PC_POS, relative);
		int height = 0;
		if (ui.getPlayer().getLevel().getMapCell(getPosition()) != null)
			height = ui.getPlayer().getLevel().getMapCell(getPosition()).getHeight();
		si.drawImage(center.x*32, center.y*32, tiles[0]);

		for (int ring = 1; ring < tiles.length; ring++){
			drawCircle(ui, si, center, ring, tiles[ring],height);
			si.refresh();
			animationPause();
		}
		/*si.cls();
		ui.refresh();*/
	}

	private void drawCircle(GFXUserInterface ui, SwingSystemInterface si, Position p, int radius, Image tile, int height){
		int d = 3 - (2 * radius);
		Position runner = new Position(0, radius);
		Position zero = new Position(0,0);
		while (true) {
			if (Position.flatDistance(zero, runner) <= radius)
				drawCirclePixels(ui, si, p, runner.x,runner.y, tile,height);
			if (d < 0)
				d = d + (4*runner.x)+6;
			else {
				
				
				
				//d = d + 4 * (x-y) + 10;
				d = d + 4 * (runner.x-runner.y) +10;
				runner.y --;
			}
			runner.x++;
			if (runner.y == 0)
				break;
		}
		
	}


	private void drawCirclePixels(GFXUserInterface ui, SwingSystemInterface si, Position center, int x, int y, Image tile, int height){
		if (ui.insideViewPort(center.x+x, center.y + y))
			si.drawImage((center.x + x)*32, (center.y + y)*32-4*height, tile);
		if (ui.insideViewPort(center.x+x, center.y - y))
			si.drawImage((center.x + x)*32, (center.y - y)*32-4*height, tile);
		if (ui.insideViewPort(center.x-x, center.y + y))
			si.drawImage((center.x - x)*32, (center.y + y)*32-4*height, tile);
		if (ui.insideViewPort(center.x-x, center.y - y))
			si.drawImage((center.x - x)*32, (center.y - y)*32-4*height, tile);
		if (ui.insideViewPort(center.x+y, center.y + x))
			si.drawImage((center.x + y)*32, (center.y + x)*32-4*height, tile);
		if (ui.insideViewPort(center.x+y, center.y - x))
			si.drawImage((center.x + y)*32, (center.y - x)*32-4*height, tile);
		if (ui.insideViewPort(center.x-y, center.y + x))
			si.drawImage((center.x - y)*32, (center.y + x)*32-4*height, tile);
		if (ui.insideViewPort(center.x-y, center.y - x))
			si.drawImage((center.x - y)*32, (center.y - x)*32-4*height, tile);
	}
}