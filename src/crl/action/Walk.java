package crl.action;

import sz.util.Debug;
import sz.util.Position;
import sz.util.Util;
import crl.actor.Actor;
import crl.feature.Feature;
import crl.item.Merchant;
import crl.level.Cell;
import crl.level.Level;
import crl.monster.Monster;
import crl.npc.Hostage;
import crl.npc.NPC;
import crl.player.Damage;
import crl.player.Player;
import crl.ui.UserInterface;

public class Walk extends Action{
	private Player aPlayer;
	
	public String getID(){
		return "Walk";
	}
	
	public boolean needsDirection(){
		return true;
	}

	public void execute(){
		Debug.doAssert(performer instanceof Player, "An actor different from the player tried to execute Walk action");
		Debug.enterMethod(this, "execute");
		aPlayer = (Player) performer;
		if (targetDirection == Action.SELF){
			aPlayer.getLevel().addMessage("You stand alert.");
			return;
		}
        Position var = directionToVariation(targetDirection);
        Position destinationPoint = Position.add(performer.getPosition(), var);
        Level aLevel = performer.getLevel();
        Cell destinationCell = aLevel.getMapCell(destinationPoint);
        Feature destinationFeature = aLevel.getFeatureAt(destinationPoint);
        Cell currentCell = aLevel.getMapCell(performer.getPosition());

        if (destinationCell == null || destinationCell.isEthereal()){
        	if (!aLevel.isValidCoordinate(destinationPoint)){
        		aPlayer.land();
        		Debug.exitMethod();
            	return;
        	}
        	if (!aPlayer.isFlying()){
	        	destinationPoint = aLevel.getDeepPosition(destinationPoint);
	        	if (destinationPoint == null) {
	       			aPlayer.land();
	        		Debug.exitMethod();
	            	return;
	        	} else {
	        		aLevel.addMessage("You fall!");
	        		destinationCell = aLevel.getMapCell(destinationPoint);
	        		currentCell = aLevel.getMapCell(destinationPoint);
	        	}
	        } else {
	        	aPlayer.setPosition(destinationPoint);
	        	Debug.exitMethod();
            	return;
	        }
        }

       	if (destinationCell.getHeight() > currentCell.getHeight()+2  && !aPlayer.isEthereal() &&!aPlayer.isFlying())
			aLevel.addMessage("You can't climb it.");
		else {
			if (destinationCell.getHeight() < currentCell.getHeight())
				aLevel.addMessage("You descend");
			if (destinationCell.isSolid() && !aPlayer.isEthereal()){
				if (destinationCell.getID().startsWith("SIGNPOST")){
					//aLevel.addMessage("The signpost reads : "+destinationCell.getDescription());
					UserInterface.getUI().setPersistantMessage(destinationCell.getDescription());
				}else{
					aLevel.addMessage("You bump into the "+destinationCell.getShortDescription());
				}
			}
			else
				if (destinationFeature != null && destinationFeature.isSolid()  && !aPlayer.isEthereal())
					aLevel.addMessage("You bump into the "+destinationFeature.getDescription());
				else
					if (!aLevel.isWalkable(destinationPoint) && !aPlayer.isEthereal())
						aLevel.addMessage("Your way is blocked");
					else
						if (destinationCell.getKeyCost() > aPlayer.getKeys())
							aLevel.addMessage("You need " + (destinationCell.getKeyCost() - aPlayer.getKeys() ) + " more keys to enter");
						else
							if (destinationFeature != null && destinationFeature.getKeyCost() > aPlayer.getKeys())
								aLevel.addMessage("You need " + (destinationFeature.getKeyCost() - aPlayer.getKeys() ) + " more keys to enter");
							else {
								Actor aActor = aLevel.getActorAt(destinationPoint);
								if (aActor != null && aActor.getStandingHeight() == aPlayer.getStandingHeight()){
									if (aActor instanceof Merchant && !((Merchant)aActor).isHostile()){
										aPlayer.informPlayerEvent(Player.EVT_MERCHANT, (Merchant) aActor);
									} else {
										if (aActor instanceof NPC && !((NPC)aActor).isHostile()) {
											if (((NPC)aActor).getNPCID().equals("LARDA")){
												aPlayer.informPlayerEvent(Player.EVT_INN, (NPC) aActor);
											} else {
												aPlayer.informPlayerEvent(Player.EVT_CHAT, (NPC) aActor);
												if (((NPC) aActor).isPriest()){
													if (!aPlayer.getFlag("HEALED_BY_" + ((NPC) aActor).getNPCID())) {
														aPlayer.heal();
														aPlayer.setFlag("HEALED_BY_" + ((NPC) aActor).getNPCID(), true);
													}
												}
												if (aActor instanceof Hostage){
													if (!aPlayer.hasHostage() && !((Hostage)aActor).isRescued()){
														aPlayer.setHostage((Hostage)aActor);
														aPlayer.addHistoricEvent("found "+aActor.getDescription()+" at the "+aLevel.getDescription());
														aLevel.removeMonster((Monster)aActor);
													}
												}
											}
										}else {
											if (aActor instanceof Monster){
												if (aPlayer.isInvincible()){
													//aLevel.addMessage("You are hit by the "+aMonster.getDescription()+"!");
												} else {
													Monster aMonster = (Monster) aActor;
													if (aPlayer.hasEnergyField()){
														StringBuffer buff = new StringBuffer("You shock the "+aMonster.getDescription()+"!"); 
														aMonster.damage(buff, aPlayer.getAttack());
														aLevel.addMessage(buff.toString());
													} else {
														if (aPlayer.damage("You bump with the "+aMonster.getDescription()+"!", aMonster, new Damage(aMonster.getAttack(), false))){
															aLevel.getPlayer().bounceBack(Position.mul(var, -1), 2);
															if (aPlayer.getPosition().equals(aMonster.getPosition())){
																//The player wasnt bounced back..
																//aLevel.addMessage("You are hit by the "+aMonster.getDescription()+"!");
															} else {
																aLevel.addMessage("You are bounced back by the "+aMonster.getDescription()+"!");
																//aPlayer.landOn(destinationPoint);
															}
														}
													}
												}
											} else {
												if (aLevel.getBloodAt(aPlayer.getPosition()) != null)
													if (Util.chance(30))
														aLevel.addBlood(destinationPoint, Util.rand(0,1));
												aPlayer.landOn(destinationPoint);
											}
										}
									}
								} else {
									if (aLevel.getBloodAt(aPlayer.getPosition()) != null)
										if (Util.chance(30))
											aLevel.addBlood(destinationPoint, Util.rand(0,1));
									aPlayer.landOn(destinationPoint);

                            	}
							}
		}
       	Debug.exitMethod();
	}

	public int getCost(){
		return aPlayer.getWalkCost();
	}
}