/*ShieldPiece.java*/

/**
 * Represents a ShieldPiece in Checkers61bl
 * @author 
 */

public class ShieldPiece extends Piece {

  /**
   *  Define any variables associated with a ShieldPiece object here.  These
   *  variables MUST be private or package private.
   *  private int side;
	private Board b;
	private int piecetype;   // 2-pawn 1:-bomb ; 0 Shield
	private boolean haskilledthisturn;
	private boolean isKing;  
   */
	
  
  /**
   * Constructs a new ShieldPiece
   * @param  side what side this ShieldPiece is on
   * @param  b    Board that this ShieldPiece belongs to
   */
  public ShieldPiece(int side, Board b){
    //YOUR CODE HERE
	  super(side, b);
	  setPiecetype(0);
  }
  void blowUp(int x, int y) {
		// YOUR CODE HERE
		// do nothing.... 
	  Board b=getb();
	  if (b.getMyPieces()[x][y]!=null){
			
				}
	}

}