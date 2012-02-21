package sz.util;

import java.awt.Component;
import java.awt.Container;
import java.awt.DisplayMode;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageInputStreamImpl;

public class ImageUtils {
	public static  BufferedImage createImage (String filename) throws Exception {
         /*BufferedImage im =  ImageIO.read(
                   ImageUtils.class.getResource(filename) );*/
		BufferedImage im =  ImageIO.read(new File(filename));
         return im;
         
         /*int transparency = im.getColorModel( ).getTransparency( );
         BufferedImage copy =  gc.createCompatibleImage(
                                  im.getWidth( ), im.getHeight( ),
                                  transparency );

         Graphics2D g2d = copy.createGraphics( );
         g2d.drawImage(im,0,0,null);
         g2d.dispose();
         return copy;*/
	}
	
	/*public static Image crearImagen(String filename) throws Exception{
    	//Debug.enterStaticMethod("IASImageUtils", "crearImagen "+filename);
    	//Debug.say("estoy cargando una imagen "+filename);
    	if (!FileUtil.fileExists(filename)){
    		Exception e = new Exception("Archivo Inexistente " +filename);
    		Debug.exitExceptionally(e);
    		throw e;
    	}
        Image image = Toolkit.getDefaultToolkit().getImage(filename);
        MediaTracker mediaTracker = new MediaTracker(new Container());
        mediaTracker.addImage(image, 0);
        try{
            mediaTracker.waitForID(0);
        }catch(InterruptedException ex){
        	System.out.println(ex.getMessage());
        }
        //Debug.exitMethod(image);
        return image;
    }*/
	
	public static Image crearImagen(String filename, Component tracker) throws Exception{
    	//Debug.enterStaticMethod("IASImageUtils", "crearImagen "+filename);
    	//Debug.say("estoy cargando una imagen "+filename);
    	if (!FileUtil.fileExists(filename)){
    		Exception e = new Exception("Archivo Inexistente " +filename);
    		Debug.exitExceptionally(e);
    		throw e;
    	}
        Image image = Toolkit.getDefaultToolkit().getImage(filename);
        MediaTracker mediaTracker = new MediaTracker(tracker);
        mediaTracker.addImage(image, 0);
        try{
            mediaTracker.waitForID(0);
        }catch(InterruptedException ex){
        	System.out.println(ex.getMessage());
        }
        //Debug.exitMethod(image);
        return image;
    }
	
	private static Image tempImage; 
	
	public static BufferedImage crearImagen(String filename, int x, int y, int width, int height) throws Exception{
		//tempImage = crearImagen(filename);
		BufferedImage tempImage = createImage(filename);
		return crearImagen(tempImage, x, y, width, height);
		        
		//return Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(tempImage.getSource(), new CropImageFilter(x, y, width, height)));
    }
	
	public static BufferedImage crearImagen(BufferedImage tempImage, int x, int y, int width, int height) throws Exception{
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    GraphicsConfiguration gc = ge.getDefaultScreenDevice( ).getDefaultConfiguration( );

	    int transparency = tempImage.getColorModel( ).getTransparency( );

	    BufferedImage ret =gc.createCompatibleImage(width,height,transparency);
        // create a graphics context
        Graphics2D retGC = ret.createGraphics();

        // copy image
        retGC.drawImage(tempImage,
                    0,0, width,height, x,y,x+width,y+height,null);
        retGC.dispose();
        return ret;

		//return Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(tempImage.getSource(), new CropImageFilter(x, y, width, height)));
    }

	public static BufferedImage hFlip(BufferedImage image){
		AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
		tx.translate(0, -image.getHeight(null));
	    AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
	    return op.filter(image, null);
	}
	
	public static BufferedImage vFlip(BufferedImage image){
		AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
		tx.translate(-image.getWidth(null), 0);
	    AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
	    return op.filter(image, null);
	}
	
	public static BufferedImage rotate(BufferedImage bufferedImage, double radians){
		AffineTransform tx = new AffineTransform();
	    tx.rotate(radians, bufferedImage.getWidth()/2, bufferedImage.getHeight()/2);
	    AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
	    return op.filter(bufferedImage, null);
	}
}
