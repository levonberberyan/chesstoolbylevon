package levonberberyan.chesstournamentorganizer.chessgamelog;

import levonberberyan.chesstoolbylevon.chessgamelog.FenParser;
import levonberberyan.chesstoolbylevon.chessgamestate.ChessGameStateI;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public final class FenParserTest {
	@Ignore
	@Before
	public void FenExtracting(){
		this.chessGame = FenParser.convertFenToChessGameState("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
		this.chessGame.showInfo();
		assertTrue(true);
	}
	//* improve test issues
	@Ignore
	@Test
	public void boardToFen(){System.out.println();
		ChessGameStateI aChessGame = new ChessGameStateI();
		String fen = FenParser.convertChessGameStateToFen(aChessGame);
		System.out.println("\n" + "FEN value:");
		System.out.println(fen);
		assertTrue(true);
	}
	
	private ChessGameStateI chessGame = new ChessGameStateI();
}
