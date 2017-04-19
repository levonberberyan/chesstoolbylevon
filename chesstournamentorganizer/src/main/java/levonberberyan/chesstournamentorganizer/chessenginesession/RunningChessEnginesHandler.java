package levonberberyan.chesstournamentorganizer.chessenginesession;

import java.util.ArrayList;
import java.util.List;

public class RunningChessEnginesHandler implements RunningChessEngines{
	/*
	 * Get Chess Engine By session Id
	 */
	public static ChessEngine getChessEngine(int sessionId){
		return getChessEngines().get(sessionId);
	}
	/*
	 * Add New Chess Engine
	 */
	public static void addNewEngine(ChessEngine theChessEngine){
		getChessEngines().add(theChessEngine);
		System.out.println("New Chess Engine Session created!");
		System.out.println("New Chess Engine Session Id: " + (getChessEngines().size()-1));
	}
	/*
	 * Chess Engines getters, setters
	 */
	private static List<ChessEngine> getChessEngines() {
		return chessEngines;
	}
	/*
	 * List of Chess Engines
	 */
	private static List<ChessEngine> chessEngines = new ArrayList<ChessEngine>();
}
