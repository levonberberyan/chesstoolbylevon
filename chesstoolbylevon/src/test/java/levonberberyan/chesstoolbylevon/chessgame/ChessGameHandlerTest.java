package levonberberyan.chesstoolbylevon.chessgame;

import java.io.IOException;

import levonberberyan.chesstoolbylevon.chessboard.ChessBoardAsCharArray;
import levonberberyan.chesstoolbylevon.chessboard.ChessBoardI;
import levonberberyan.chesstoolbylevon.chessengine.ChessEngineAsProcess;
import levonberberyan.chesstoolbylevon.chessengine.ChessEngineI;
import levonberberyan.chesstoolbylevon.chessenginecommunication.UCIValidMoveException;
import levonberberyan.chesstoolbylevon.chessgamelog.FenParser;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChessGameHandlerTest {
	@Test
	public void playSimpleGameTest() throws IOException, InterruptedException, UCIValidMoveException{
		ChessEngineI aChessEngine1 = new ChessEngineAsProcess("");
		ChessEngineI aChessEngine2 = new ChessEngineAsProcess("");
		
		ChessBoardI aChessBoard = new ChessBoardAsCharArray();
		
		ChessGame aChessGame = new ChessGame();
		
		ChessGameHandler.play2EnginesGameUsingUCI(aChessEngine1, aChessEngine2, 
				aChessGame, aChessBoard, 
				FenParser.getStartPosFen());
		
		assertTrue(true);
	}
}
