package crl.monster;

import java.util.*;

import crl.level.Level;
import crl.levelgen.MonsterSpawnInfo;
import crl.ui.AppearanceFactory;

import sz.util.*;

public class MonsterFactory {
	private final static MonsterFactory singleton = new MonsterFactory();

	private Hashtable definitions;
	private Vector vDefinitions = new Vector(50);

	public static MonsterFactory getFactory(){
		return singleton;
	}

	public Monster buildMonster (String id){
		return new Monster((MonsterDefinition) definitions.get(id));
	}

	public MonsterDefinition getDefinition (String id){
		return (MonsterDefinition) definitions.get(id);
	}

	/*public void addDefinition(MonsterDefinition definition){
		definitions.put(definition.getID(), definition);
	}*/

	public MonsterFactory(){
		definitions = new Hashtable(40);
	}
	
	public void init(MonsterDefinition[] defs) {
		for (int i = 0; i < defs.length; i++){
			defs[i].setAppearance(AppearanceFactory.getAppearanceFactory().getAppearance(defs[i].getID()));
			definitions.put(defs[i].getID(), defs[i]);
			vDefinitions.add(defs[i]);
			
		}
	}
	
	private int lastSpawnLocation;
	
	public int getLastSpawnPosition(){
		return lastSpawnLocation;
	}
	public Monster getMonsterForLevel(Level level){
		MonsterSpawnInfo[] spawnIDs = level.getSpawnInfo();
		if (spawnIDs == null || spawnIDs.length == 0)
			return null;
		while (true){
			int rand = Util.rand(0, spawnIDs.length-1);
			if (Util.chance(spawnIDs[rand].getFrequency())){
				lastSpawnLocation = spawnIDs[rand].getSpawnLocation();
				return new Monster((MonsterDefinition)definitions.get(spawnIDs[rand].getMonsterID()));
			}
		}
	}

	public void printAppearances(){
		Enumeration x = definitions.keys();
		while (x.hasMoreElements()){
			MonsterDefinition d = (MonsterDefinition) definitions.get(x.nextElement());
			Debug.say("Monstero "+ d.getDescription()+" app "+d.getAppearance());
		}
	}
}