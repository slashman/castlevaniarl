package crl.levelgen;

import java.io.Serializable;

public class MonsterSpawnInfo implements Serializable {
	private String monsterID;
	private int spawnLocation;
	private int frequency;

	public final static int UNDERGROUND = 0,
		BORDER = 1,
		WATER = 2;

	public MonsterSpawnInfo(String pMonsterID, int pSpawnLocation, int pFrequency){
		monsterID = pMonsterID;
		spawnLocation = pSpawnLocation;
		frequency = pFrequency;
	}

	public String getMonsterID() {
		return monsterID;
	}

	public int getSpawnLocation() {
		return spawnLocation;
	}

	public int getFrequency() {
		return frequency;
	}
}