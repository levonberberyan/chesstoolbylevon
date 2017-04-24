package levonberberyan.chesstoolbylevon.chessmove;

import levonberberyan.chesstoolbylevon.chesspiece.ChessPieceAbstractEnum;

/**
 * @author Levon
 * Defines Chess Moves as chess piece Movement (using current position and target position coordinates) 
 * and it's type (movement, en passant, etc.).
 */

public class ChessMove implements ChessMoveI{
	/**
	 * Constructor
	 */
	public ChessMove(int theMoveSourceX, int theMoveSourceY, int theMoveDestinationX, int theMoveDestinationY, ChessPieceAbstractEnum theMoveChessPiece){
		setMoveCoordinates(theMoveSourceX, theMoveSourceY, theMoveDestinationX, theMoveDestinationY);
		setMoveChessPiece(theMoveChessPiece);
	}
	/**
	 * Move type Getter, Setter
	 */
	public void setMoveType(ChessMoveTypeEnum theChessMoveType){
		moveType = theChessMoveType;
	}
	public ChessMoveTypeEnum getMoveType(){
		return moveType;
	}
	/**
	 * Set Move Coordinates
	 */
	public void setMoveCoordinates(int theMoveSourceX, int theMoveSourceY, int theMoveDestinationX, int theMoveDestinationY){
		this.moveSourceX = theMoveSourceX;
		this.moveSourceY = theMoveSourceY;
		this.moveDestinationX = theMoveDestinationX;
		this.moveDestinationY = theMoveDestinationY;
	}
	/**
	 * Get move Coordinates
	 */
	public int getMoveSourceX() {return moveSourceX;}
	public int getMoveSourceY() {return moveSourceY;}
	public int getMoveDestinationX() {return moveDestinationX;}
	public int getMoveDestinationY() {return moveDestinationY;}
	/**
	 * Move ChessPiece getter, setter
	 */
	public void setMoveChessPiece(ChessPieceAbstractEnum theMoveChessPiece){this.moveChessPiece = theMoveChessPiece;}
	public ChessPieceAbstractEnum getMoveChessPiece(){return this.moveChessPiece;}
	/**
	 * Private fields
	 */
	private ChessMoveTypeEnum moveType;
	private ChessPieceAbstractEnum moveChessPiece;
	private int moveSourceX;
	private int moveSourceY;
	private int moveDestinationX;
	private int moveDestinationY;
}
