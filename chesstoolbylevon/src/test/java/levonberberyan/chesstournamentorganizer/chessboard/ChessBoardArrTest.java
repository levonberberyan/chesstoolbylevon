package levonberberyan.chesstournamentorganizer.chessboard;

import levonberberyan.chesstoolbylevon.chessboard.ChessBoardAsCharArray;
import levonberberyan.chesstoolbylevon.chessboard.ChessBoardI;
import levonberberyan.chesstoolbylevon.chesspiece.ChessPieceAbstract;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChessBoardArrTest {
	@Test
	public void createBoardTest(){
		ChessBoardI chessBoard = new ChessBoardAsCharArray();
		ChessBoardI.create();
		chessBoard.setFigureOnXY(5, 5, ChessPieceAbstract.WHITE_KING);
		chessBoard.show();
		assertTrue(true);
	}
}
