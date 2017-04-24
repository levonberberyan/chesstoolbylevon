package levonberberyan.chesstoolbylevon.chessengine;

import java.util.ArrayList;
import java.util.List;

public class RunningChessEnginesHandler implements RunningChessEnginesHandlerI{
	/*
	 * Get Chess Engine By session Id
	 */
	public static ChessEngineI getChessEngine(int sessionId){
		return getChessEngines().get(sessionId);
	}
	/*
	 * Add New Chess Engine
	 */
	public static void addNewEngine(ChessEngineI theChessEngine){
		getChessEngines().add(theChessEngine);
		System.out.println("New Chess Engine Session created with Id: " + (getChessEngines().size()-1));
	}
	/*
	 * Chess Engines getters, setters
	 */
	private static List<ChessEngineI> getChessEngines() {
		return chessEngines;
	}
	/*
	 * List of Chess Engines
	 */
	private static List<ChessEngineI> chessEngines = new ArrayList<ChessEngineI>();
}
