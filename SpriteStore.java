import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import javax.imageio.ImageIO;

public class SpriteStore {

	public static SpriteStore Single = new SpriteStore();
	
	public static SpriteStore get()
	{
		return(Single);
	}
	
	public HashMap<String, Sprite> sprites = new HashMap<String, Sprite>();
	
	public void fail(String method)
	{
		System.err.println(method);
		System.exit(0);
	}
	
	public Sprite getSprite(String ref)
	{
		if(sprites.get(ref) == null)
		{
			BufferedImage sourceImage = null;
			//sourceImage = ImageIO.read(ref);
			
			
			try 
			{
				URL url = this.getClass().getClassLoader().getResource(ref);
				if(url == null)
				{
					fail("Somethig went wrong.. check SpriteStore.java  "+ref);
				}
				sourceImage = ImageIO.read(url);
			}
			catch(IOException e)
			{
				fail("Something went wrong.. check SpriteStore.java  "+ref);
			}
			
			
			GraphicsConfiguration GC = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
			Image image = GC.createCompatibleImage(sourceImage.getWidth(),sourceImage.getHeight(), Transparency.BITMASK);
			image.getGraphics().drawImage(sourceImage, 0, 0, null);
			Sprite sprite = new Sprite(image);
			sprites.put(ref,sprite);
			return sprite;
		}
		else
		{
			return((Sprite) sprites.get(ref));
		}
	}
/*	
	public void fail(String method)
	{
		System.err.println(method);
		System.exit(0);
	}
*/
}
