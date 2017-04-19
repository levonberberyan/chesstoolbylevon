package levonberberyan.chesstournamentorganizer.chessgame;

import java.io.IOException;

import levonberberyan.chesstournamentorganizer.chessboard.ChessBoardI;
import levonberberyan.chesstournamentorganizer.chessboard.ChessBoardAsCharArray;
import levonberberyan.chesstournamentorganizer.chessenginecommunication.UCIChessEngineCommunicationHandler;
import levonberberyan.chesstournamentorganizer.chessenginecommunication.UCIValidMoveException;
import levonberberyan.chesstournamentorganizer.chessgamelog.FenParser;
import levonberberyan.chesstournamentorganizer.chessmove.ChessMove;
import levonberberyan.chesstournamentorganizer.chessmove.ChessMoveHandler;

public final class ChessGame implements ChessGameI{
	/*
	 * Register Chess Move for Game
	 */
	public boolean registerGameMove(ChessMove theChessMove) throws IOException, InterruptedException{	
		// *validate theChessMove for Game
		// if not normal return false
		
		// register move on game board
		getBoard().registerMove(theChessMove);
		
		// register move effects for game
		getChessGameEffectsData().registerGameEffects(theChessMove);
		
		// check end of game effects
		getChessGameEndData().registerEndOfGameEffects(theChessMove, this);
		
		// registered successful
		return true;
	}
	/**
	 * Play game of two players using UCIContacter, setting startpos //in future just PlayerContacter for universal protocol
	 */
	public void play2EnginesGameUsingUCI(int theEngineId1, int theEngineId2, String theStartFen) throws IOException, InterruptedException, UCIValidMoveException{			
		//initialise game board as char array
		chessBoard = new ChessBoardAsCharArray();
		
		// initialise 2 engines using UCI
		initialize2EninesUsingUCI(theEngineId1, theEngineId2);
		
		// playing engine fixing
		int aPlayingEngineId = theEngineId1; // engineId1 - is first player
		String aPlayingEngineName = "engineId1";
		
		// apply game state by start fen
		FenParser.convertFenToChessGameState(theStartFen, this);
		
		// show board at the start
		this.getBoard().showCurrentBoardState();
		
		// set current position fen as start position
		String currentPositionFen = theStartFen;
		
		// play until the end of game
		while(!getChessGameEndData().getIsEndOfGame()){
			// 0. Show current player info
			System.out.println("\n\n" + "New move by " + aPlayingEngineName + "\n");
			// 1. Inform current player about current game position using fen
			UCIChessEngineCommunicationHandler.sayPositionFen(aPlayingEngineId, currentPositionFen);
			// 2. Ask current player to calculate a move
			String aMoveCalculations = UCIChessEngineCommunicationHandler.getMoveCalculations(aPlayingEngineId);
			// 3. Extract and check move from calculations
			String aChessMoveString = UCIChessEngineCommunicationHandler.extractMoveFromCalculations(aMoveCalculations);
			// 4. Convert chess move String to ChessMove
			ChessMove aChessMove = ChessMoveHandler.convertSymbolicMoveToChessMove(aChessMoveString);
			// 5. Try to register chess move on board
			registerGameMove(aChessMove);
			// 6. show board after move
			this.chessBoard.showCurrentBoardState();
			// 7. change player
			if(aPlayingEngineId == theEngineId1){aPlayingEngineId = theEngineId2; aPlayingEngineName = "engineId2";} else{aPlayingEngineId = theEngineId1; aPlayingEngineName = "engineId1";}
			// 8. Convert game state after move to fen
			currentPositionFen = FenParser.convertChessGameStateToFen(this);
		}
		
		//close engines sessions
		UCIChessEngineCommunicationHandler.quit(theEngineId1);
		UCIChessEngineCommunicationHandler.quit(theEngineId2);
	}
	/**
	 * Initialise new game for 2 Engines with UCI protocol
	 */
	public void initialize2EninesUsingUCI(int engineId1, int engineId2) throws IOException, InterruptedException{
		// engine 1 set options
		UCIChessEngineCommunicationHandler.setProtocol(engineId1);
		// engine 1 checkReady();
		UCIChessEngineCommunicationHandler.setNewGame(engineId1);
		// engine 2 set options
		UCIChessEngineCommunicationHandler.setProtocol(engineId2);
		// engine 2 checkReady();
		UCIChessEngineCommunicationHandler.setNewGame(engineId2);
		
		// initialise chess Board
		this.setBoard(new ChessBoardAsCharArray());
	}
	/**
	 * Show Info
	 */
	public void showInfo(){
		System.out.println("Chess Game State Info:");
		System.out.println("\nCurrent Board State:");
		this.getBoard().showCurrentBoardState();
		System.out.println("\nTurn color boolean: " + chessGameEffectsData.getIsWhitesTurn());
	}
	/**
	 * Default Constructor
	 */
	public ChessGame(){
		this.getBoard().initializeBoardState();
	}
	/**
	 * Getters, Setters
	 */
	//Chess Game Effects Data getter, setter
	public ChessGameEffectsData getChessGameEffectsData() {return chessGameEffectsData;}
	public void setChessGameEffectsData(ChessGameEffectsData theChessGameEffectsData) {this.chessGameEffectsData = theChessGameEffectsData;}
	//Chess Game End Data getter, setter
	public ChessGameEndData getChessGameEndData() {return chessGameEndData;}
	public void setChessGameEndData(ChessGameEndData theChessGameEndData) {this.chessGameEndData = theChessGameEndData;}
	//Chess Board getter, setter
	public ChessBoardI getBoard() {return this.chessBoard;}
	public void setBoard(ChessBoardI theChessBoard) {this.chessBoard = theChessBoard;}
	/**
	 * Private Fields
	 */
	//Chess Game Effects Data
	private ChessGameEffectsData chessGameEffectsData;
	//Chess Game End Data
	private ChessGameEndData chessGameEndData;
	//Game Board
	private ChessBoardI chessBoard;
}
