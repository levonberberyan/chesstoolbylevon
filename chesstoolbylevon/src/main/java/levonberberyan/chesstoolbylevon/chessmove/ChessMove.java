package levonberberyan.chesstoolbylevon.chessmove;

import levonberberyan.chesstoolbylevon.chessboard.ChessBoardI;
import levonberberyan.chesstoolbylevon.chesspiece.ChessPieceAbstractEnum;
import levonberberyan.chesstoolbylevon.chesspiece.ChessPieceAbstractHandler;
import levonberberyan.chesstoolbylevon.chesspiece.ChessPieceSymbolicHandler;

/**
 * @author Levon
 * Defines Chess Moves as chess piece Movement (using current position and target position coordinates) 
 * and it's type (movement, en passant, etc.).
 */

public class ChessMove implements ChessMoveI{
	/*
	 * Register Chess Move On Board
	 */
	public void registerMoveOnBoard(ChessBoardI theBoard){
		//coordinates
		int startX = this.getMoveSourceX();
		int startY = this.getMoveSourceY();
		int destinationX = this.getMoveDestinationX();
		int destinationY = this.getMoveDestinationY();
		
		//chess piece
		char aChessPieceChar = ChessPieceSymbolicHandler.convertAbstractChessPieceToSymbolic(this.getMoveChessPiece());
		
		// *do actions according to move type
		switch(this.getMoveType()){
			case MOVEMENT:{
				theBoard.setChessPieceOnXYFromAbstractPiece(destinationY, destinationX, ChessPieceAbstractHandler.convertSymbolicChessPieceToAbstract(aChessPieceChar));
				theBoard.setChessPieceOnXYFromAbstractPiece(startY, startX, ChessPieceAbstractHandler.convertSymbolicChessPieceToAbstract('o'));
				break;
			}
			case SIMPLE_ATTACK:
				break;
			case EN_PASSANT_ATTACK:
				break;
			case PROMOTION:
				break;
			case CASTLING_BLACKS_KING_SIDE:
				break;
			case CASTLING_BLACKS_QUEEN_SIDE:
				break;
			case CASTLING_WHITES_KING_SIDE:
				break;
			case CASTLING_WHITES_QUEEN_SIDE:
				break;
			case CHECK_EFFECT:
				break;
			default:
				break;	
		}
	}
	/**
	 * Constructors
	 */
	public ChessMove(int theMoveSourceX, int theMoveSourceY, int theMoveDestinationX, int theMoveDestinationY, ChessPieceAbstractEnum theMoveChessPiece, ChessBoardI theBoardState){
		setMoveCoordinates(theMoveSourceX, theMoveSourceY, theMoveDestinationX, theMoveDestinationY);
		setMoveChessPiece(theMoveChessPiece);
		
		// *check the move type
		setMoveType(ChessMoveTypeChecker.checkMoveType(this, theBoardState));
	}
	public ChessMove(ChessBoardI theBoardState){
		// *check the move type
		setMoveType(ChessMoveTypeChecker.checkMoveType(this, theBoardState));
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
	 * Promotion Type Getter, Setter
	 */
	public PromotionTypeEnum getPromotionType(){return this.promotionType;}
	public void setPromotionType(PromotionTypeEnum thePromtionType){this.promotionType = thePromtionType;}
	/**
	 * Private fields
	 */
	private ChessMoveTypeEnum moveType;
	private PromotionTypeEnum promotionType = PromotionTypeEnum.NONE;
	private String enPassantSymbolicTarget = "-";
	private ChessPieceAbstractEnum moveChessPiece;
	private int moveSourceX;
	private int moveSourceY;
	private int moveDestinationX;
	private int moveDestinationY;
}
