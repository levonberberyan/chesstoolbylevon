package levonberberyan.chesstournamentorganizer.chessgame;

import levonberberyan.chesstournamentorganizer.chessmove.ChessMove;

public class ChessGameEndData implements ChessGameEndDataI{
	/*
	 * Register end of game data after move
	 */
	public void registerEndOfGameEffects(ChessMove theChessMove, ChessGame theChessGameState){
		// *increment half moves number
		
		// *increment full moves number after blacks move
		
		// *check if checkmate
		// depending on turn color set who wins
		if(ChessGameEndChecker.checkIsEndOfGameUsingStockfish(theChessGameState).equals(GameStatesEnum.CHECKMATE)){
			//
			setIsEndOfGame(true);
		}
		
		// *check if stalemate
		else if(ChessGameEndChecker.checkIsEndOfGameUsingStockfish(theChessGameState).equals(GameStatesEnum.STALEMATE)){
			//
			setIsEndOfGame(true);
		}
	}
	/*
	 * Full moves number getter, setter
	 * The number increments after every black move
	 */
	public int getFullMovesNumber() {return this.fullMovesNumber;}
	public void setFullMovesNumber(int aFullMovesNumer) {this.fullMovesNumber = aFullMovesNumer;}
	public void incrementFullMovesNumber() {this.fullMovesNumber++;}
	/*
	 * Half moves number getter, setter, increment halfmoves number
	 * If attack move halfmoves number = 0
	 * If half moves number reached 50 then drawn
	 */
	public int getHalfMovesNumber() {return halfMovesNumber;}
	public void setHalfMovesNumber(int theHalfMovesNumber) {halfMovesNumber = theHalfMovesNumber;}
	public void incrementHalfMovesNumber(){halfMovesNumber++;}
	/**
	 * isStalemate getter, setter
	 */
	public boolean getIsStalemate(){return isStalemate;}
	public void setIsStalemate(boolean theIsStalemate){isStalemate = theIsStalemate;}
	/**
	 * isCheckmate getter, setter
	 */
	public boolean getIsCheckmate(){return isCheckmate;}
	public void setIsCheckmate(boolean theIsCheckmate){isCheckmate = theIsCheckmate;}
	/**
	 * isEndOfGame getter, setter
	 */
	public boolean getIsEndOfGame() {return isEndOfGame;}
	public void setIsEndOfGame(boolean theIsEndOfGame) {isEndOfGame = theIsEndOfGame;}
	/**
	 * gameResult getter, setter
	 */
	public GameStatesEnum getGameResult(){return gameResult;}
	public void setGameResult(GameStatesEnum theGameResult){gameResult = theGameResult;}
	/**
	 * Private End Indicators
	 */
	private GameStatesEnum gameResult;
	private boolean isEndOfGame = false;
	private boolean isCheckmate = false;
	private boolean isStalemate = false;
	private int fullMovesNumber = 0;
	private int halfMovesNumber = 0;
}
