public class Henchman extends AbstractGamePiece
{
	// the Henchman constructor
	public Henchman()
	{
		// initialize the AbstractGamePiece constructor with required data
		super("Henchman","H",AbstractGamePiece.PLAYER_OUTLAWS);
	}
	
	// implement the abstract method hasEscaped()
	public boolean hasEscaped()
	{
		// I am not the Kingpin, so I can never escape
		return false;
	}
	
	// implement the abstract method isSquareRestricted() 
	protected boolean isSquareRestricted(GameSquare step)
	{
		// as an outlaw, I am not allowed to step on any camp square
		if (step.getType() == GameSquare.TYPE_CAMP)
			return true;
		
		// as an outlaw, I am not allowed to step on the jail square
		if (step.getType() == GameSquare.TYPE_JAIL)
			return true;
		
		return false;	// everything else is fine!
	}
	

}
