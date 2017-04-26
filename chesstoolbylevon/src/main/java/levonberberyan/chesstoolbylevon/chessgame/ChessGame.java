package levonberberyan.chesstoolbylevon.chessgame;

import java.util.List;

import levonberberyan.chesstoolbylevon.chessgamestate.ChessGameState;

public class ChessGame {
	/*
	 * Default Constructor
	 */
	public ChessGame(){}
	/***
	 * Chess Game Current State Getter, Setter
	 */
	public ChessGameState getChessGameCurrentState(){return this.chessGameCurrentState;}
	public void setChessGameCurrentState(ChessGameState theChessGameState){this.chessGameCurrentState = theChessGameState;}
	/*
	 * Private
	 */
	private ChessGameState chessGameCurrentState = new ChessGameState();
	private List<ChessGameState> chessGameStates;
}
