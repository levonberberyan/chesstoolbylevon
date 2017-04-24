package levonberberyan.chesstournamentorganizer.chessgame;

import java.io.IOException;

import levonberberyan.chesstoolbylevon.chessengine.ChessEngineAsProcess;
import levonberberyan.chesstoolbylevon.chessenginecommunication.UCIChessEngineCommunicationHandler;
import levonberberyan.chesstoolbylevon.chessenginecommunication.UCIResponseFromChessEngineHandler;
import levonberberyan.chesstoolbylevon.chessgame.ChessGameStateI;
import levonberberyan.chesstoolbylevon.chessgamelog.FenParser;
import levonberberyan.chesstoolbylevon.chessmove.ChessMoveHandler;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChessGameTestOld {
	/*
	 * Test simpleAttackEffect
	 */
	@Ignore
	@Test
	public void checkWhitesSimpleMoveSimpleAttackEffectTest(){
		ChessGameStateI aChessGame = new ChessGameStateI();
		aChessGame = FenParser.convertFenToChessGameState("r3k3/8/8/8/3p4/8/2P5/4K3 w q - 0 1");
		
		System.out.println("Current Chess Game State Info:");
		aChessGame.showInfo();
		
		String aUciMove = "c2c3";
		ChessMoveHandler aChessMove = UCIResponseFromChessEngineHandler.convertUciMoveToChessMove(aUciMove, aChessGame.getBoard());
		
		System.out.println("\nChess Game Info After move: ");
		aChessGame.checkSimpleAttackEffectAfterMove(aChessMove);
		aChessGame.showInfo();
		
		assertTrue(true);
	}
	
	@Ignore
	@Test
	public void checkBlacksSimpleAttackEffectTest(){
		ChessGameStateI aChessGame = new ChessGameStateI();
		aChessGame = FenParser.convertFenToChessGameState("r3k3/8/8/8/3p4/2P5/8/4K3 b q - 0 1");
		
		System.out.println("Current Chess Game State Info:");
		aChessGame.showInfo();
		
		String aUciMove = "d4c3";
		ChessMoveHandler aChessMove = UCIResponseFromChessEngineHandler.convertUciMoveToChessMove(aUciMove, aChessGame.getBoard());
		
		System.out.println("\nChess Game Info After move: ");
		aChessGame.checkSimpleAttackEffectAfterMove(aChessMove);
		aChessGame.showInfo();
		
		assertTrue(true);
	}
	/*
	 * Test checkCastlingEffect
	 */
	@Ignore
	@Test
	public void checkWhitesKingMoveCastlingEffectTest(){
		ChessGameStateI aChessGame = new ChessGameStateI();
		aChessGame = FenParser.convertFenToChessGameState("r3k2r/8/8/8/8/8/8/R3K2R w KQkq - 0 1");
		
		System.out.println("Current Chess Game State Castling Info:");
		aChessGame.showCastlingInfo();
		
		String aUciMove = "e1e2";
		ChessMoveHandler aChessMove = UCIResponseFromChessEngineHandler.convertUciMoveToChessMove(aUciMove, aChessGame.getBoard());
		
		System.out.println("\nChess Game Castling Info After move: ");
		aChessGame.checkCastlingEffectAfterMove(aChessMove);
		aChessGame.showCastlingInfo();
		
		assertTrue(true);
	}
	
	@Ignore
	@Test
	public void checkWhitesRookMoveCastlingEffectTest(){
		ChessGameStateI aChessGame = new ChessGameStateI();
		aChessGame = FenParser.convertFenToChessGameState("r3k3/8/8/8/8/8/8/R3K2R w KQq - 0 1");
		
		System.out.println("Board state before move:");
		aChessGame.getBoard().show();
		System.out.println("Current Chess Game State Castling Info:");
		aChessGame.showCastlingInfo();
		
		String aUciMove = "a1a2";
		ChessMoveHandler aChessMove = UCIResponseFromChessEngineHandler.convertUciMoveToChessMove(aUciMove, aChessGame.getBoard());
		
		System.out.println("\nChess Game Castling Info After move: ");
		aChessGame.checkCastlingEffectAfterMove(aChessMove);
		aChessGame.showCastlingInfo();
		
		assertTrue(true);
	}
	
	@Ignore
	@Test
	public void checkBlacksCastlingMoveEffectTest(){
		ChessGameStateI aChessGame = new ChessGameStateI();
		aChessGame = FenParser.convertFenToChessGameState("r3k3/8/8/8/8/8/1P6/4K3 b q - 0 1");
		
		System.out.println("Board state before move:");
		aChessGame.getBoard().show();
		System.out.println("Current Chess Game State Castling Info:");
		aChessGame.showCastlingInfo();
		
		String aUciMove = "e8c8";
		ChessMoveHandler aChessMove = UCIResponseFromChessEngineHandler.convertUciMoveToChessMove(aUciMove, aChessGame.getBoard());
		
		System.out.println("\nChess Game Castling Info After move: ");
		aChessGame.checkCastlingEffectAfterMove(aChessMove);
		aChessGame.showCastlingInfo();
		
		assertTrue(true);
	}
	/*
	 * Test checkEnPassantEffect
	 */
	@Ignore
	@Test
	public void checkWhitesPawnMoveEnPassantEffectTest(){
		ChessGameStateI aChessGame = new ChessGameStateI();
		aChessGame = FenParser.convertFenToChessGameState("4k3/8/8/8/2p5/8/1P6/4K3 w - - 0 1");
		
		System.out.println("Board state before move:");
		aChessGame.getBoard().show();
		System.out.println("Current Chess Game State En Passant Info:");
		aChessGame.showEnPassantInfo();
		
		String aUciMove = "b2b4";
		ChessMoveHandler aChessMove = UCIResponseFromChessEngineHandler.convertUciMoveToChessMove(aUciMove, aChessGame.getBoard());
		
		System.out.println("\nChess Game En Passant Info After move: ");
		aChessGame.checkEnPassantEffectAfterMove(aChessMove);
		aChessGame.showEnPassantInfo();
		
		assertTrue(true);
	}
	
	@Ignore
	@Test
	public void checkWhitesEnPassantAttackEffectTest(){
		ChessGameStateI aChessGame = new ChessGameStateI();
		aChessGame = FenParser.convertFenToChessGameState("4k3/8/8/1Pp5/8/8/8/4K3 w - c6 0 1");
			
		System.out.println("Board state before move:");
		aChessGame.getBoard().show();
		System.out.println("Current Chess Game State En Passant Info:");
		aChessGame.showEnPassantInfo();
			
		String aUciMove = "b5c6";
		ChessMoveHandler aChessMove = UCIResponseFromChessEngineHandler.convertUciMoveToChessMove(aUciMove, aChessGame.getBoard());
		
		System.out.println("\nChess Game En Passant Info After move: ");
		aChessGame.checkEnPassantEffectAfterMove(aChessMove);
		System.out.println("Board state after move:");
		aChessGame.getBoard().show();
		aChessGame.showEnPassantInfo();
			
		assertTrue(true);
	}
	
	@Ignore
	@Test
	public void checkBlacksPawnMoveEnPassantEffectTest(){
		ChessGameStateI aChessGame = new ChessGameStateI();
		aChessGame = FenParser.convertFenToChessGameState("4k3/2p5/8/1P6/8/8/8/4K3 b - - 0 1");
		
		System.out.println("Board state before move:");
		aChessGame.getBoard().show();
		System.out.println("Current Chess Game State En Passant Info:");
		aChessGame.showEnPassantInfo();
		
		String aUciMove = "c7c5";
		ChessMoveHandler aChessMove = UCIResponseFromChessEngineHandler.convertUciMoveToChessMove(aUciMove, aChessGame.getBoard());
		
		System.out.println("\nChess Game En Passant Info After move: ");
		aChessGame.checkEnPassantEffectAfterMove(aChessMove);
		aChessGame.showEnPassantInfo();
		
		assertTrue(true);
	}
	
	@Ignore
	@Test
	public void checkBlacksEnPassantAttackEffectTest(){
		ChessGameStateI aChessGame = new ChessGameStateI();
		aChessGame = FenParser.convertFenToChessGameState("4k3/8/8/8/1Pp5/8/8/4K3 b - b3 0 1");
			
		System.out.println("Board state before move:");
		aChessGame.getBoard().show();
		System.out.println("Current Chess Game State En Passant Info:");
		aChessGame.showEnPassantInfo();
			
		String aUciMove = "c4b3";
		ChessMoveHandler aChessMove = UCIResponseFromChessEngineHandler.convertUciMoveToChessMove(aUciMove, aChessGame.getBoard());
		
		System.out.println("\nChess Game En Passant Info After move: ");
		aChessGame.checkEnPassantEffectAfterMove(aChessMove);
		System.out.println("Board state after move:");
		aChessGame.getBoard().show();
		aChessGame.showEnPassantInfo();
			
		assertTrue(true);
	}
	/*
	 * Test register move
	 */
	@Ignore
	@Test
	public void registerWhitesSimpleMove() throws IOException, InterruptedException{
		ChessGameStateI aChessGame = new ChessGameStateI();
		aChessGame = FenParser.convertFenToChessGameState("r3k3/8/8/8/3p4/8/2P5/4K3 w q - 0 1");
		
		System.out.println("Current Chess Game State Info:");
		aChessGame.showInfo();
		
		String aUciMove = "c2c3";
		ChessMoveHandler aChessMove = UCIResponseFromChessEngineHandler.convertUciMoveToChessMove(aUciMove, aChessGame.getBoard());
		
		System.out.println("\nChess Game Info After move: ");
		aChessGame.registerMove(aChessMove);
		aChessGame.showInfo();
		
		assertTrue(true);
	}
	/*
	 * Play game test
	 */
	@Ignore
	@Test
	public void playSimpleGameTest() throws IOException, InterruptedException{
		// Run chess engine from file-program
		ChessEngineAsProcess ep1 = new ChessEngineAsProcess("/home/levon/Desktop/Stockfish/src/stockfish");
		ChessEngineAsProcess ep2 = new ChessEngineAsProcess("/home/levon/Desktop/Stockfish/src/stockfish");
		//"C:/chesstmp/stockfish.exe"
		//"/home/levon/Desktop/Stockfish/src/stockfish"
				
		// Contact to chess engine started as a process
		//UCIRequestHandler e1 = new UCIRequestHandler(ep1.getChessEngine());
		//UCIRequestHandler e2 = new UCIRequestHandler(ep2.getChessEngine());
				
		// Run a chessgame
		ChessGameStateI tGame = new ChessGameStateI();
		//tGame.play(e1, e2, "6k1/8/8/5p2/6p1/6qp/8/7K w - - 0 1"); //FenParser.getStartPosFen()
		
		//*test for stalemate
		//*test for standard
				
		assertTrue(true);
	}
}
