////////////////////////////////////////////////////////////////
// Copyright, CompuScholar, Inc.
//
// This source code is for use by the students and teachers who 
// have purchased the corresponding TeenCoder or KidCoder product.
// It may not be transmitted to other parties for any reason
// without the written consent of CompuScholar, Inc.
// This source is provided as-is for educational purposes only.
// CompuScholar, Inc. makes no warranty and assumes
// no liability regarding the functionality of this program.
//
////////////////////////////////////////////////////////////////

// STUDENT SHOULD CREATE THIS CLASS AND IMPLEMENT ALL REQUIRED METHODS

/** Java Programming
 * Chapter 16 - Jail Break Project
 * This class represents the Deputy game piece in the 
 * Jail Break game.
 * @author CompuScholar, Inc.
 * @version 1.0
*/

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
