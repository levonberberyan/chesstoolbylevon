package levonberberyan.chesstournamentorganizer.chessman;

import levonberberyan.chesstoolbylevon.chesspiece.ChessPieceAbstractEnum;
import levonberberyan.chesstoolbylevon.chesspiece.ChessPieceAbstractHandler;
import levonberberyan.chesstoolbylevon.chesspiece.ChessPieceSymbolicHandler;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChessmenTest {
	@Test
	public void chessmanTranformationTest(){
		System.out.println("X: " + ChessPieceSymbolicHandler.getXFromChessmanSymbolic('a'));
		System.out.println("Y: " + ChessPieceSymbolicHandler.getXFromChessmanSymbolic('6'));
		System.out.println("Symbolic Chessman: " + ChessPieceSymbolicHandler.convertAbstractChessmanToSymbolic(ChessPieceAbstractEnum.BLACK_KING));
		System.out.println("Abstract Chessman: " + ChessPieceAbstractHandler.convertSymbolicChessmanToAbstract('k').toString());
		assertTrue(true);
	}
}
