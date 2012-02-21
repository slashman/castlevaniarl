package crl.player;

import java.io.Serializable;

public class MonsterDeath implements Serializable{
	private String monsterDescription;
	private int times = 1;

	public MonsterDeath(String des){
		monsterDescription = des;
	}

	public void increaseDeaths(){
		times++;
	}

	public String getMonsterDescription() {
		return monsterDescription;
	}

	public void setMonsterDescription(String value) {
		monsterDescription = value;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int value) {
		times = value;
	}
}