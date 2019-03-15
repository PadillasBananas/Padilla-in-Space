
public class AlienShotEntity extends Entity {
		public  double Speed = 300;
		public DesignWindow Game;
		public boolean used = false;
		
		public AlienShotEntity(DesignWindow Game, String sprite, int X, int Y)
		{
			super(sprite,X,Y);
			this.Game = Game;
			SpeedY = Speed;
		}
		
		public void move(long Delta)
		{
			//Delta = -Delta;
			super.EMove(Delta);
			if(Y < 80)
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
				if(other instanceof PlayerEntity)
				{

					Game.Death();
					Game.RemoveThing(this);
					Game.RemoveThing(other);
					
					used = true;
				}
				
				if(other instanceof BarrierEntity)
				{	
					Game.RemoveThing(this);
					Game.RemoveThing(other);
					used = true;
				}
			}
		}
}
