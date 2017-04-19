package levonberberyan.chesstournamentorganizer.chesspiece;

public interface ChessPieceSymbolic {
	static int getXFromChessmanSymbolic(char letter){return 0;};
	static int getYFromChessmanSymbolic(char theOrderLetter){return 0;};
	static char convertAbstractChessmanToSymbolic(ChessPieceAbstract theChessman){return ' ';};
}
