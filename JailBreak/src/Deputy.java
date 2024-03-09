public class Deputy extends AbstractGamePiece
{
	// The Deputy constructor
	public Deputy()
	{
		// initialize the AbstractGamePiece constructor with required data
		super("Deputy","D",AbstractGamePiece.PLAYER_POSSE);
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
		// as an deputy, I am not allowed to step on the jail square
		if (step.getType() == GameSquare.TYPE_JAIL)
			return true;
		
		return false;	// everything else is fine!
	}
}
