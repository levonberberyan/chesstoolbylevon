package levonberberyan.chesstoolbylevon.chessgamestate;

import java.io.IOException;

import levonberberyan.chesstoolbylevon.chessboard.ChessBoardI;
import levonberberyan.chesstoolbylevon.chessmove.ChessMove;

public final class ChessGameState{
	/*
	 * Register Chess Move for Game
	 */
	public boolean registerGameMove(ChessMove theChessMove) throws IOException, InterruptedException{	
		// *validate theChessMove for Game
		// if not normal return false
		
		// register move effects for game
		getChessGameStateEffectsData().registerGameEffects(theChessMove, this);
				
		// check end of game effects
		getChessGameStateEndData().registerEndOfGameEffects(theChessMove, this);
		
		// register move on game board
		theChessMove.registerMoveOnBoard(getBoard());
		
		// registered successful
		return true;
	}
	/**
	 * Show Info
	 */
	public void showInfo(){
		this.getBoard().showCurrentBoardState();
		this.getChessGameStateEffectsData().showInfo();
		this.getChessGameStateEndData().showInfo();
	}
	/**
	 * Default Constructor
	 */
	public ChessGameState(){
		//this.getBoard().initializeBoardState();
	}
	/**
	 * Getters, Setters
	 */
	//Chess Game Effects Data getter, setter
	public ChessGameStateEffectsData getChessGameStateEffectsData() {return chessGameStateEffectsData;}
	public void setChessGameStateEffectsData(ChessGameStateEffectsData theChessGameEffectsData) {this.chessGameStateEffectsData = theChessGameEffectsData;}
	//Chess Game End Data getter, setter
	public ChessGameStateEndData getChessGameStateEndData() {return chessGameStateEndData;}
	public void setChessGameStateEndData(ChessGameStateEndData theChessGameEndData) {this.chessGameStateEndData = theChessGameEndData;}
	//Chess Board getter, setter
	public ChessBoardI getBoard() {return this.chessBoard;}
	public void setBoard(ChessBoardI theChessBoard) {this.chessBoard = theChessBoard;}
	/**
	 * Private Fields
	 */
	//Chess Game Effects Data
	private ChessGameStateEffectsData chessGameStateEffectsData = new ChessGameStateEffectsData();
	//Chess Game End Data
	private ChessGameStateEndData chessGameStateEndData = new ChessGameStateEndData();
	//Game Board
	private ChessBoardI chessBoard;
}
