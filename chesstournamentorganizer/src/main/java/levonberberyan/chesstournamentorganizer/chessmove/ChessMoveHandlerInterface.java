package levonberberyan.chesstournamentorganizer.chessmove;

import levonberberyan.chesstournamentorganizer.chessboard.ChessBoardI;

public interface ChessMoveHandlerInterface {
	static ChessMoveHandlerInterface convertSymbolicMoveToChessMove(String theSymbolicMove, ChessBoardI theChessBoard){return null;}
	static String uciMoveCalculationsToSymbolicMove(String theUciMoveCalculations){return null;}
	static boolean isValidMove(){return false;}
}
