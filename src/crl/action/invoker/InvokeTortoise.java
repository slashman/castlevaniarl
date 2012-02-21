package crl.action.invoker;

public class InvokeTortoise extends SummonSkill{
	public int getHeartCost() {
		return 5;
	}
	
	public String getID() {
		return "Invoke Tortoise";
	}
	
	public String getMonsterID() {
		return "S_TORTOISE";
	}

	public String getSFX(){
		return "wav/turtleCry.wav";
	}
	
	public int getHitBonus() {
		return 3*getPlayer().getSoulPower();
	}
}
