package levonberberyan.chesstoolbylevon.chessboard;

import java.util.ArrayList;
import java.util.List;

public class ActiveChessBoardsHandler implements ActiveChessBoards{
	/*
	 * Get Chess Engine By session Id
	 */
	public static ChessBoardI getActiveChessBoard(int theActiveBoardId){
		return getActiveChessBoards().get(theActiveBoardId);
	}
	/*
	 * Add New Chess Engine
	 */
	public static void addNewActiveChessBoard(ChessBoardI theChessBoard){
		getActiveChessBoards().add(theChessBoard);
		System.out.println("New Chess Board created Id: " + (getActiveChessBoards().size()-1));
	}
	/*
	 * Chess Engines getters, setters
	 */
	private static List<ChessBoardI> getActiveChessBoards() {
		return activeChessBoards;
	}
	/*
	 * List of Active Chess Boards
	 */
	private static List<ChessBoardI> activeChessBoards = new ArrayList<ChessBoardI>();
}
