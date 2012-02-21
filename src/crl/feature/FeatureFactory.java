package crl.feature;

import java.util.*;

import sz.util.*;

public class FeatureFactory {
	private static FeatureFactory singleton = new FeatureFactory();


	private Hashtable definitions;
	
	public Feature buildFeature (String id) {
		Feature x = (Feature) definitions.get(id);
		if (x != null)
			return (Feature) x.clone();
		Debug.byebye("Feature "+id+" not found");
		return null;
	}

	public String getDescriptionForID(String id){
		Feature x = (Feature) definitions.get(id);
		if (x != null)
			return x.getDescription();
		else
		return "?";
	}

	public void addDefinition(Feature definition){
		definitions.put(definition.getID(), definition);
	}
	
	public void init(Feature[] defs) {
		for (int i = 0; i < defs.length; i++)
			definitions.put(defs[i].getID(), defs[i]);
	}

	public FeatureFactory(){
		definitions = new Hashtable(40);
	}

	public static FeatureFactory getFactory(){
		return singleton;
	}
}