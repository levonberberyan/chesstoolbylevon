package levonberberyan.chesstournamentorganizer.chessenginesession;

import levonberberyan.chesstoolbylevon.chessengine.ChessEngineAsProcess;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

@Ignore
public class ChessEngineTest {
	@Before
	public void createNewChessEngineSessionTest(){
		ChessEngineAsProcess.createNewEngineSession("");
		assertTrue(true);
	}
	
	@Test
	public void writeAndReadFromChessEngine(){
		ChessEngineAsProcess.writeLineToEngine(0, "uci\n");
		String aLine = "";
		try{
			Thread.sleep(1000);
			while((aLine += ChessEngineAsProcess.readLineFromEngine(0)).indexOf("uciok") == -1){
			}
			System.out.println(aLine);
		} catch(InterruptedException theException){
			System.out.println("Problems trying to wait for a second");
			theException.printStackTrace();
		}
	}
	
	@After
	public void destroyChessEngineSession(){
		ChessEngineAsProcess.destroyEngineSession(0);
		assertTrue(true);
	}
}
