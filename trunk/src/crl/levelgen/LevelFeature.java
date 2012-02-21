package crl.levelgen;

import sz.util.*;

import java.util.*;
import crl.*;

public class LevelFeature {
	//private Vector subFeatures; //Class AssignedFeature
	private Dimension size;

	private Vector layouts = new Vector(); // Class String[]

/*	public void draw(Position where, Level canvas){
		//Draw all its subfeatures  in position wh
		/*Enumeration subf = subFeatures.elements();
		while (subf.hasMoreElements()){
			AssignedFeature af	= (AssignedFeature) subf.nextElement();
			af.getFeature().draw(Position.add(af.getPosition(), where), canvas);
		} */

		//pick a layout and draw it into the level
	/*	if (layouts.size() > 0){
			int useLayout = Util.rand(0, layouts.size());
			int[][] map = (int[][])layouts.elementAt(useLayout);
			Cell[][] cmap = canvas.getCells();
			int xrun = where.x;
			int yrun = where.y;
			for (int x = 0; x < map.length; x++)
				for (int y = 0; y < map[0].length; y++)
					try {
				    	cmap[xrun+x][yrun+y] = MapCellFactory.getMapCellFactory().getMapCell(descriptions[map[y][x]]);
				    }	catch (CRLException crle){
						Debug.byebye("Exception creating the level"+crle);
					}
		}
	}

/*	public Vector getSubFeatures() {
		return subFeatures;
	}

	public void setSubFeatures(Vector value) {
		subFeatures = value;
	}            */

	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension value) {
		size = value;
	}

	public void addLayout(String[][] value) {
		//Debug.say(this+" adding a layout");
		layouts.add(value);
	}

	public void addLayout(String[] value){
		addLayout(new String[][] {value});
	}

	public final static String [] descriptions = new String [] {
    	"COURTYARDGRASS",
		"COURTYARDDIRT",
		"BRICKWALKWAY",
		"COURTYARDDOOR",
		"COURTYARDWALL",
		"CASTLEWALL",
		"GARGOYLESTATUE",
		"HUMANSTATUE",
		"DARKTREE",
		"DEADSTUMP",
		"TORCH",
		"FENCE",
		"CASTLEDOOR",
		"FOUNTAINCENTER",
		"FOUNTAINAROUND",
		"FOUNTAINPOOL",
		"STREAM"
	};

	public String [][] getALayout(){

		return (String[][])layouts.elementAt(Util.rand(0, layouts.size()-1));
	}
}