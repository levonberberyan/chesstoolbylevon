package tmp;

import java.io.IOException;

import levonberberyan.chesstournamentorganizer.chessengine.ChessEngineProcess;
import levonberberyan.chesstournamentorganizer.chessprotocol.UCIRequestHandler;

/*
 * In future this class functions should be connected to MoveValidator
 */
public final class EndOfGameCheckerUsingEngine {
	/*
	 * Default constructor that runs external chess engine to detect end of chess game
	 */
	public EndOfGameCheckerUsingEngine(String EnginePath) throws IOException, InterruptedException{
		ChessEngineProcess echeckerEngine = new ChessEngineProcess("C:/chesstmp/stockfish.exe");
		//"C:/chesstmp/stockfish.exe"
		//"/home/levon/Desktop/Stockfish/src/stockfish"
		//this.uciEngineContacter = new UCIRequestHandler(echeckerEngine.getChessEngineProcess());
		this.uciEngineContacter.setProtocol();
		this.uciEngineContacter.checkReady();
		this.uciEngineContacter.setNewGame();
	}
	/*
	 * End of game checker using fen game state
	 */
	public EndGameValues isEndOfGame(String fen) throws IOException, InterruptedException{
		this.uciEngineContacter.setPositionFen(fen);
		String engineResponseLines = this.uciEngineContacter.calculateMove();
		// check if stalemate
		if(engineResponseLines.indexOf("bestmove (none)") != -1) // or info depth 0
			return EndGameValues.Stalemate;
		// if not the end of game
		return EndGameValues.NotTheEnd;
	}
	/*
	 * UCI chess engine contacter
	 */
	private UCIRequestHandler uciEngineContacter;
}

/*
 * Enumeration of possible end of game states
*/
enum EndGameValues{
	Checkmate,
	Stalemate,
	NotTheEnd;
}
