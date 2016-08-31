/*Board.java*/

/**
 * Represents a Board configuration of a game of Checkers61bl
 * 
 * @author
 */

public class Board {

	/**
	 * Define any variables associated with a Board object here. These variables
	 * MUST be private.
	 */

	// set all instance variables to private when done with coding ....
	// int[][] myRedPieces;
	// int[][] myBluePieces;

	private Piece[][] myPieces;
	private int lastselctedX = 0;
	private int lastselctedY = 0;
	private int turn = 0; // 0 for reds turn 1 for reds turn
	private boolean canselectApiece = true; // false for no , true for yes; // update
	private boolean pieceselected = false; // after the player
	// has move a piece
	private boolean moved = false; // true if player has move already , false if he has// not
							// moved already
	private boolean hasCaptured = false; /*
								 * false if the player has not captured yet with
								 * piece the turn, true if player has
								 */

	Board(boolean shouldBeEmpty) {
		if (shouldBeEmpty == true) {
			drawbackground();
			myPieces = new Piece[8][8];
		} else {
			myPieces = new Piece[8][8];
			// red side
			Piece R1 = new Piece(0, this);
			Piece R2 = new Piece(0, this);
			Piece R3 = new Piece(0, this);
			Piece R4 = new Piece(0, this);
			// red Shields
			Piece R5 = new ShieldPiece(0, this);
			Piece R6 = new ShieldPiece(0, this);
			Piece R7 = new ShieldPiece(0, this);
			Piece R8 = new ShieldPiece(0, this);
			// red bomb
			Piece R9 = new BombPiece(0, this);
			Piece R10 = new BombPiece(0, this);
			Piece R11 = new BombPiece(0, this);
			Piece R12 = new BombPiece(0, this);
			// red side
			Piece B1 = new Piece(1, this);
			Piece B2 = new Piece(1, this);
			Piece B3 = new Piece(1, this);
			Piece B4 = new Piece(1, this);
			// Blue Shields
			Piece B5 = new ShieldPiece(1, this);
			Piece B6 = new ShieldPiece(1, this);
			Piece B7 = new ShieldPiece(1, this);
			Piece B8 = new ShieldPiece(1, this);
			// Blue bomb
			Piece B9 = new BombPiece(1, this);
			Piece B10 = new BombPiece(1, this);
			Piece B11 = new BombPiece(1, this);
			Piece B12 = new BombPiece(1, this);
			myPieces[0][0] = R1;
			myPieces[2][0] = R2;
			myPieces[4][0] = R3;
			myPieces[6][0] = R4;
			myPieces[1][1] = R5;
			myPieces[3][1] = R6;
			myPieces[5][1] = R7;
			myPieces[7][1] = R8;
			myPieces[0][2] = R9;
			myPieces[2][2] = R10;
			myPieces[4][2] = R11;
			myPieces[6][2] = R12;
			myPieces[7][7] = B1;
			myPieces[5][7] = B2;
			myPieces[3][7] = B3;
			myPieces[1][7] = B4;
			myPieces[7][7] = B1;
			myPieces[5][7] = B2;
			myPieces[3][7] = B3;
			myPieces[1][7] = B4;
			myPieces[0][6] = B5;
			myPieces[2][6] = B6;
			myPieces[4][6] = B7;
			myPieces[6][6] = B8;
			myPieces[7][5] = B9;
			myPieces[5][5] = B10;
			myPieces[3][5] = B11;
			myPieces[1][5] = B12;
		}
		drawbackground();
		drawBoard();
	}

