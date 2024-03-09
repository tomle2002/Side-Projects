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
 * Chapter 15 - Jail Break Project
 * This class represents the Kingpin game piece in the 
 * Jail Break game.
 * @author CompuScholar, Inc.
 * @version 1.0
*/

public class Kingpin extends AbstractGamePiece
{
	// The Kingpin constructor
	public Kingpin()
	{
		// initialize the AbstractGamePiece constructor with required data
		super("Kingpin","K",AbstractGamePiece.PLAYER_OUTLAWS);
	}
	
	// implement the abstract method hasEscaped()
	public boolean hasEscaped()
	{
		// if I am currently located on the 0th row or 0th column
		if ((myRow == 0) || (myCol == 0))
			return true;	// I have escaped!
		
		// if I am currently located on the last row or column
		if ((myRow >= (GameBoard.NUM_ROWS -1)) || 
			(myCol >= (GameBoard.NUM_COLS -1)) )
			return true;	// I have escaped!
		
		return false;	// no escape yet
	}
	
	// override the base class method isCaptured()
	public boolean isCaptured(GameBoard gameBoard)
	{
		// Note:  the GameBoard.getPiece() method will return null if we pass in
		// a column or index value that is off the game board (< 0 or >= 8).
		
		// get a reference to the pieces (if any) on all 4 sides of my location
		AbstractGamePiece nearbyPiece1 = gameBoard.getPiece(myRow - 1, myCol);	// get above piece
		AbstractGamePiece nearbyPiece2 = gameBoard.getPiece(myRow + 1, myCol);	// get below piece
		AbstractGamePiece nearbyPiece3 = gameBoard.getPiece(myRow, myCol - 1);	// get left piece
		AbstractGamePiece nearbyPiece4 = gameBoard.getPiece(myRow, myCol + 1);	// get right piece
	
		// if all pieces exist and belong to the opposing player
		if ((nearbyPiece1 != null) && (nearbyPiece1.getPlayerType() != myPlayerType) &&
		    (nearbyPiece2 != null) && (nearbyPiece2.getPlayerType() != myPlayerType) &&
		    (nearbyPiece3 != null) && (nearbyPiece3.getPlayerType() != myPlayerType) &&
		    (nearbyPiece4 != null) && (nearbyPiece4.getPlayerType() != myPlayerType) ) 
	    {
	    	return true;	// bad news, the Kingpin has been captured!
	    }
		
		return false;	// not captured yet!
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
