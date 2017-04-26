package levonberberyan.chesstoolbylevon.chesspiece;

public class ChessPieceAbstractHandler {
	/*
	 * Convert Symbolic Chess Piece to Chess Piece Type
	 */
	public static ChessPieceAbstractEnum convertSymbolicChessPieceToAbstract(char theChessmanSymbolic){
		if(theChessmanSymbolic == 'K'){return ChessPieceAbstractEnum.WHITE_KING;}
		if(theChessmanSymbolic == 'k'){return ChessPieceAbstractEnum.BLACK_KING;}
		if(theChessmanSymbolic == 'Q'){return ChessPieceAbstractEnum.WHITE_QUEEN;}
		if(theChessmanSymbolic == 'q'){return ChessPieceAbstractEnum.BLACK_QUEEN;}
		if(theChessmanSymbolic == 'R'){return ChessPieceAbstractEnum.WHITE_ROOK;}
		if(theChessmanSymbolic == 'r'){return ChessPieceAbstractEnum.BLACK_ROOK;}
		if(theChessmanSymbolic == 'B'){return ChessPieceAbstractEnum.WHITE_BISHOP;}
		if(theChessmanSymbolic == 'b'){return ChessPieceAbstractEnum.BLACK_BISHOP;}
		if(theChessmanSymbolic == 'N'){return ChessPieceAbstractEnum.WHITE_KNIGHT;}
		if(theChessmanSymbolic == 'n'){return ChessPieceAbstractEnum.BLACK_KNIGHT;}
		if(theChessmanSymbolic == 'P'){return ChessPieceAbstractEnum.WHITE_PAWN;}
		if(theChessmanSymbolic == 'p'){return ChessPieceAbstractEnum.BLACK_PAWN;}
		else return null;
	}
}