	private void drawbackground() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((i + j) % 2 == 0) {
					StdDrawPlus.setPenColor(StdDrawPlus.GRAY);
				} else {
					StdDrawPlus.setPenColor(StdDrawPlus.RED);
				}
				StdDrawPlus.filledSquare(i + .5, j + .5, .5);
			}
		}
	}
	public Piece[][] getMyPieces() {
		return myPieces;
	}

	public void setMyPieces(Piece[][] myPieces) {
		this.myPieces = myPieces;
	}

	/**
	 * gets the Piece at coordinates (x, y)
	 * 
	 * @param x
	 *            X-coordinate of Piece to get
	 * @param y
	 *            Y-coordinate of Piece to get
	 * @return the Piece at (x, y)
	 */
	public Piece pieceAt(int x, int y) {
		Piece P = null;
		if (x < 8 && x >= 0) {
			if (y < 8 && y >= 0) {
				if (myPieces[x][y] != null) {
					P = myPieces[x][y];
				}
			}
		}
		return P;
	}

	/**
	 * Places a Piece at coordinate (x, y)
	 * 
	 * @param p
	 *            Piece to place
	 * @param x
	 *            X coordinate of Piece to place
	 * @param y
	 *            Y coordinate of Piece to place
	 */
	public void place(Piece p, int x, int y) {
		if (p != null) {
			if (x < 8 && x >= 0) {
				if (y < 8 && y >= 0) {
					myPieces[x][y] = null;
					myPieces[x][y] = p;
				}
			}
		}
	}

	/**
	 * Removes a Piece at coordinate (x, y)
	 * 
	 * @param x
	 *            X coordinate of Piece to remove
	 * @param y
	 *            Y coordinate of Piece to remove
	 * @return Piece that was removed
	 */
	public Piece remove(int x, int y) {
		// YOUR CODE HERE
		Piece P = null;
		if (x < 8 && x >= 0) {
			if (y < 8 && y >= 0) {
				if (myPieces[x][y] != null) {
					P = myPieces[x][y];
					myPieces[x][y] = null;
					return P;
				} else {// no piece to remove
					System.out.println("no piece to remove here");
					return P;
				}
			} else {
				System.out.println("the y Coordinate is out of bounds");
				return null;
			}
		} else {
			System.out.println("the x Coordinate is out of bounds");
			return null;
		}

	}

	/**
	 * Determines if a Piece can be selected
	 * 
	 * @param x
	 *            X coordinate of Piece
	 * @param y
	 *            Y coordinate of Piece to select
	 * @return true if the Piece can be selected
	 */
	public boolean canSelect(int x, int y) {
		// YOUR CODE HERE

		// check it it is the right players move.....

		boolean canSelect = false; // Initialize as can't select
		// Piece P= new Piece(turn,this);
		
		if (x < 8 && x >= 0 && y < 8 && x >= 0) {
			if (pieceselected == true && myPieces[x][y] == null) {
				canselectApiece = false;
			}
			if (myPieces[x][y] != null) {
				if (turn == myPieces[x][y].getSide()) { // turn
					if (canselectApiece == true) {
						canSelect = true;
					} else if (canselectApiece == false && moved == false) {
						canSelect = true;
					}
				}
			} else if (myPieces[x][y] == null) {
				if (canselectApiece == false) { // has selected a piece
					if (moved == false) { // has not moved....
						if (canmove(x, y)) {
							canSelect = true;
						}
					} else if (hasCaptured) {
						int x1 = lastselctedX;
						int y1 = lastselctedY;
						int delX = x - x1;
						int delY = y - y1;
						if (Math.abs(delX) == Math.abs(delY)
								&& Math.abs(delX) == 2) {
							if (canmove(x, y)) {
								canSelect = true;
								/*
								 * Should capture
								 */
							}
						}

					}
				}
			}
		}
		return canSelect;
		// try and call can-select...
	}

	boolean canmove(int x2, int y2) {
		boolean canmove = false;
		int x1 = lastselctedX;
		int y1 = lastselctedY;
		int delX = x2 - x1;
		int delY = y2 - y1;
		int avgX = (x1 + x2) / 2;
		int avgY = (y1 + y2) / 2;
		if (myPieces[x1][y1].getSide() == 0) { // red turn
			if (myPieces[x1][y1].isKing() == false) { // check if it is not king
				if (delY > 0 && delY <= 2) {
					if (delX >= -2 && delX <= 2) { // general case... not
													// accounted for border case
						if (delX != 0) {
							if (Math.abs(delX) == Math.abs(delY)) {
								if (Math.abs(delX) == 2) {
									if (myPieces[avgX][avgY] != null) {
										if (myPieces[avgX][avgY].getSide() == 1) {// there-is-a-piece-of-other...
											canmove = true;
										}
									}
								} else if (Math.abs(delX) == 1) {
									canmove = true;
								}

							}
						}

					}
				}

			} else {
				if (delY >= -2 && delY <= 2) {
					if (delX >= -2 && delX <= 2) { // general case... not
													// accounted for border case
						if (delX != 0 && delY != 0) {
							if (Math.abs(delX) == Math.abs(delY)) {
								if (Math.abs(delX) == 2) {
									if (myPieces[avgX][avgY] != null) {
										if (myPieces[avgX][avgY].getSide() == 1) {// there-is-a-piece-of-other...
											canmove = true;
										}
									}
								} else if (Math.abs(delX) == 1) {
									canmove = true;
								}
							}
						}
					}
				}
			}
		} else if (myPieces[x1][y1].getSide() == 1) { // blue turn
			if (myPieces[x1][y1].isKing() == false) { // check if it is not king
				if (delY >= -2 && delY < 0) {
					if (delX >= -2 && delX <= 2) { // general case... not
													// accounted for border case
						if (delX != 0) {
							if (Math.abs(delX) == Math.abs(delY)) {
								if (Math.abs(delX) == 2) {
									if (myPieces[avgX][avgY] != null) {
										if (myPieces[avgX][avgY].getSide() == 0) {// there-is-a-piece-of-other-side...
											canmove = true;
										}
									}
								} else if (Math.abs(delX) == 1) {
									canmove = true;
								}

							}
						}

					}
				}
			} else {
				if (delY >= -2 && delY <= 2) {
					if (delX >= -2 && delX <= 2) { // general case... not
													// accounted for border case
						if (delX != 0 && delY != 0) {
							if (Math.abs(delX) == Math.abs(delY)) {
								if (Math.abs(delX) == 2) {
									if (myPieces[avgX][avgY] != null) {
										if (myPieces[avgX][avgY].getSide() == 0) {// there-is-a-piece-of-other-side...
											canmove = true;
										}

									}
								} else if (Math.abs(delX) == 1) {
									canmove = true;
								}
							}
						}
					}
				}
			}
		}

		// working on the boundary conditions

		if (x1 == 0 && delX <= 0) {
			canmove = false;
		} else if (x1 == 1 && delX < -1) {
			canmove = false;
		} else if (x1 == 6 && delX > 1) {
			canmove = false;
		} else if (x1 == 7 && delX >= 0) {
			canmove = false;
		} else if (y1 == 0 && delY <= 0) {
			canmove = false;
		} else if (y1 == 1 && delY < -1) {
			canmove = false;
		} else if (y1 == 6 && delY > 1) {
			canmove = false;
		} else if (y1 == 7 && delY >= 0) {
			canmove = false;
		}
		return canmove;
	}

	/*
	 * should check if the destination is in the valid vicinity from selected
	 * piece and it also captures another piece
	 */

	/**
	 * Selects a square. If no Piece is active, selects the Piece and makes it
	 * active. If a Piece is active, performs a move if an empty place is
	 * selected. Else, allows you to reselect Pieces
	 * 
	 * @param x
	 *            X coordinate of place to select
	 * @param y
	 *            Y coordinate of place to select
	 */
	public void select(int x, int y) {

		if (canselectApiece) {
			drawbackground();
			StdDrawPlus.setPenColor(StdDrawPlus.WHITE);
			StdDrawPlus.filledSquare(x + .5, y + .5, .5);
			drawBoard();
			pieceselected = true;
			lastselctedX = x;
			lastselctedY = y; // update canselectApiece in move method

		} else if (canselectApiece == false) {
			// color the original space back to regular color
			if ((lastselctedX + lastselctedY) % 2 == 0) {
				StdDrawPlus.setPenColor(StdDrawPlus.GRAY);
				StdDrawPlus.filledSquare(lastselctedX + .5, lastselctedY + .5,
						.5);

			} else {
				StdDrawPlus.setPenColor(StdDrawPlus.RED);
				StdDrawPlus.filledSquare(lastselctedX + .5, lastselctedY + .5,
						.5);
			}
			Piece P = myPieces[lastselctedX][lastselctedY];
			move(P, lastselctedX, lastselctedY, x, y);
			
			drawBoard();
			lastselctedX = x;
			lastselctedY = y;
			// drawbackground();

		}

	}

	// YOUR CODE HERE

	/**
	 * Moves the active piece to coordinate (x, y)
	 * 
	 * @param p
	 *            Piece to move
	 * @param x1
	 *            Original X coordinate of p
	 * @param y1
	 *            Origin Y coordinate of p
	 * @param x2
	 *            X coordinate to move to
	 * @param y2
	 *            Y coordinate to move to
	 * 
	 *            update your instance verialbles...
	 */
	public void move(Piece P, int x1, int y1, int x2, int y2) {
		/*
		 * veriables to be updated are canselectApiece, moved, hasCaptured if
		 * (myRedPieces[avgX][avgY] != 0) { canmove = true;
		 * 
		 * }
		 */
		int delX = Math.abs(x2 - x1); // canselect makes sure valid move...
		int delY = Math.abs(y2 - y1); // canselect makes sure valid move...
		int avgX = (x2 + x1) / 2;
		int avgY = (y2 + y1) / 2;

		canselectApiece = false;
		moved = true;
		makeKing(P, y2);
		place(P, x2, y2);
		remove(x1, y1);
		if (delX == 2 && delY == 2) {
			remove(avgX, avgY);
			hasCaptured = true;
			P.startCapturing();
			P.explode(x2, y2);
		}
		drawbackground();
		drawBoard();
	}

	public void makeKing(Piece P, int y2) {
		if (P.getSide() == 0) {
			if (y2 == 7) {
				P.setKing(true);
			}
		} else if (P.getSide() == 1) {
			if (y2 == 0) {
				P.setKing(true);
			}
		}
	}

	/**
	 * Determines if the turn can end
	 * 
	 * @return true if the turn can end
	 */
	public boolean canEndTurn() {
		// YOUR CODE HERE
		boolean canEnd = false;
		if (moved == true || hasCaptured == true) {
			canEnd = true;
		}
		return canEnd;
	}

	/**
	 * Ends the current turn. Changes the player.
	 */
	public void endTurn() {
		// YOUR CODE HERE
		if (canEndTurn()) {
			reset();
		}

	}

	public void reset() {
		// lastselctedX = -1;
		// lastselctedY = -1;
		if (turn == 0) {
			turn = 1; // 0 for reds turn 1 for reds turn
		} else {
			turn = 0;
		}
		if (myPieces[lastselctedX][lastselctedY] != null) {
	      myPieces[lastselctedX][lastselctedY].finishCapturing();
		}
		canselectApiece = true; // false for no , true for yes; // update
		pieceselected = false; // after the player
		// has move a piece
		moved = false; // true if player has move already , false if he has
						// not
						// moved already
		hasCaptured = false; /*
							 * false if the player has not captured yet with
							 * piece the turn, true if player has
							 */
	}

	/**
	 * Returns the winner of the game
	 * 
	 * @return The winner of this game
	 */
	public String winner() {
		// YOUR CODE HERE
		String whowins = null;
		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (myPieces[i][j] != null) {

					if (myPieces[i][j].getSide() == 0) {
						count1++;
					}
					if (myPieces[i][j].getSide() == 1) {
						count2++;
					}
					if (count1 > 0 && count2 > 0) {
						return whowins;
					}
				}
			}
		}
		if (count1 > 0 && count2 == 0) {
			whowins = "Fire";
		} else if (count1 == 0 && count2 > 0) {
			whowins = "Water";
		} else if (count1 == 0 && count2 == 0) {
			whowins = "Tie";
		}

		return whowins;

	}

	public boolean gameover() {
		boolean over = false;
		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (myPieces[i][j] != null) {
					if (myPieces[i][j].getSide() == 0) {
						count1++;
					}
					if (myPieces[i][j].getSide() == 1) {
						count2++;
					}
					if (count1 > 0 && count2 > 0) {
						break;
					}
				}
			}
		}
		if (count1 == 0 || count2 == 0) {
			drawbackground();
			drawBoard();
			over = true;
			
		}
		return over;
	}

	public void runsGame() { // runs the whole game
		StdDrawPlus.setScale(0, 8);
		StdDrawPlus.show(10);
		drawBoard();
		while (true) {

			StdDrawPlus.show(10);
			if (StdDrawPlus.mousePressed()) {
				int x = (int) StdDrawPlus.mouseX();
				int y = (int) StdDrawPlus.mouseY();
				if (canSelect(x, y)) {
					select(x, y);
				}
			}
			if (StdDrawPlus.isSpacePressed()) {
				endTurn();
			}

			if (gameover()) {
				System.out.println("the Winner is " + winner());
				break;
			}
		}
	}

	private void drawBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (myPieces[i][j] != null) {
					if (myPieces[i][j].side() == 0) { // if it a red piece
						if (myPieces[i][j].getPiecetype() == 2) {
							StdDrawPlus.picture(i + .5, j + .5,
									"img/pawn-fire.png", 1, 1);
							if (myPieces[i][j].isKing() == true) {
								StdDrawPlus.picture(i + .5, j + .5,
										"img/pawn-fire-crowned.png", 1, 1);
							}
						} else if (myPieces[i][j].getPiecetype() == 0) {
							StdDrawPlus.picture(i + .5, j + .5,
									"img/shield-fire.png", 1, 1);
							if (myPieces[i][j].isKing() == true) {
								StdDrawPlus.picture(i + .5, j + .5,
										"img/shield-fire-crowned.png", 1, 1);
							}
						} else if (myPieces[i][j].getPiecetype() == 1) {
							StdDrawPlus.picture(i + .5, j + .5,
									"img/bomb-fire.png", 1, 1);

							if (myPieces[i][j].isKing() == true) {
								StdDrawPlus.picture(i + .5, j + .5,
										"img/bomb-fire-crowned.png", 1, 1); // kings...
							}
						}

					} else if (myPieces[i][j].side() == 1) { // if it a Blue
																// piece
						if (myPieces[i][j].getPiecetype() == 2) {
							StdDrawPlus.picture(i + .5, j + .5,
									"img/pawn-water.png", 1, 1);
							if (myPieces[i][j].isKing() == true) {
								StdDrawPlus.picture(i + .5, j + .5,
										"img/pawn-water-crowned.png", 1, 1);
							}
						} else if (myPieces[i][j].getPiecetype() == 0) {
							StdDrawPlus.picture(i + .5, j + .5,
									"img/shield-water.png", 1, 1);
							if (myPieces[i][j].isKing() == true) {
								StdDrawPlus.picture(i + .5, j + .5,
										"img/shield-water-crowned.png", 1, 1);
							}
						} else if (myPieces[i][j].getPiecetype() == 1) {
							StdDrawPlus.picture(i + .5, j + .5,
									"img/bomb-water.png", 1, 1);
							if (myPieces[i][j].isKing() == true) {
								StdDrawPlus.picture(i + .5, j + .5,
										"img/bomb-water-crowned.png", 1, 1);
							}
						}
					}
				}

			}
		}
	}

	/**
	 * Starts a game
	 */
	public static void main(String[] args) {
		// YOUR CODE HERE
		boolean notgamestart = false;
		StdDrawPlus.setScale(0, 8);
		Board B = new Board(notgamestart);
		B.runsGame();
	}
}
