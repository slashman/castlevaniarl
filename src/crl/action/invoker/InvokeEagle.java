package crl.action.invoker;

public class InvokeEagle extends SummonSkill{
	public int getHeartCost() {
		return 5;
	}
	
	public String getID() {
		return "Invoke Eagle";
	}
	
	public String getMonsterID() {
		return "S_EAGLE";
	}
	
	public int getHitBonus() {
		return 3*getPlayer().getSoulPower();
	}
}
