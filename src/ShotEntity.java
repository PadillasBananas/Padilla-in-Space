

public class ShotEntity extends Entity {

	public  double Speed = -300;
	public DesignWindow Game;
	public boolean used = false;
	
	public ShotEntity(DesignWindow Game, String sprite, int X, int Y)
	{
		super(sprite,X,Y);
		this.Game = Game;
		SpeedY = Speed;
	}
	
	public void move(long Delta)
	{
		super.Move(Delta);
		if(Y < -100)
		{
			Game.RemoveThing(this);
		}
	}
	
	public void CollidedWith(Entity other)
	{
		if(used == true)
		{
			return;
		}
		else
		{
			if(other instanceof AlienEntity)
			{
				Game.AlienDead();
				Game.RemoveThing(this);
				Game.RemoveThing(other);
				
				used = true;
			}
			
			if(other instanceof BarrierEntity)
			{	
				Game.RemoveThing(this);
				used = true;
			}
		}
	}
}

