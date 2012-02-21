package crl.game;

public class MonsterRecord {
	private String monsterID;
	private long killed, killers;
	public long getKilled() {
		return killed;
	}
	public void setKilled(long killed) {
		this.killed = killed;
	}
	public long getKillers() {
		return killers;
	}
	public void setKillers(long killers) {
		this.killers = killers;
	}
	public String getMonsterID() {
		return monsterID;
	}
	public void setMonsterID(String monsterID) {
		this.monsterID = monsterID;
	}
}
