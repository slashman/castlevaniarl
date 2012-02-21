package crl.levelgen.patterns;

import java.util.Hashtable;

import crl.cuts.Unleasher;
import crl.levelgen.MonsterSpawnInfo;
import crl.levelgen.StaticGenerator;

public abstract class StaticPattern {
	protected Hashtable charMap = new Hashtable();;
	protected String[][] cellMap;
	protected Hashtable inhabitantsMap = new Hashtable();;
	protected String[][] inhabitants;
	protected MonsterSpawnInfo [] spawnInfo;
	protected Unleasher[] unleashers;
	
	public boolean isRutinary(){
		return false;
	}
	
	public Hashtable getCharMap(){
		return charMap;
	}
	
	public String[][] getCellMap(){
		return cellMap;
	}
	
	public Hashtable getInhabitantsMap(){
		return inhabitantsMap;
	}
	public String[][] getInhabitants(){
		return inhabitants;
	}
	public MonsterSpawnInfo[] getDwellers(){
		return null;
	}
	
	public abstract String getDescription();
	public abstract String getMusicKeyMorning();
	public abstract String getMusicKeyNoon();
	public abstract String getMapKey();
	
	public boolean isHaunted() {
		return false;
	}
	
	public String getBoss(){
		return null;
	}
	
	public sz.util.Position getBossPosition(){
		return null;
	}
	
	public MonsterSpawnInfo[] getSpawnInfo(){
		return spawnInfo;
	}
	
	public boolean isHostageSafe(){
		return false;
	}
	
	public void setup(StaticGenerator gen){
		gen.reset();
		gen.setCharMap(getCharMap());
		gen.setLevel(getCellMap());
		gen.setInhabitantsMap(getInhabitantsMap());
		gen.setInhabitants(getInhabitants());
	}
	
	public Unleasher[] getUnleashers(){
		return unleashers;
	}
}
