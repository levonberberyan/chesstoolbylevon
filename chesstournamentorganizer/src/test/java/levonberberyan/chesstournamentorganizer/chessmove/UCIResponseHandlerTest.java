package levonberberyan.chesstournamentorganizer.chessmove;

import java.io.IOException;

import levonberberyan.chesstournamentorganizer.chessboard.ChessBoardI;
import levonberberyan.chesstournamentorganizer.chessboard.ChessBoardAsCharArray;
import levonberberyan.chesstournamentorganizer.chessenginecommunication.UCIResponseFromChessEngineHandler;
import levonberberyan.chesstournamentorganizer.chessenginecommunication.UCIValidMoveException;
import levonberberyan.chesstournamentorganizer.chessgame.ChessGameI;
import levonberberyan.chesstournamentorganizer.chessgamelog.FenParser;
import levonberberyan.chesstournamentorganizer.chessmove.ChessMoveHandler;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class UCIResponseHandlerTest {
	/*
	 * Test Extract UCI Move
	 */
	@Ignore
	@Test
	public void extractUCIMove() throws UCIValidMoveException{
		String move = UCIResponseFromChessEngineHandler.extractMove("h2g3 f7e6 g3f4 e6d5 f4g4 d5d4 g4g5 d4c3 g5f6" +
				" c3c2 f6e7 c2c3 e7f6info nodes 25115 time 11bestmove h2g3 ponder f7e6");
		System.out.println("UCI move is: " + move);
		assertTrue(true);
	}
	/*
	 * Test Convert UCI Move to Chess Move
	 */
	@Ignore
	@Test
	public void convertSimpleUciMoveToChessMoveTest(){
		// some simple move
		String aUciMove = "d2d4";
		
		// board at start position
		ChessBoardI aChessBoard = new ChessBoardAsCharArray();
		aChessBoard.initialize();
		
		ChessMoveHandler aChessMove = UCIResponseFromChessEngineHandler.convertUciMoveToChessMove(aUciMove, aChessBoard);
		System.out.println("Board state before the UCI Move " + aUciMove + ":");
		aChessMove.getBoardStateBefore().show();
		System.out.println("Board state after the UCI Move " + aUciMove + ":");
		aChessMove.getBoardStateAfter().show();
		
		assertTrue(true);
	}
	
	@Ignore
	@Test
	public void convertCastlingUciMoveToChessMoveTest(){
		// some simple move
		String aUciMove = "e1c1";
		
		// board at start position
		ChessGameI aChessGame = new ChessGameI();
		aChessGame = FenParser.convertFenToChessGameState("r4k2/8/8/8/8/8/8/R3K3 w Q - 0 1");
		
		ChessMoveHandler aChessMove = UCIResponseFromChessEngineHandler.convertUciMoveToChessMove(aUciMove, aChessGame.getBoard());
		System.out.println("Board state before the UCI Move " + aUciMove + ":");
		aChessMove.getBoardStateBefore().show();
		System.out.println("Board state after the UCI Move " + aUciMove + ":");
		aChessMove.getBoardStateAfter().show();
		
		assertTrue(true);
	}
	
	@Ignore
	@Test
	public void convertPromotionUciMoveToChessMoveTest(){
		// some simple move
		String aUciMove = "b7b8q";
		
		// board at start position
		ChessGameI aChessGame = new ChessGameI();
		aChessGame = FenParser.convertFenToChessGameState("8/1P4k1/8/8/8/8/8/4K3 w - - 0 1");
		
		ChessMoveHandler aChessMove = UCIResponseFromChessEngineHandler.convertUciMoveToChessMove(aUciMove, aChessGame.getBoard());
		System.out.println("Board state before the UCI Move " + aUciMove + ":");
		aChessMove.getBoardStateBefore().show();
		System.out.println("Board state after the UCI Move " + aUciMove + ":");
		aChessMove.getBoardStateAfter().show();
		
		assertTrue(true);
	}
	/*
	 * Test End of Game Checking using Stockfish
	 */
	@Ignore
	@Test
	public void checkEndOfSimpleGameUsingStockfish() throws IOException, InterruptedException{
		ChessGameI aChessGame = new ChessGameI();
		aChessGame = FenParser.convertFenToChessGameState("r3k3/8/8/8/3p4/8/2P5/4K3 w q - 0 1");
		
		System.out.println("Current Chess Game State Info:");
		aChessGame.showInfo();
		
		System.out.println("\nEnd of Game Info: ");
		String endOfGameInfo = UCIResponseFromChessEngineHandler.checkEndOfGameUsingStockfish(aChessGame);
		System.out.println(endOfGameInfo);
		
		assertTrue(true);
	}
	
	@Ignore
	@Test
	public void checkEndOfStalemateGameUsingStockfish() throws IOException, InterruptedException{
		ChessGameI aChessGame = new ChessGameI();
		aChessGame = FenParser.convertFenToChessGameState("7k/5K2/6Q1/8/8/8/8/8 b - - 0 1");
		
		System.out.println("Current Chess Game State Info:");
		aChessGame.showInfo();
		
		System.out.println("\nEnd of Game Info: ");
		String endOfGameInfo = UCIResponseFromChessEngineHandler.checkEndOfGameUsingStockfish(aChessGame);
		System.out.println(endOfGameInfo);
		
		assertTrue(true);
	}
	
	//* improve, shows stalemate instead of checkmate or eats a king
	@Ignore
	@Test
	public void checkEndOfCheckmateGameUsingStockfish() throws IOException, InterruptedException{
		ChessGameI aChessGame = new ChessGameI();
		aChessGame = FenParser.convertFenToChessGameState("2pkb3/2pp4/8/8/7Q/8/8/4K3 b - - 0 1");
		
		System.out.println("Current Chess Game State Info:");
		aChessGame.showInfo();
		
		System.out.println("\nEnd of Game Info: ");
		String endOfGameInfo = UCIResponseFromChessEngineHandler.checkEndOfGameUsingStockfish(aChessGame);
		System.out.println(endOfGameInfo);
		
		assertTrue(true);
	}
}
