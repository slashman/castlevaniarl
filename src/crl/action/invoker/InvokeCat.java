package crl.action.invoker;

public class InvokeCat extends SummonSkill{
	public int getHeartCost() {
		return 5;
	}
	
	public String getID() {
		return "Invoke Cat";
	}
	
	public String getMonsterID() {
		return "S_CAT";
	}
	
	public String getSFX(){
		return "wav/kitty.wav";
	}
	
	public int getHitBonus() {
		return 2*getPlayer().getSoulPower();
	}
}
