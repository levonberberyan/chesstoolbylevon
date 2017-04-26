package levonberberyan.chesstoolbylevon.chessboard;

import levonberberyan.chesstoolbylevon.chesspiece.ChessPieceAbstractEnum;

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
}
