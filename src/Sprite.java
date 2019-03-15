import java.awt.Graphics;
import java.awt.Image;

public class Sprite {
	public Image image;
	public Sprite(Image image)
	{
		this.image = image;
	}
	public int getWidth()
	{
		return image.getWidth(null);
	}
	public int getHeight()
	{
		return image.getHeight(null);
	}
	public void draw(Graphics Graphic, int X, int Y)
	{
		Graphic.drawImage(image, X, Y, null);
	}
}
