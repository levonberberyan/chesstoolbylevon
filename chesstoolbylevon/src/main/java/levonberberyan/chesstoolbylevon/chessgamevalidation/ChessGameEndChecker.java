package levonberberyan.chesstoolbylevon.chessgamevalidation;

import java.io.IOException;

import levonberberyan.chesstoolbylevon.chessengine.ChessEngineAsProcess;
import levonberberyan.chesstoolbylevon.chessengine.ChessEngineI;
import levonberberyan.chesstoolbylevon.chessenginecommunication.UCIChessEngineCommunicationHandler;
import levonberberyan.chesstoolbylevon.chessgame.ChessGameState;
import levonberberyan.chesstoolbylevon.chessgame.GameStatesEnum;
import levonberberyan.chesstoolbylevon.chessgamelog.FenParser;

public class ChessGameEndChecker {
	/**
	 * Check end of game after move using Stockfish response
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static GameStatesEnum checkIsEndOfGameUsingStockfish(ChessGameState theChessGameState){ //result is: normalMove or checkmate or stalemate
		//if stockfish, if ribka, if others
		
		// move calculations can end in 3 ways:
		// 1. simple move, example: bestmove a7a8 or bestmove bestmove d7d8N
		// 2. checkmate, example: mate 0 bestmove (none)
		// 3. drawn, like stalemate, perepetual check, etc.
				
		//* uci says only about checkmate, stalemate and simple move, so we should extend 
		//* uci no standardized “end of game”
		//stockfish: bestmove (none)
		//fruit and rybka: bestmove a1a1
		//Robolitto: bestmove NULL
				
		// We will check for simple move, checkmate and stalemate using Stockfish abilities
		
		ChessEngineI aChessEngine = new ChessEngineAsProcess();
		ChessEngineAsProcess.createNewEngineSession("/home/levon/Desktop/Stockfish/src/stockfish");
		UCIChessEngineCommunicationHandler aUciSession = new UCIChessEngineCommunicationHandler(aChessEngine);
		aUciSession.setProtocol();
		aUciSession.setNewGame();
		aUciSession.checkIsReady();
		
		aUciSession.setPositionFen(FenParser.convertChessGameStateToFen(theChessGameState));
		
		// check if simple move, bestmove and ponder contains for Stockfish UCI
		if(aUciSession.getMoveCalculations().contains("bestmove") && aUciSession.getMoveCalculations().contains("ponder")){
			return "gameInProcess";
		} 
		// check if stalemate, bestmove (none) for stockfish
		if(aUciSession.getMoveCalculations().contains("bestmove (none)")){
			return "stalemate";
		}
		// check if mate for Stockfish
		if(aUciSession.getMoveCalculations().contains("mate") && aUciSession.getMoveCalculations().contains("nodes")){
			// mate + 5 index to start after "mate " 
			String mateInfo = aUciSession.getMoveCalculations().substring(aUciSession.getMoveCalculations().indexOf("mate ") + 5, aUciSession.getMoveCalculations().indexOf(" nodes"));
			// register if mate, then mate in string with value 1
			if(mateInfo.contains("1")){
				return "mate";
			}
			//System.out.println("Mate in moves: " + mateInfo);
		}
		//*else for all if-s throw uci valid move exception
		return "error";
	}
}
