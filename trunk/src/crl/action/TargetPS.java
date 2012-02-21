package crl.action;

import sz.util.Position;
import sz.util.Util;
import crl.actor.Actor;
import crl.item.Item;
import crl.item.ItemDefinition;
import crl.monster.Monster;
import crl.player.Player;

public class TargetPS extends ProjectileSkill{
	private Player player;
	private Item weapon;
	private int reloadTime;
	public String getID(){
		return "Target";
	}

	
	public void execute(){
        player = null;
        reloadTime = 0;
		try {
			player = (Player) performer;
		} catch (ClassCastException cce){
			return;
		}
		weapon = player.getWeapon();
		
		ItemDefinition weaponDef = weapon.getDefinition();

		if (weapon.getReloadTurns() > 0)
			if (weapon.getRemainingTurnsToReload() == 0){
				/*
				aLevel.addMessage("You must reload the "+weapon.getDescription()+"!");
				return;*/
				if (!reload(weapon, player))
					return;
			}

		super.execute();
		
		if (weapon.getReloadTurns() > 0 &&
			weapon.getRemainingTurnsToReload() > 0)
			weapon.setRemainingTurnsToReload(weapon.getRemainingTurnsToReload()-1);
		if (weaponDef.isSingleUse()){
			if (weapon.getReloadTurns() > 0){
				if (weapon.getRemainingTurnsToReload() == 0) {
					player.setWeapon(null);
				}
			}else {
				if (player.hasItem(weapon))
					player.reduceQuantityOf(weapon);
				else
					player.setWeapon(null);
			}
		}
	}

	public String getPromptPosition(){
		return "Where do you want to attack?";
	}

	public Position getPosition(){
		return targetPosition;
	}

	public String getSFX(){
		Player p = (Player) performer;
		weapon = p.getWeapon();
		if (weapon != null && !weapon.getAttackSound().equals("DEFAULT")){
			return weapon.getAttackSound();
		} else {
			if (((Player)performer).getSex() == Player.MALE)
				return "wav/punch_male.wav";
			else
				return "wav/punch_female.wav";
		}
	}

	public int getCost(){
		return player.getAttackCost()+weapon.getAttackCost()+reloadTime;
	}
	
	private boolean reload(Item weapon, Player aPlayer){
		if (weapon != null){
			if (aPlayer.getGold() < weapon.getDefinition().getReloadCostGold()){
				aPlayer.getLevel().addMessage("You can't reload the " + weapon.getDescription());
				return false;
			}else if (aPlayer.getHearts() < 1){
				aPlayer.getLevel().addMessage("You can't reload the " + weapon.getDescription());
				return false;
			}
			else {
				weapon.reload();
				aPlayer.reduceGold(weapon.getDefinition().getReloadCostGold());
				aPlayer.reduceHearts(1);
				aPlayer.getLevel().addMessage("You reload the " + weapon.getDescription()+" ("+weapon.getDefinition().getReloadCostGold()+" gold)");
				reloadTime = 10*weapon.getDefinition().getReloadTurns();
				return true;
			}
		} else
			aPlayer.getLevel().addMessage("You can't reload yourself");
		return false;
	}
	
	public boolean canPerform(Actor a){
        player = null;
		try {
			player = (Player) a;
		} catch (ClassCastException cce){
			return false;
		}
		
		Item weapon = player.getWeapon();
		
		if (!player.canAttack()){
			invalidationMessage = "You can't attack!";
			return false;
		}

		if (weapon == null) {
			invalidationMessage = "It is useless to target your own blows...";
			return false;
		}
		
		if (weapon.getRange() < 2){
			invalidationMessage = "You can´t target your "+weapon.getDescription();
			return false;
		}
		
		if (player.getWeapon() != null && player.getWeapon().getWeaponCategory() == ItemDefinition.CAT_BOWS){
			Monster nearest = player.getNearestMonster();
			if (nearest != null){
				if (Position.flatDistance(nearest.getPosition(), player.getPosition()) < 2){
					invalidationMessage = "You can't aim your "+player.getWeapon().getDescription()+" this close to the enemy, get away!";
					return false;
				}
			}
		}

		return true;
	}
	


	public int getDamage() {
		return player.getWeaponAttack()+Util.rand(0,2);
	}
	
	public boolean isWeaponAttack(){
		return true;
	}

	public int getHit() {
		return 100;
	}


	public int getPathType() {
		if (weapon.getVerticalRange()>0)
			return PATH_DIRECT;
		else
			return PATH_LINEAR;
	}


	public int getRange() {
		return weapon.getDefinition().getRange();
	}

	public String getSelfTargettedMessage() {
		if (weapon.getRange() > 5)
			return "You fire your "+weapon.getDescription()+" upward";
		else
			return "You attack with your "+weapon.getDescription();
	}

	public String getSFXID() {
		return "SFX_WP_"+weapon.getDefinition().getID();
	}


	public String getShootMessage() {
		if (weapon.getRange() > 5)
			return "You fire your "+weapon.getDescription();
		else
			return "You attack with your "+weapon.getDescription();
	}


	public String getSpellAttackDesc() {
		return "attack";
	}


	public boolean piercesThru() {
		return weapon.isSlicesThrough();
	}


	public int getHeartCost() {
		return 0;
	}
}