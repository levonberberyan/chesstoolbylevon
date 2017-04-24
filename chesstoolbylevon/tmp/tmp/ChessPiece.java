package tmp;

/*
 * Abstract class to implements Chess Piece
 */
public abstract class ChessPiece {
	// Piece color
	public boolean color; // true for white
	
	// Piece alias on board
	String pieceAlias;
	
	// Move validation for piece (check rules)
	protected abstract boolean isValidMove(int yFrom, int xFrom, int yTo, int xTo, boolean hasAttacks);
}

/*
 * King Chess Piece class
 */
final class King extends ChessPiece {
	// King piece constructor by color
	public King(boolean color) {
		this.color = color;
		this.pieceAlias = (color) ? "K" : "k";
	}
	
	// Override isValidMove to detect if King do valid move 
	@Override
	protected boolean isValidMove(int yFrom, int xFrom, int yTo, int xTo, boolean hasAttacks) {
		// King can move one space in any direction
		return (Math.abs(yFrom - yTo) <= 1 &&
				Math.abs(xFrom - xTo) <= 1);
	}
}

/*
 * Queen Chess Piece class
 */
class Queen extends ChessPiece {
	// Queen piece constructor by color
	public Queen(boolean color) {
		this.color = color;
		this.pieceAlias = (color) ? "Q" : "q";
	}
	// Override isValidMove to detect if Queen do valid move 
	@Override
	protected boolean isValidMove(int yFrom, int xFrom, int yTo, int xTo, boolean hasAttacks) {
		// Queen can move vertically, horizontally, diagonally any number of spaces in any direction
		return 
				//Vertical or horizontal movement, only y changes, or only x changes
				((yFrom == yTo && xFrom != xTo) || (yFrom != yTo && xFrom == xTo))
				//Diagonally movement
				|| (Math.abs(yTo - yFrom) == Math.abs(xTo - xFrom));
	}
}

/*
 * Rook Chess Piece class
 */
class Rook extends ChessPiece {
	// Rook piece constructor by color
	public Rook(boolean color) {
		this.color = color;
		this.pieceAlias = (color) ? "R" : "r";
	}
	// Override isValidMove to detect if Rook do valid move 
	@Override
	protected boolean isValidMove(int yFrom, int xFrom, int yTo, int xTo, boolean hasAttacks) {
		//Rook can move vertically, horizontally any number of spaces in any direction, only y changes, or only x changes
		return (yFrom == yTo && xFrom != xTo) || (yFrom != yTo && xFrom == xTo);
	}
}

/*
 * Bishop Chess Piece class
 */
class Bishop extends ChessPiece {
	// Bishop piece constructor by color
	public Bishop(boolean color) {
		this.color = color;
		this.pieceAlias = (color) ? "B" : "b";
	}
	// Override isValidMove to detect if Rook do valid move 
	@Override
	protected boolean isValidMove(int yFrom, int xFrom, int yTo, int xTo, boolean hasAttacks) {
		//Bishop can move diagonally
		return Math.abs(yTo - yFrom) == Math.abs(xTo - xFrom);
	}
}

/*
 * Knight Chess Piece class
 */
class Knight extends ChessPiece {
	// Knight piece constructor by color
	public Knight(boolean color) {
		this.color = color;
		this.pieceAlias = (color) ? "N" : "n";
	}
	// Override isValidMove to detect if Knight do valid move 
	@Override
	protected boolean isValidMove(int yFrom, int xFrom, int yTo, int xTo, boolean hasAttacks) {
		//Knight can move as russian letter g
		return (Math.abs(yTo - yFrom) == 1 && Math.abs(xTo - xFrom) == 2)
				|| (Math.abs(yTo - yFrom) == 2 && Math.abs(xTo - xFrom) == 1);
	}
}

/*
 * Enumeration for Pawn attack possibility, validating move more correctly
 */
/* enum PawnAttacks{
	LEFT,
	RIGHT,
	BOTH_SIDES,
	ABSENT;
}*/

/*
 * Implement isValidMove function with dynamic number of params
 * for Pawn hasAttacks param
 */

/*
 * Pawn Chess Piece class
 */
final class Pawn extends ChessPiece{
	// Is it first move for pawn
	private boolean firstMove;
	
	// Pawn piece constructor by color
	public Pawn(boolean color){
		this.color = color;
		this.pieceAlias = (color) ? "P" : "p";
		this.firstMove = true;
	}
	
	// Override isValidMove to detect Pawn valid moves
	protected boolean isValidMove(int yFrom, int xFrom, int yTo, int xTo, boolean hasAttacks) {
		// Pawn should always move forward
		boolean validDirection = (this.color) ? (yTo <= yFrom) : (yFrom <= yTo);
		if(!validDirection) return false;
		
		// If first move can move two spaces, if attack can move diagonally
		return // first move conditions
				((this.firstMove) ? (Math.abs(yFrom - yTo) == 2) || (Math.abs(yFrom - yTo) == 1) : 
					(Math.abs(yFrom - yTo) == 1))
				// hasAttacks conditions
				&& ((hasAttacks && Math.abs(yFrom - yTo) == 1 && Math.abs(xFrom - xTo) == 1) 
						|| !hasAttacks && xFrom == xTo);
	}
}
