/*Piece.java*/

/**
 * Represents a Normal Piece in Checkers61bl
 * 
 * @author
 */

public class Piece {

	/**
	 * Define any variables associated with a Piece object here. These variables
	 * MUST be private or package private.
	 */
	private int side;
	private Board b;
	private int Piecetype;   // 2-pawn 1:-bomb ; 0 Shield
	private boolean haskilledthisturn;
	private boolean isKing;

	/**
	 * Initializes a Piece
	 * 
	 * @param side
	 *            The side of the Piece
	 * @param b
	 *            The Board the Piece is on
	 */
	public Piece(int side1, Board b1) {
		// YOUR CODE HERE
		this.side = side1;
		this.b = b1;
		Piecetype = 2; // 2 is the pawn, 1 bomb is , -1 is shield and 1(type of
						// of king) is king
		
		// don't Override these instances
		isKing=false;
		haskilledthisturn = false;
	}
	public int getSide() {
		return side;

	}
	public Board getb() {
		return b;

	}
	public int getPiecetype() {
		return Piecetype;
	}
	public boolean getHaskilledthisturn() {
		return haskilledthisturn;
	}


	public void setHaskilledthisturn(boolean haskilledthisturn) {
		this.haskilledthisturn = haskilledthisturn;
}



	public void setKing(boolean isKing) {
		this.isKing = isKing;
	}
	public void setPiecetype(int Piecetype) {
		this.Piecetype= Piecetype;
	}

	/**
	 * Returns the side that the piece is on
	 * 
	 * @return 0 if the piece is fire and 1 if the piece is water
	 */
	public int side() {
		// YOUR CODE HERE
		int S = side;
		return S;
	}

	public boolean isKing() {
		// YOUR CODE HERE
		if (isKing == true) {
			return true;
		} else
			return false;
	}
	

	/**
	 * Destroys the piece at x, y. ShieldPieces do not blow up
	 * 
	 * @param x
	 *            The x position of Piece to destroy
	 * @param y
	 *            The y position of Piece to destroy
	 */
	void blowUp(int x, int y) {
			if (b.getMyPieces()[x][y]!=null){
				b.remove(x,y);
			}
			
	}
	/**
	 * Does nothing. For bombs, destroys pieces adjacent to it
	 * 
	 * @param x
	 *            The x position of the Piece that will explode
	 * @param y
	 *            The y position of the Piece that will explode
	 */
	void explode(int x, int y) {
		// YOUR CODE HERE
		// does noting unless it is a bomb piece
	}

	/**
	 * Signals that this Piece has begun to capture (as in it captured a Piece)
	 */
	void startCapturing() {
		// YOUR CODE HERE
		haskilledthisturn=true;
	}
	/**
	 * Returns whether or not this piece has captured this turn
	 * 
	 * @return true if the Piece has captured
	 */
	public boolean hasCaptured() {
		// YOUR CODE HERE
		
		return haskilledthisturn;
	}
	/**
	 * Resets the Piece for future turns
	 */
	
	public void finishCapturing() {
		// YOUR CODE HERE
		haskilledthisturn=true;
	}
}
