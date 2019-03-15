import java.awt.Rectangle;
import java.util.ArrayList;
import java.awt.*;

public class BarrierEntity extends Entity
{
	public DesignWindow Game;
	public ArrayList<Rectangle> shieldBlocks = new ArrayList<Rectangle>();
	public int AX;
	public int AY;
	
	public BarrierEntity(DesignWindow Game, String ref, int X, int Y)
	{
		super(ref,X,Y);
		AX = X;
		AY = Y;
		this.Game = Game;
		shieldBlocks.add(new Rectangle(X*5, 500+Y*5,10,2));
		//SpeedX = -Speed;		
	}
	
	public void draw(Graphics Graphic)
	{
		Graphic.setColor(new Color(0,255,0));
		for(Rectangle shield : shieldBlocks)
		{
			if(shield == null)
			{
				return;
			}
			else 
			{
				int X = (int) (shield.getX());
				int y = (int) (shield.getY());
				Graphic.drawRect(X, y, 10,2);
			}
		}
	}

	
	public void CollidedWith(Entity other)
	{
	}

}
