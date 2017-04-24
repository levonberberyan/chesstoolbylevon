package levonberberyan.chesstournamentorganizer.chessman;

import levonberberyan.chesstoolbylevon.chesspiece.ChessPieceAbstractEnum;
import levonberberyan.chesstoolbylevon.chesspiece.ChessPieceAbstractForm;
import levonberberyan.chesstoolbylevon.chesspiece.ChessPieceSymbolicForm;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChessmenTest {
	@Test
	public void chessmanTranformationTest(){
		System.out.println("X: " + ChessPieceSymbolicForm.getXFromChessmanSymbolic('a'));
		System.out.println("Y: " + ChessPieceSymbolicForm.getXFromChessmanSymbolic('6'));
		System.out.println("Symbolic Chessman: " + ChessPieceSymbolicForm.convertAbstractChessmanToSymbolic(ChessPieceAbstractEnum.BLACK_KING));
		System.out.println("Abstract Chessman: " + ChessPieceAbstractForm.convertSymbolicChessmanToAbstract('k').toString());
		assertTrue(true);
	}
}
