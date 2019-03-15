import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {
	public double X;
	public double Y;
	public Sprite Sprite;
	public double SpeedX;
	public double SpeedY;
	public boolean BombD;
	public int VertSpeed;
//	public ArrayList<Rectangle> shieldBlocks = new ArrayList<Rectangle>();
	
	//public BarrierEntity B = new Entity();
	
	public Rectangle Player = new Rectangle();
	public Rectangle Enemy = new Rectangle();
	public Rectangle Barrier = new Rectangle();
	
	public Entity(String ref, int X, int Y)
	{
		this.Sprite = SpriteStore.get().getSprite(ref);
		this.X = X;
		this.Y = Y;
		// this.Sprite = SpriteStore.get().getSprite(ref);
	}
	
	public void Move(long Delta)
	{
		X = X + (Delta * SpeedX) / 1000;
		Y = Y + (Delta * SpeedY) / 1000;
	}
	
	public void EMove(long Delta)
	{
		X = (X + (Delta * SpeedX) / 1000);
		Y = -(Y + (Delta * SpeedY) / 1000);
	}
	
	public void setHorizontalMovement(double Speedx)
	{
		this.SpeedX = Speedx;
	}
	
	public void setVerticalMovement(double Speedy)
	{
		this.SpeedY = Speedy;
	}
	
	public double getHorizontalMovement()
	{
		return SpeedX;
	}
	public double getVerticalMovement()
	{
		return SpeedY;
	}
	
	public void draw(Graphics Graphic)
	{
		Sprite.draw(Graphic,(int)X,(int)Y);
	}
	
	public void doLogic()
	{
	}
	
	public int getX()
	{
		return((int) X);
	}
	public int getY()
	{
		return((int) Y);
	}
	
	public boolean CollidesWith(Entity other)
	{
		Player.setBounds((int) X, ((int) Y), Sprite.getWidth(),Sprite.getHeight());			
		Enemy.setBounds(((int) other.X), (int) other.Y, other.Sprite.getWidth(),other.Sprite.getHeight());
		return Player.intersects(Enemy);
	}
	public boolean CollidesWithB(Entity other)
	{
		Player.setBounds((int) X, ((int) Y), Sprite.getWidth(),Sprite.getHeight());	
		Barrier.setBounds(((int) (other.X * 5)), (int) (500+other.Y*5),10,2);			
		return Player.intersects(Barrier);
	}
	public boolean CollidesWithE(Entity other)
	{
		Enemy.setBounds((int) X, ((int) Y), Sprite.getWidth(),Sprite.getHeight());	
		Barrier.setBounds(((int) (other.X * 5)), (int) (500+other.Y*5),10,2);			
		return Enemy.intersects(Barrier);
	}
	
	
	public abstract void CollidedWith(Entity other);
}
