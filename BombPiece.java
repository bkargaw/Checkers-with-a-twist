/*BombPiece.java*/

/**
 *  Represents a BombPiece ins Checkers61bl
 * @author 
 */

public class BombPiece extends Piece {
 
  /**
   *  Define any variables associated with a BombPiece object here.  These
   *  variables MUST be private or package private.
   *  private int side;
	*/
	/*
   * Constructs a new BombPiece
   * @param  side what side this BombPiece is on
   * @param  b    Board that this BombPiece belongs to
   */
  public BombPiece(int side, Board b) {
    //YOUR CODE HERE
	  super(side,b);
	  setPiecetype(1);
	  
  }void explode(int x, int y) {
		// YOUR CODE HERE
			  int xmin= x-1;
			  int ymin= y-1;
			  int xmax= x+1;
			  int ymax= y+1;
			  if (x==0){
				  xmin=x;
			  }
			  if (y==0){
				  ymin=y;
			  }
			  if (x==7){
				  xmax=x;
						  }
			  if (y==7){
				  ymax=y;
			  }
			  for (int i=xmin; i<=xmax;i++){
				  for (int j=ymin; j<=ymax;j++){
					  Board b=getb();
					  if (b.getMyPieces()[i][j]!=null){
					  b.getMyPieces()[i][j].blowUp(i,j);
					  }
				  }
			  } 
		}
  void startCapturing() {
		// YOUR CODE HERE
		super.setHaskilledthisturn(false);  // since they explode and can't capture again...
		}
	}

