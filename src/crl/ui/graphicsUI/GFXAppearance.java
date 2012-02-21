package crl.ui.graphicsUI;

import java.awt.Image;

import crl.ui.Appearance;

public class GFXAppearance extends Appearance{
	private Image img;
	private Image darkImage;
	private Image niteImage;
	private Image darkniteImage;
	private int superWidth, superHeight;
	
	public int getSuperHeight() {
		return superHeight;
	}

	public int getSuperWidth() {
		return superWidth;
	}

	public GFXAppearance(String ID, Image pimg, int superWidth, int superHeight) {
		super(ID);
		img = pimg;
		this.superHeight = superHeight;
		this.superWidth = superWidth;
	}
	
	public GFXAppearance(String ID, Image pimg, Image darkImage, Image niteImage, Image darkniteImage, int superWidth, int superHeight) {
		super(ID);
		img = pimg;
		this.darkImage = darkImage;
		this.niteImage = niteImage;
		this.darkniteImage = darkniteImage;
		this.superHeight = superHeight;
		this.superWidth = superWidth;
	}
	
	public Image getImage(){
		return img;
	}

	public Image getDarkImage() {
		return darkImage;
	}
	
	public Image getNiteImage() {
		return niteImage;
	}
	
	public Image getDarkniteImage(){
		return darkniteImage;
	}

	

}
