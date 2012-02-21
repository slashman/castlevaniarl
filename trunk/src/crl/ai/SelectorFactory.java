package crl.ai;

import java.util.Hashtable;

import sz.util.Debug;

public class SelectorFactory{
	private final static SelectorFactory singleton = new SelectorFactory();
	private Hashtable definitions;

/*	public ActionSelector buildSelector (String id){
		Cell x = (Cell) definitions.get(id);
		return x.clone();
	}   */

	public static SelectorFactory getSelectorFactory(){
		return singleton;
    }

	public ActionSelector getSelector (String id){
		ActionSelector ret = (ActionSelector) definitions.get(id);
		Debug.doAssert(ret != null, "Tried to get an invalid "+id+" ActionSelector");
		return ret;
	}

	public ActionSelector createSelector (String id){
		ActionSelector ret = ((ActionSelector) definitions.get(id)).derive();
		Debug.doAssert(ret != null, "Tried to create an invalid "+id+" ActionSelector" +" "+this.toString());
		return ret;
	}

	public void addDefinition(ActionSelector definition){
		definitions.put(definition.getID(), definition);
	}

	public SelectorFactory(){
		definitions = new Hashtable(40);
	}

}