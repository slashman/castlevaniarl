package crl.ui;

import java.util.*;

import sz.util.*;

public class AppearanceFactory {
	private Hashtable definitions;
	private static AppearanceFactory singleton = new AppearanceFactory();

/*	public Cell buildMapCell (String id){
		Cell x = (Cell) definitions.get(id);
		return x.clone();
	}   */

	public static AppearanceFactory getAppearanceFactory(){
		return singleton;
	}

	public Appearance getAppearance (String id){
		Appearance ret = (Appearance) definitions.get(id);
		Debug.doAssert(ret != null, "Couldnt find the appearance "+id);
		return ret;
	}

	public void addDefinition(Appearance definition){
		definitions.put(definition.getID(), definition);
	}

	public AppearanceFactory(){
		definitions = new Hashtable(40);
	}

}