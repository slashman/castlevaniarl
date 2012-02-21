package crl.ai.monster;

import crl.action.monster.MonsterMissile;

public class RangedAttack implements java.io.Serializable{
	private String attackId;
	private String attackType;
	private int range;
	private int frequency;
	private String attackMessage;
	private String effectType;
	private String effectID;
	private String summonMonsterId;
	private String effectWav;
	private int chargeCounter;
	private String statusEffect;
	private int damage;
	
	public RangedAttack(String pAttackId, String pAttackType, String pStatusEffect, int pRange, int pFrequency, String pAttackMessage, String pEffectType, String pEffectString, int pDamage){
		attackId = pAttackId;
		attackType = pAttackType;
		if (attackType == null)
			attackType = MonsterMissile.TYPE_STRAIGHT;
		statusEffect = pStatusEffect;
		range = pRange;
		frequency = pFrequency;
		attackMessage = pAttackMessage;
		effectType = pEffectType;
		effectID = pEffectString;
		damage = pDamage;
	}

	public void setEffectWav(String value){
		effectWav =  value;
	}
	
	public String getEffectWav(){
		return effectWav;
	}
	
	public String getAttackId() {
		return attackId;
	}
	
	public String getAttackType(){
		return attackType;
	}
	
	public String getStatusEffect(){
		return statusEffect;
	}

	public int getRange() {
		return range;
	}

	public int getFrequency() {
		return frequency;
	}

	public String getAttackMessage() {
		return attackMessage;
	}

	public String getEffectID() {
		return effectID;
	}

	public String getEffectType() {
		return effectType;
	}

	public String getSummonMonsterId() {
		return summonMonsterId;
	}

	public void setSummonMonsterId(String summonMonsterId) {
		this.summonMonsterId = summonMonsterId;
	}

	public int getChargeCounter() {
		return chargeCounter;
	}

	public void setChargeCounter(int chargeCounter) {
		this.chargeCounter = chargeCounter;
	}
	
	public int getDamage(){
		return damage;
	}
}

