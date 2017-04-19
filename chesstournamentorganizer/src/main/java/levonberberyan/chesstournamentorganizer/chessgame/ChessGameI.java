package levonberberyan.chesstournamentorganizer.chessgame;

import java.io.IOException;

import levonberberyan.chesstournamentorganizer.chessboard.ChessBoardI;
import levonberberyan.chesstournamentorganizer.chessenginecommunication.UCIValidMoveException;

public interface ChessGameI {
	void play2EnginesGameUsingUCI(int engineId1, int engineId2, String aStartFen) throws IOException, InterruptedException, UCIValidMoveException;
	void initialize2EninesUsingUCI(int engineId1, int engineId2) throws IOException, InterruptedException;
	
	void showInfo();
	
	ChessGameEndData getChessGameEndData();
	public void setChessGameEndData(ChessGameEndData theChessGameEndData);
	
	ChessBoardI getBoard();
	void setBoard(ChessBoardI theChessBoard);
}
