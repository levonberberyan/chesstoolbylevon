package levonberberyan.chesstoolbylevon.chessgamevalidation;

import levonberberyan.chesstoolbylevon.chessengine.ChessEngineAsProcess;
import levonberberyan.chesstoolbylevon.chessengine.ChessEngineI;
import levonberberyan.chesstoolbylevon.chessenginecommunication.UCIChessEngineCommunicationHandler;
import levonberberyan.chesstoolbylevon.chessgame.GameStatesEnum;
import levonberberyan.chesstoolbylevon.chessgamelog.FenParser;
import levonberberyan.chesstoolbylevon.chessgamestate.ChessGameState;

public class ChessGameEndChecker {
	/*
	 * Check end of game after move using Stockfish response
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static GameStatesEnum checkIsEndOfGameUsingStockfish(ChessGameState theChessGameState){ 
		//result is: normalMove or checkmate or stalemate
		// move calculations can end in 3 ways:
		// 1. simple move, example: bestmove a7a8 or bestmove bestmove d7d8N
		// 2. checkmate, example: mate 0 bestmove (none)
		// 3. drawn, like stalemate, perepetual check, etc.
				
		//* uci says only about checkmate, stalemate and simple move, so we should extend 
		//* uci no standardized “end of game”
		
		// Initialize Stockfish
		ChessEngineI aChessEngine = new ChessEngineAsProcess("");
		UCIChessEngineCommunicationHandler.setProtocol(aChessEngine);
		UCIChessEngineCommunicationHandler.setNewGame(aChessEngine);
		UCIChessEngineCommunicationHandler.checkIsReady(aChessEngine);
		
		// Say current game state FEN
		UCIChessEngineCommunicationHandler.sayPositionFen(aChessEngine, FenParser.convertChessGameStateToFen(theChessGameState));
		
		// We will check for simple move, checkmate and stalemate using Stockfish abilities
		
		String aUciMoveCalculations = UCIChessEngineCommunicationHandler.getMoveCalculations(aChessEngine);
		
		// check if simple move (bestmove and ponder contains for Stockfish UCI)
		if(aUciMoveCalculations.contains("bestmove") && UCIChessEngineCommunicationHandler.getMoveCalculations(aChessEngine).contains("ponder")){
			return GameStatesEnum.GAME_IN_PROGRESS;
		} 
		
		// check if stalemate (bestmove (none) for stockfish)
		if(aUciMoveCalculations.contains("bestmove (none)")){
			return GameStatesEnum.STALEMATE;
		}
		
		// check if checkmate for Stockfish
		if(aUciMoveCalculations.contains("mate") && UCIChessEngineCommunicationHandler.getMoveCalculations(aChessEngine).contains("nodes")){
			// mate + 5 index to start after "mate " 
			String mateInfo = UCIChessEngineCommunicationHandler.getMoveCalculations(aChessEngine).substring(UCIChessEngineCommunicationHandler.getMoveCalculations(aChessEngine).indexOf("mate ") + 5, UCIChessEngineCommunicationHandler.getMoveCalculations(aChessEngine).indexOf(" nodes"));
			// register if mate, then mate in string with value 1
			if(mateInfo.contains("1")){
				return GameStatesEnum.CHECKMATE;
			}
			//System.out.println("Mate in moves: " + mateInfo);
		}
		
		// *else for all if-s throw uci valid move exception
		return null;
	}
}
