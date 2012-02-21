package crl.ui.effects;

import sz.util.Position;

public abstract class EffectFactory {
	private static EffectFactory singleton;
	public static void setSingleton(EffectFactory ef){
		singleton = ef;
	}
	public static EffectFactory getSingleton(){
		return singleton;
	}
	
	/*public abstract Effect createAnimatedMissileEffect(Position start, Position end, String ID, int length);
	public abstract Effect createDirectionalMissileEffect(Position start, Position end, String ID, int length);
	public abstract Effect createBeamMissileEffect(Position start, Position end, String ID, int length);
	public abstract Effect createSplashEffect(Position location, String ID);
	public abstract Effect createMeleeEffect(Position start, int direction, int depth, String ID);
	public abstract Effect createSequentialEffect(Position center, String ID);
	public abstract Effect createAnimatedEffect(Position location, String ID);
	public abstract Effect createTileEffect(Position location, String ID);
	public abstract Effect createTileMissileEffect(Position start, Position end, String ID, int length);
	public abstract Effect createFlashEffect(Position location, String ID);*/
	
	public abstract Effect createDirectedEffect(Position start, Position end, String ID, int length);
	public abstract Effect createDirectionalEffect(Position start, int direction, int depth, String ID);
	public abstract Effect createLocatedEffect(Position location, String ID);
	
}
