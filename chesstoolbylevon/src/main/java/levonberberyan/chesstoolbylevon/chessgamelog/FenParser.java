package levonberberyan.chesstoolbylevon.chessgamelog;

import levonberberyan.chesstoolbylevon.chessboard.ChessBoardAsCharArray;
import levonberberyan.chesstoolbylevon.chessgame.ChessGameState;
import levonberberyan.chesstoolbylevon.chesspiece.ChessPieceAbstractEnum;
import levonberberyan.chesstoolbylevon.chesspiece.ChessPieceSymbolicForm;


/**
 * 
 * @author Levon
 * <p>Dependencies: ChessBoard, ChessGame</p>
 */
public final class FenParser {
	/*
	 * Convert Board fen to Chess Board Array
	 */
	public static ChessBoardAsCharArray convertBoardFenToChessBoardArr(String theBoardfen){
		// get board position from fen
		ChessBoardAsCharArray aChessBoard = new ChessBoardAsCharArray();
		int iterationIndex = 0;
		int x = 0; //board x-coordinate, horizontal
		int y = 0; //board y-coordinate, vertical
		while(theBoardfen.length() != iterationIndex){
			switch (theBoardfen.charAt(iterationIndex++)){
				case 'P': {
					aChessBoard.setChessPieceOnXYFromAbstractPiece(y, x, ChessPieceAbstractEnum.WHITE_PAWN);
					x++;if(x > 7) x -= 8;
					break;
				}
				case 'p': {
					aChessBoard.setChessPieceOnXYFromAbstractPiece(y, x, ChessPieceAbstractEnum.BLACK_PAWN);
					x++;if(x > 7) x -= 8;
					break;
				}
				case 'N': {
					aChessBoard.setChessPieceOnXYFromAbstractPiece(y, x, ChessPieceAbstractEnum.WHITE_KNIGHT);
					x++;if(x > 7) x -= 8;
					break;
				}
				case 'n': {
					aChessBoard.setChessPieceOnXYFromAbstractPiece(y, x, ChessPieceAbstractEnum.BLACK_KNIGHT);
					x++;if(x > 7) x -= 8;
					break;
				}
				case 'B': {
					aChessBoard.setChessPieceOnXYFromAbstractPiece(y, x, ChessPieceAbstractEnum.WHITE_BISHOP);
					x++;if(x > 7) x -= 8;
					break;
				}
				case 'b': {
					aChessBoard.setChessPieceOnXYFromAbstractPiece(y, x, ChessPieceAbstractEnum.BLACK_BISHOP);
					x++;if(x > 7) x -= 8;
					break;
				}
				case 'R': {
					aChessBoard.setChessPieceOnXYFromAbstractPiece(y, x, ChessPieceAbstractEnum.WHITE_ROOK);
					x++;if(x > 7) x -= 8;
					break;
				}
				case 'r': {
					aChessBoard.setChessPieceOnXYFromAbstractPiece(y, x, ChessPieceAbstractEnum.BLACK_ROOK);
					x++;if(x > 7) x -= 8;
					break;
				}
				case 'Q': {
					aChessBoard.setChessPieceOnXYFromAbstractPiece(y, x, ChessPieceAbstractEnum.WHITE_QUEEN);
					x++;if(x > 7) x -= 8;
					break;
				}
				case 'q': {
					aChessBoard.setChessPieceOnXYFromAbstractPiece(y, x, ChessPieceAbstractEnum.BLACK_QUEEN);
					x++;if(x > 7) x -= 8;
					break;
				}
				case 'K': {
					aChessBoard.setChessPieceOnXYFromAbstractPiece(y, x, ChessPieceAbstractEnum.WHITE_KING);
					x++;if(x > 7) x -= 8;
					break;
				}
				case 'k': {
					aChessBoard.setChessPieceOnXYFromAbstractPiece(y, x, ChessPieceAbstractEnum.BLACK_KING);
					x++;if(x > 7) x -= 8;
					break;
				}
				// case end of board line
				case '/': {
					y++;
					break;
				}
				// case integer, that says about number of empty following board boxes
				case '1': {
					x++;
					if(x > 7) x -= 8;
					break;
				}
				case '2': {
					x += 2;
					if(x > 7) x -= 8;
					break;
				}
				case '3': {
					x += 3;
					if(x > 7) x -= 8;
					break;
				}
				case '4': {
					x += 4;
					if(x > 7) x -= 8;
					break;
				}
				case '5': {
					x += 5;
					if(x > 7) x -= 8;
					break;
				}
				case '6': {
					x += 6;
					if(x > 7) x -= 8;
					break;
				}
				case '7': {
					x += 7;
					if(x > 7) x -= 8;
					break;
				}
				case '8': {
					x += 8;
					if(x > 7) x -= 8;
					break;
				}
			}
		}
		return aChessBoard;
	}
	/**
	 * Apply fen to chess game state
	 */
	public static void applyFenToChessGameState(String theFenString, ChessGameState theChessGameState){
		// *build regexp to validate fen
		System.out.println("FEN is: " + theFenString);
		
		// split fen string elements to analyze separately
		String[] aFenArray = theFenString.split(" ");
		
		// *check if fen array is valid
		if(aFenArray.length != 6 || aFenArray == null){
			System.out.println("Invalid fen: " + theFenString);
			return;
		}
		
		// get board position from fen
		int iterationIndex = 0;
		int x = 0; //board x-coordinate, horizontal
		int y = 0; //board y-coordinate, vertical
		while(aFenArray[0].length() != iterationIndex){
			switch (aFenArray[0].charAt(iterationIndex++)){
				case 'P': {
					theChessGameState.getBoard().setChessPieceOnXYFromAbstractPiece(y, x, ChessPieceAbstractEnum.WHITE_PAWN);
					x++;if(x > 7) x -= 8;
					break;
				}
				case 'p': {
					theChessGameState.getBoard().setChessPieceOnXYFromAbstractPiece(y, x, ChessPieceAbstractEnum.BLACK_PAWN);
					x++;if(x > 7) x -= 8;
					break;
				}
				case 'N': {
					theChessGameState.getBoard().setChessPieceOnXYFromAbstractPiece(y, x, ChessPieceAbstractEnum.WHITE_KNIGHT);
					x++;if(x > 7) x -= 8;
					break;
				}
				case 'n': {
					theChessGameState.getBoard().setChessPieceOnXYFromAbstractPiece(y, x, ChessPieceAbstractEnum.BLACK_KNIGHT);
					x++;if(x > 7) x -= 8;
					break;
				}
				case 'B': {
					theChessGameState.getBoard().setChessPieceOnXYFromAbstractPiece(y, x, ChessPieceAbstractEnum.WHITE_BISHOP);
					x++;if(x > 7) x -= 8;
					break;
				}
				case 'b': {
					theChessGameState.getBoard().setChessPieceOnXYFromAbstractPiece(y, x, ChessPieceAbstractEnum.BLACK_BISHOP);
					x++;if(x > 7) x -= 8;
					break;
				}
				case 'R': {
					theChessGameState.getBoard().setChessPieceOnXYFromAbstractPiece(y, x, ChessPieceAbstractEnum.WHITE_ROOK);
					x++;if(x > 7) x -= 8;
					break;
				}
				case 'r': {
					theChessGameState.getBoard().setChessPieceOnXYFromAbstractPiece(y, x, ChessPieceAbstractEnum.BLACK_ROOK);
					x++;if(x > 7) x -= 8;
					break;
				}
				case 'Q': {
					theChessGameState.getBoard().setChessPieceOnXYFromAbstractPiece(y, x, ChessPieceAbstractEnum.WHITE_QUEEN);
					x++;if(x > 7) x -= 8;
					break;
				}
				case 'q': {
					theChessGameState.getBoard().setChessPieceOnXYFromAbstractPiece(y, x, ChessPieceAbstractEnum.BLACK_QUEEN);
					x++;if(x > 7) x -= 8;
					break;
				}
				case 'K': {
					theChessGameState.getBoard().setChessPieceOnXYFromAbstractPiece(y, x, ChessPieceAbstractEnum.WHITE_KING);
					x++;if(x > 7) x -= 8;
					break;
				}
				case 'k': {
					theChessGameState.getBoard().setChessPieceOnXYFromAbstractPiece(y, x, ChessPieceAbstractEnum.BLACK_KING);
					x++;if(x > 7) x -= 8;
					break;
				}
				// case end of board line
				case '/': {
					y++;
					break;
				}
				// case integer, that says about number of empty following board boxes
				case '1': {
					x++;
					if(x > 7) x -= 8;
					break;
				}
				case '2': {
					x += 2;
					if(x > 7) x -= 8;
					break;
				}
				case '3': {
					x += 3;
					if(x > 7) x -= 8;
					break;
				}
				case '4': {
					x += 4;
					if(x > 7) x -= 8;
					break;
				}
				case '5': {
					x += 5;
					if(x > 7) x -= 8;
					break;
				}
				case '6': {
					x += 6;
					if(x > 7) x -= 8;
					break;
				}
				case '7': {
					x += 7;
					if(x > 7) x -= 8;
					break;
				}
				case '8': {
					x += 8;
					if(x > 7) x -= 8;
					break;
				}
			}
		}
		//chessBoard.show();
		
		// set board of game
		theChessGameState.setBoard(theChessGameState.getBoard());
		
		// get turn color from fen
		if(aFenArray[1].equals("w")){ 
			theChessGameState.getChessGameStateEffectsData().setIsWhitesTurn(true);
		}
		else {theChessGameState.getChessGameStateEffectsData().setIsWhitesTurn(false);}
		
		// get castling availability from fen
		String aCastlingSymbolic = aFenArray[2];
		if(aCastlingSymbolic.contains("K")){
			theChessGameState.getChessGameStateEffectsData().setIsWhitesKingSideCastlingAllowed(true);
		}
		if(aCastlingSymbolic.contains("Q")){
			theChessGameState.getChessGameStateEffectsData().setIsWhitesQueenSideCastlingAllowed(true);
		}
		if(aCastlingSymbolic.contains("k")){
			theChessGameState.getChessGameStateEffectsData().setIsBlacksKingSideCastlingAllowed(true);
		}
		if(aCastlingSymbolic.contains("q")){
			theChessGameState.getChessGameStateEffectsData().setIsBlacksQueenSideCastlingAllowed(true);
		}
		
		// get en Passant existence from fen
		theChessGameState.getChessGameStateEffectsData().setEnPassantSymbolicTarget(aFenArray[3]);
		
		// get Half-moves number from fen
		theChessGameState.getChessGameStateEndData().setHalfMovesNumber(Integer.parseInt(aFenArray[4]));
		
		// get Full-moves number from fen
		theChessGameState.getChessGameStateEndData().setFullMovesNumber(Integer.parseInt(aFenArray[5]));
	}
	/*
	 * Convert chess game state to fen
	 */
	public static String convertChessGameStateToFen(ChessGameState theChessGameState){
		String fen = "";
		
		// Add Board positions to fen
		int emptyCellsNumber = 0;
		for(int y = 0; y < 8; y++)
			for(int x = 0; x < 8; x++){
				if(theChessGameState.getBoard().getAbstractChessPieceatAtXY(y, x)!= null){
					if(theChessGameState.getBoard().getAbstractChessPieceatAtXY(y, x).equals(ChessPieceAbstractEnum.WHITE_ROOK) || 
						theChessGameState.getBoard().getAbstractChessPieceatAtXY(y, x).equals(ChessPieceAbstractEnum.WHITE_KNIGHT) ||
						theChessGameState.getBoard().getAbstractChessPieceatAtXY(y, x).equals(ChessPieceAbstractEnum.WHITE_BISHOP) ||
						theChessGameState.getBoard().getAbstractChessPieceatAtXY(y, x).equals(ChessPieceAbstractEnum.WHITE_PAWN) ||
						theChessGameState.getBoard().getAbstractChessPieceatAtXY(y, x).equals(ChessPieceAbstractEnum.WHITE_QUEEN) ||
						theChessGameState.getBoard().getAbstractChessPieceatAtXY(y, x).equals(ChessPieceAbstractEnum.WHITE_KING) ||
						theChessGameState.getBoard().getAbstractChessPieceatAtXY(y, x).equals(ChessPieceAbstractEnum.BLACK_ROOK) || 
						theChessGameState.getBoard().getAbstractChessPieceatAtXY(y, x).equals(ChessPieceAbstractEnum.BLACK_KNIGHT) ||
						theChessGameState.getBoard().getAbstractChessPieceatAtXY(y, x).equals(ChessPieceAbstractEnum.BLACK_BISHOP) ||
						theChessGameState.getBoard().getAbstractChessPieceatAtXY(y, x).equals(ChessPieceAbstractEnum.BLACK_PAWN) ||
						theChessGameState.getBoard().getAbstractChessPieceatAtXY(y, x).equals(ChessPieceAbstractEnum.BLACK_QUEEN) ||
						theChessGameState.getBoard().getAbstractChessPieceatAtXY(y, x).equals(ChessPieceAbstractEnum.BLACK_KING)){
					//System.out.println("Figure on (y,x)=" + y + "," + x + " is: " + theChessGame.getBoard().getFigureOnXY(y, x));
					if(emptyCellsNumber > 0){fen += emptyCellsNumber; emptyCellsNumber = 0;}
					fen += ChessPieceSymbolicForm.convertAbstractChessmanToSymbolic(theChessGameState.getBoard().getAbstractChessPieceatAtXY(y, x));
					}
				} else{
					emptyCellsNumber++;
				}
				if(x == 7 && y != 7){
					if(emptyCellsNumber > 0){fen += emptyCellsNumber; emptyCellsNumber = 0;}
					fen += "/";
				}
		}
		
		// add current turn color, white or black
		if(theChessGameState.getChessGameStateEffectsData().getIsWhitesTurn()){fen += " w";}else{fen += " b";}
		
		// add castling availability info
		String aCastlingAvailabilitySymbolic = "";
		
		if(theChessGameState.getChessGameStateEffectsData().getIsWhitesKingSideCastlingAllowed()){aCastlingAvailabilitySymbolic += "K";}
		if(theChessGameState.getChessGameStateEffectsData().getIsWhitesQueenSideCastlingAllowed()){aCastlingAvailabilitySymbolic += "Q";}
		if(theChessGameState.getChessGameStateEffectsData().getIsBlacksKingSideCastlingAllowed()){aCastlingAvailabilitySymbolic += "k";}
		if(theChessGameState.getChessGameStateEffectsData().getIsBlacksQueenSideCastlingAllowed()){aCastlingAvailabilitySymbolic += "q";}
		if(aCastlingAvailabilitySymbolic.equals("")){aCastlingAvailabilitySymbolic = "-";}
		
		fen += " " + aCastlingAvailabilitySymbolic;
		
		// add en passant existence info
		fen += " " + theChessGameState.getChessGameStateEffectsData().getEnPassantSymbolicTarget();
		
		// add Half-moves number info
		fen += " " + theChessGameState.getChessGameStateEndData().getHalfMovesNumber();
				
		// add Full-moves number info
		fen += " " + theChessGameState.getChessGameStateEndData().getFullMovesNumber();
				
		return fen;
	}
	/**
	 * Get start pos fen, without spending resources on calculation
	 */
	public static String getStartPosFen(){
		return FenParser.START_POSITION_FEN;
	}
	/**
	 * Fen of starting position
	 */
	private static final String START_POSITION_FEN = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
}
