package crl.levelgen;

import java.util.*;

import sz.util.*;
import crl.player.*;
import crl.level.*;
import crl.monster.*;
import crl.game.*;
import crl.feature.*;


public class PatternGenerator extends LevelGenerator{
	private static PatternGenerator singleton = new PatternGenerator();

	private Hashtable charMap;
	private Vector assignedFeatures = new Vector();
	private LevelFeature baseFeature;
	private boolean hasBoss;

	public void resetFeatures(){
		assignedFeatures.removeAllElements();
		baseFeature = null;
		hasBoss = false;
	}

	public void assignFeature(LevelFeature lf, Position where){
		assignedFeatures.add(new AssignedFeature(where, lf));
	}

	//private Position startPosition, endPosition;

	private Feature endFeature;

	public static PatternGenerator getGenerator(){
		return singleton;
    }

	public Level createLevel() throws CRLException{
		Debug.enterMethod(this, "createLevel");
		//draw the base feature
		StaticGenerator sg = StaticGenerator.getGenerator();
		sg.reset();
		sg.setCharMap(charMap);
		//sg.setFlatLevel(baseFeature.getALayout());
		sg.setLevel(baseFeature.getALayout());
		Level ret = sg.createLevel();
		
		Cell[][][] cmap = ret.getCells();
		Enumeration en = assignedFeatures.elements();
		while (en.hasMoreElements()){
			AssignedFeature af = (AssignedFeature) en.nextElement();
			drawFeature (af.getFeature(), af.getPosition(), ret);
		}

		ret.setCells(cmap);
		
		//ret.setPositions(startPosition, endPosition);
		if (!hasBoss){
			int keysOnLevel = placeKeys(ret);
			if (endFeature != null)
				endFeature.setKeyCost(keysOnLevel);
		} else
			if (endFeature != null)
				endFeature.setKeyCost(1);
		Debug.exitMethod(ret);
		return ret;
	}
	

	protected void drawFeature(LevelFeature what, Position where, Level level){
		Cell[][][] canvas = level.getCells();
		String [][] map = what.getALayout();
		for (int z = 0; z < map.length; z++)
			for (int y=0; y < map[0].length; y++){
				for (int x = 0; x < map[0][0].length(); x++) {
					if (map[z][y].charAt(x) == ' ')
						continue;
 					//Debug.say(map[z][y].charAt(x));
					String[] cmds = ((String)charMap.get(map[z][y].charAt(x)+"")).split(" ");
					if (!cmds[0].equals("NOTHING"))
						try {
							canvas[where.z+z][x+where.x][y+where.y] = MapCellFactory.getMapCellFactory().getMapCell(cmds[0]);
						} catch (CRLException crle){
							Debug.byebye("Exception creating the level "+crle);
						}
					if (cmds.length > 1){
						if (cmds[1].equals("FEATURE")){
							if (cmds.length < 4 || Util.chance(Integer.parseInt(cmds[3]))){
								Feature vFeature = FeatureFactory.getFactory().buildFeature(cmds[2]);
								vFeature.setPosition(x+where.x,y+where.y,where.z+z);
								if (cmds.length > 4){
									//Debug.say("Hi... i will set the cost");
									if (cmds[4].equals("COST")) {
										//Debug.say("Hi... i did it to "+vFeature);
										vFeature.setKeyCost(Integer.parseInt(cmds[5]));
									}
								}
								level.addFeature(vFeature);
							}

						} else
						if (cmds[1].equals("COST")){
							canvas[where.z+z][x+where.x][y+where.y].setKeyCost(Integer.parseInt(cmds[2]));
						} else
						if (cmds[1].equals("REMOVE_FEATURE")){
							level.destroyFeature(level.getFeatureAt(new Position(where.x+x, where.y+y, where.z+z)));
							
						} else
						if (cmds[1].equals("MONSTER")){
							Monster toAdd = MonsterFactory.getFactory().buildMonster(cmds[2]);
							toAdd.setPosition(x+where.x,y+where.y,z+where.z);
							level.addMonster(toAdd);
						} else
						if (cmds[1].equals("EXIT")){
							level.addExit(new Position(x+where.x,y+where.y,z+where.z), cmds[2]);
						} else
						if (cmds[1].equals("EOL")){
							level.addExit(new Position(x+where.x,y+where.y,z+where.z), "_NEXT");
							endFeature = FeatureFactory.getFactory().buildFeature(cmds[2]);
							endFeature.setPosition(x+where.x,y+where.y,where.z+z);
							if (cmds.length > 3){
								//Debug.say("Hi... i will set the cost");
								if (cmds[3].equals("COST")) {
									//Debug.say("Hi... i did it to "+vFeature);
									endFeature.setKeyCost(Integer.parseInt(cmds[4]));
								}
							}
							level.addFeature(endFeature);
						}
					}
				}
			}
	}

	public void setCharMap(Hashtable value) {
		charMap = value;
	}

	public void setBaseFeature(LevelFeature value) {
		baseFeature = value;
	}

	public boolean hasBoss() {
		return hasBoss;
	}

	public void setHasBoss(boolean hasBoss) {
		this.hasBoss = hasBoss;
	}
}