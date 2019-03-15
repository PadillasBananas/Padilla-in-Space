public class AlienEntity extends Entity{

	public double Speed = 70;
	public DesignWindow Game;
	public AlienShotEntity Bomb;
	public int VertSpeed;
	
	public AlienEntity(DesignWindow Game, String ref, int X, int Y, int Vert)
	{
		super(ref,X,Y);
		this.Game = Game;
		SpeedX = -Speed;
		VertSpeed = Vert;
	}
	
	public void Move(long Delta)
	{
		if(((SpeedX > 0) && (X > 750)) || ((SpeedX < 0) && (X < 10)))
		{
			Game.updateLogic();
		}
		super.Move(Delta);
	}
	
	public void doLogic()
	{
		SpeedX = -SpeedX;
		Y = Y + VertSpeed;
		if(Y > 570)
		{
			Game.GameOver();
		}
	}
	public void CollidedWith(Entity other)
	{
	}
}
