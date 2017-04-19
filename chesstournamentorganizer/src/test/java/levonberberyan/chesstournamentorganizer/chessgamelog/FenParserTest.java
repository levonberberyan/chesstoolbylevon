package levonberberyan.chesstournamentorganizer.chessgamelog;

import levonberberyan.chesstournamentorganizer.chessgame.ChessGameI;
import levonberberyan.chesstournamentorganizer.chessgamelog.FenParser;

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
		ChessGameI aChessGame = new ChessGameI();
		String fen = FenParser.convertChessGameStateToFen(aChessGame);
		System.out.println("\n" + "FEN value:");
		System.out.println(fen);
		assertTrue(true);
	}
	
	private ChessGameI chessGame = new ChessGameI();
}
