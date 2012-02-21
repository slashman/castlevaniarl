package crl.ai;

import crl.action.Action;
import crl.actor.Actor;

public interface ActionSelector extends Cloneable, java.io.Serializable{
	public Action selectAction(Actor who);
	public String getID();

	public ActionSelector derive();

}