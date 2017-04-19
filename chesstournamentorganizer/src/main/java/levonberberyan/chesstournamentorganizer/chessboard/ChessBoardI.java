package levonberberyan.chesstournamentorganizer.chessboard;

import levonberberyan.chesstournamentorganizer.chessmove.ChessMove;
import levonberberyan.chesstournamentorganizer.chesspiece.ChessPieceAbstractEnum;

/**
 * Chess Board Dependencies: ChessMove, ChessPiece
 */

public interface ChessBoardI {
	ChessPieceAbstractEnum[][] getBoardAsAbstractPiecesMatrix();
	void setBoardFromAbstractPiecesMatrix(ChessPieceAbstractEnum[][] theBoardAbstractEnumMatrix);
	
	void initializeBoardState();
	
	ChessPieceAbstractEnum getAbstractChessPieceatAtXY(int theY, int theX);
	void setChessPieceOnXYFromAbstractPiece(int theY, int theX, ChessPieceAbstractEnum theChessman);
	
	void showCurrentBoardState();
	
	void registerMove(ChessMove theMove);
}
