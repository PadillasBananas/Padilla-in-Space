
public class PlayerEntity extends Entity{

	public DesignWindow Game;
	public boolean Live;
	
	public PlayerEntity(DesignWindow Game, String ref, int X, int Y)
	{
		super(ref,X,Y);
		this.Game = Game;
	}
	public void Move(long Delta)
	{
		if(((SpeedX > 0) && (X>750)) || ((SpeedX<0) && (X <10)))
		{
			return;
		}
		super.Move(Delta);
	}
	
	public void CollidedWith(Entity thing)
	{
		if(thing instanceof AlienEntity)
		{

			//Game.Lives--;
			if(Game.Lives < 0 )
			{
				Game.GameOver();
			}
			Live = Game.Respawn();
			Game.Death();
		}
	}
}
