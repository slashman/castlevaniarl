package sz.gadgets;

import java.awt.Image;

public interface GFXMenuItem extends java.io.Serializable{
	public Image getMenuImage();
	public String getMenuDescription();
	public String getMenuDetail();

}