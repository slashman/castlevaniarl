package crl.feature;

import java.io.Serializable;
import java.util.*;

import sz.util.*;

public class VFeatures implements Serializable{
   	Vector features;
	Hashtable mLocs;

	private Vector temp = new Vector();
	public void addFeature(Feature what){
		features.add(what);
		//mLocs.put(what, what.getPosition());
		mLocs.put(what.getPosition(), what);
	}

	public Feature[] getFeaturesAt(Position p){
		temp.clear();
		for (int i=0; i<features.size(); i++){
			if (((Feature)features.elementAt(i)).getPosition().equals(p)){
				temp.add(features.elementAt(i));
			}
		}
		if (temp.size() == 0){
			return null;
		} else {
			return (Feature[])temp.toArray(new Feature[temp.size()]);
		}
	}
	
	public Feature getFeatureAt(Position p){
		//return (Feature) mLocs.get(p);
		for (int i=0; i<features.size(); i++){
			if (((Feature)features.elementAt(i)).getPosition().equals(p)){
				return (Feature)features.elementAt(i);
			}
		}
		//Debug.byebye("Feature not found! "+p);
		return null;
	}

	public VFeatures(int size){
		features = new Vector(size);
		mLocs = new Hashtable(size);
	}

	public void removeFeature(Feature o){
		features.remove(o);
		if (mLocs.containsValue(o))
			mLocs.remove(o);
	}
	
	private Vector tempVector = new Vector();
	public Vector getAllOf(String featureID){
		tempVector.removeAllElements();
		for (int i = 0; i < features.size(); i++){
			Feature f = (Feature) features.elementAt(i);
			if (f.getID().equals(featureID)){
				tempVector.add(f);
			}
		}
		return tempVector;
	}

}