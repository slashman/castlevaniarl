package crl.conf.gfx.data;

import java.awt.image.BufferedImage;
import java.util.Properties;

import crl.game.Game;

import sz.util.ImageUtils;

/**
 * Class to store image configuration
 * 
 * @author Tuukka Turto
 *
 */
public class GFXImageConfiguration {

	public GFXImageConfiguration() {
		
	}
	
	protected BufferedImage ShadowImage;
	protected BufferedImage CharactersImage;
	protected BufferedImage BigMonstersImage;
	protected BufferedImage MonstersImage;
	protected BufferedImage ItemsImage;
	protected BufferedImage ItemIconsImage;

	protected BufferedImage TerrainImage;
	protected BufferedImage DarkTerrainImage;
	protected BufferedImage NightTerrainImage;
	protected BufferedImage DarkNightTerrainImage;

	protected BufferedImage FeaturesImage;
	protected BufferedImage FeatureIconsImage;
	protected BufferedImage EffectsImage;

	protected BufferedImage effectsImage;
	protected BufferedImage slashesImage;
	protected BufferedImage curvedSlashesImage;
	protected BufferedImage straightSlashesImage;

	protected BufferedImage UserInterfaceTileset;
	protected BufferedImage ViewportUserInterfaceTileset;
	
	public void LoadConfiguration(Properties p) {
		try {
			ShadowImage = ImageUtils.createImage(p.getProperty("TILES_SHADOW"));
			CharactersImage = ImageUtils.createImage(p.getProperty("TILES_CHARACTERS"));
			BigMonstersImage = ImageUtils.createImage(p.getProperty("TILES_BIG_MONSTERS"));
			MonstersImage = ImageUtils.createImage(p.getProperty("TILES_MONSTERS"));
			ItemsImage = ImageUtils.createImage(p.getProperty("TILES_ITEMS"));
			ItemIconsImage = ImageUtils.createImage(p.getProperty("TILES_ITEM_ICONS"));

			TerrainImage = ImageUtils.createImage(p.getProperty("TILES_TERRAIN"));
			DarkTerrainImage = ImageUtils.createImage(p.getProperty("TILES_DARK_TERRAIN"));
			NightTerrainImage = ImageUtils.createImage(p.getProperty("TILES_NIGHT_TERRAIN"));
			DarkNightTerrainImage = ImageUtils.createImage(p.getProperty("TILES_DARK_NIGHT_TERRAIN"));

			FeaturesImage = ImageUtils.createImage(p.getProperty("TILES_FEATURES"));
			FeatureIconsImage = ImageUtils.createImage(p.getProperty("TILES_FEATURE_ICONS"));
			EffectsImage = ImageUtils.createImage(p.getProperty("TILES_EFFECTS"));

			effectsImage = ImageUtils.createImage(p.getProperty("SFX_EFFECTS"));
			slashesImage = ImageUtils.createImage(p.getProperty("SFX_SLASHES"));
			curvedSlashesImage = ImageUtils.createImage(p.getProperty("SFX_CURVED_SLASHES"));
			straightSlashesImage = ImageUtils.createImage(p.getProperty("SFX_STRAIGHT_SLASHES"));

			UserInterfaceTileset = ImageUtils.createImage(p.getProperty("UI_TILES"));
			ViewportUserInterfaceTileset = ImageUtils.createImage(p.getProperty("VIEWPORT_UI_TILES"));
		}
		catch (Exception e) {
			Game.crash(e.getMessage(), e);
		}		
	}

	public BufferedImage getUserInterfaceTileset() {
		return UserInterfaceTileset;
	}

	public BufferedImage getViewportUserInterfaceTileset() {
		return ViewportUserInterfaceTileset;
	}
	
	public BufferedImage getShadowImage() {
		return ShadowImage;
	}
	public BufferedImage getCharactersImage() {
		return CharactersImage;
	}
	public BufferedImage getBigMonstersImage() {
		return BigMonstersImage;
	}
	public BufferedImage getMonstersImage() {
		return MonstersImage;
	}
	public BufferedImage getItemsImage() {
		return ItemsImage;
	}
	public BufferedImage getTerrainImage() {
		return TerrainImage;
	}
	public BufferedImage getDarkTerrainImage() {
		return DarkTerrainImage;
	}
	public BufferedImage getNightTerrainImage() {
		return NightTerrainImage;
	}
	public BufferedImage getDarkNightTerrainImage() {
		return DarkNightTerrainImage;
	}
	public BufferedImage getFeaturesImage() {
		return FeaturesImage;
	}
	public BufferedImage getEffectsImage() {
		return EffectsImage;
	}
	
	
}
