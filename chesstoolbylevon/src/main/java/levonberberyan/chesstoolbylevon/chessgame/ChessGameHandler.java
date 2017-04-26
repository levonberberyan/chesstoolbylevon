package levonberberyan.chesstoolbylevon.chessgame;

import java.io.IOException;

import levonberberyan.chesstoolbylevon.chessboard.ChessBoardI;
import levonberberyan.chesstoolbylevon.chessengine.ChessEngineI;
import levonberberyan.chesstoolbylevon.chessenginecommunication.UCIChessEngineCommunicationHandler;
import levonberberyan.chesstoolbylevon.chessenginecommunication.UCIValidMoveException;
import levonberberyan.chesstoolbylevon.chessgamelog.FenParser;
import levonberberyan.chesstoolbylevon.chessmove.ChessMove;
import levonberberyan.chesstoolbylevon.chessmove.ChessMoveHandler;

public class ChessGameHandler {
	/**
	 * Play game of two players using UCIContacter, setting startpos //in future just PlayerContacter for universal protocol
	 */
	public static void play2EnginesGameUsingUCI(ChessEngineI theChessEngine1, ChessEngineI theChessEngine2, ChessGame theChessGame, ChessBoardI theChessBoard, String theStartFen) throws IOException, InterruptedException, UCIValidMoveException{				
		// initialise 2 engines using UCI
		initialize2EninesUsingUCI(theChessEngine1, theChessEngine2);
		
		// set game board
		theChessGame.getChessGameCurrentState().setBoard(theChessBoard);
		
		// playing engine fixing
		ChessEngineI aPlayingEngineId = theChessEngine1; // theChessEngine1 - is first player
		String aPlayingEngineName = "Engine1";
		
		// apply game state by start fen
		FenParser.applyFenToChessGameState(theStartFen, theChessGame.getChessGameCurrentState());
		
		// show board at the start
		theChessGame.getChessGameCurrentState().getBoard().showCurrentBoardState();
		
		// set current position fen as start position
		String currentPositionFen = theStartFen;
		
		// play until the end of game
		while(!theChessGame.getChessGameCurrentState().getChessGameStateEndData().getIsEndOfGame()){
			// 0. Show current player info
			System.out.println("\n\n" + "Game move by " + aPlayingEngineName + "\n");
			// 1. Inform current player about current game position using fen
			UCIChessEngineCommunicationHandler.sayPositionFen(aPlayingEngineId, currentPositionFen);
			// 2. Ask current player to calculate a move
			String aMoveCalculations = UCIChessEngineCommunicationHandler.getMoveCalculations(aPlayingEngineId);
			// 3. Extract and check move from calculations
			String aChessMoveString = UCIChessEngineCommunicationHandler.extractMoveFromCalculations(aMoveCalculations);
			// 4. Convert chess move String to ChessMove
			ChessMove aChessMove = ChessMoveHandler.convertUCIMoveStringToChessMove(aChessMoveString, theChessBoard);
			// 5. Try to register chess move on board
			theChessGame.getChessGameCurrentState().registerGameMove(aChessMove);
			// 6. show board after move
			theChessGame.getChessGameCurrentState().getBoard().showCurrentBoardState();
			// 7. change player
			if(aPlayingEngineId == theChessEngine1){aPlayingEngineId = theChessEngine2; aPlayingEngineName = "Engine2";} else{aPlayingEngineId = theChessEngine1; aPlayingEngineName = "Engine1";}
			// 8. Convert game state after move to fen
			currentPositionFen = FenParser.convertChessGameStateToFen(theChessGame.getChessGameCurrentState());
		}
		
		//close engines sessions
		UCIChessEngineCommunicationHandler.quit(theChessEngine1);
		UCIChessEngineCommunicationHandler.quit(theChessEngine2);
	}
	/**
	 * Initialise new game for 2 Engines with UCI protocol
	 */
	public static void initialize2EninesUsingUCI(ChessEngineI theChessEngine1, ChessEngineI theChessEngine2) throws IOException, InterruptedException{
		// engine 1 set options
		UCIChessEngineCommunicationHandler.setProtocol(theChessEngine1);
		// engine 1 checkReady();
		UCIChessEngineCommunicationHandler.setNewGame(theChessEngine1);
		// engine 2 set options
		UCIChessEngineCommunicationHandler.setProtocol(theChessEngine2);
		// engine 2 checkReady();
		UCIChessEngineCommunicationHandler.setNewGame(theChessEngine2);
	}
}
