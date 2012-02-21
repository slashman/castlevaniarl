package crl.levelgen;

import sz.util.*;

public class AssignedFeature {
	private Position position;
	private LevelFeature feature;

	public AssignedFeature(Position position, LevelFeature feature){
		this.position = position;
		this.feature = feature;
	}

	public Position getPosition() {
		return position;
	}

	public LevelFeature getFeature() {
		return feature;
	}
}