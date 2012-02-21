package crl.feature;

import java.util.*;

import sz.util.*;

public class SmartFeatureFactory {
	private static SmartFeatureFactory singleton = new SmartFeatureFactory();
	private Hashtable definitions;

	public SmartFeature buildFeature (String id) {
		SmartFeature x = (SmartFeature) definitions.get(id);
		if (x != null)
			return (SmartFeature) x.clone();
		Debug.byebye("SmartFeature "+id+" not found");
		return null;
	}

	public void addDefinition(SmartFeature definition){
		definitions.put(definition.getID(), definition);
	}
	
	public void init(SmartFeature[] defs) {
		for (int i = 0; i < defs.length; i++)
			definitions.put(defs[i].getID(), defs[i]);
	}

	public SmartFeatureFactory(){
		definitions = new Hashtable(40);
	}

	public static SmartFeatureFactory getFactory(){
		return singleton;
	}
}
