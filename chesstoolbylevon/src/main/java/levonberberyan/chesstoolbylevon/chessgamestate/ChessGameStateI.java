package levonberberyan.chesstoolbylevon.chessgamestate;

import levonberberyan.chesstoolbylevon.chessboard.ChessBoardI;

public interface ChessGameStateI {
	void showInfo();
	
	ChessGameStateEndData getChessGameEndData();
	public void setChessGameEndData(ChessGameStateEndData theChessGameEndData);
	
	ChessBoardI getBoard();
	void setBoard(ChessBoardI theChessBoard);
}