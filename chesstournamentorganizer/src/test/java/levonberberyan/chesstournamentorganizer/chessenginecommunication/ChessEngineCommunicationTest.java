package levonberberyan.chesstournamentorganizer.chessenginecommunication;

import levonberberyan.chesstournamentorganizer.chessenginesession.ChessEngineAsProcess;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

@Ignore
public class ChessEngineCommunicationTest {
	@Test
	public void startNewGame(){
		System.out.println("Set Protocol Response: " + UCIChessEngineCommunicationHandler.setProtocol(0));
		UCIChessEngineCommunicationHandler.setNewGame(0);
		if(UCIChessEngineCommunicationHandler.checkIsReady(0)) 
			System.out.println("New Game Initialization: OK");
		else System.out.println("New Game Initialization: Error");
		System.out.println("Move Calculations: " + UCIChessEngineCommunicationHandler.getMoveCalculations(0));
		UCIChessEngineCommunicationHandler.setPositionFen(0, "rnbqkbnr/pppppppp/8/8/4P3/8/PPPP1PPP/RNBQKBNR b KQkq e3 0 1");
		System.out.println("Move Calculations After New Game State: " + UCIChessEngineCommunicationHandler.getMoveCalculations(0));
		UCIChessEngineCommunicationHandler.quit(0);
		assertTrue(true);
	}
	
	@Before
	public void createEngineSession(){
		ChessEngineAsProcess.createNewEngineSession("");
	}
}
