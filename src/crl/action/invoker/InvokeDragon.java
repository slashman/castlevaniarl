package crl.action.invoker;

public class InvokeDragon extends SummonSkill{
	public int getHeartCost() {
		return 8;
	}
	
	public String getID() {
		return "Invoke Dragon";
	}
	
	public String getMonsterID() {
		return "S_DRAGON";
	}
	
	public int getHitBonus() {
		return 5*getPlayer().getSoulPower();
	}
}
