package crl.action.invoker;

public class InvokeTurtle extends SummonSkill{
	public int getHeartCost() {
		return 5;
	}
	
	public String getID() {
		return "Invoke Turtle";
	}
	
	public String getMonsterID() {
		return "S_TURTLE";
	}
	
	public String getSFX(){
		return "wav/turtleCry.wav";
	}
	
	public int getHitBonus() {
		return 2*getPlayer().getSoulPower();
	}
}
