package levonberberyan.chesstournamentorganizer.chessgamelog;

import levonberberyan.chesstournamentorganizer.chessboard.ChessBoardAsCharArray;
import levonberberyan.chesstournamentorganizer.chessgame.ChessGame;
import levonberberyan.chesstournamentorganizer.chesspiece.ChessPieceAbstractEnum;
import levonberberyan.chesstournamentorganizer.chesspiece.ChessPieceSymbolicForm;


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
	 * Convert fen to chess board arr state
	 */
	public static void convertFenToChessGameState(String fenString, ChessGame theChessGame){
		// *build regexp to validate fen
		
		// split fen string elements to analyze separately
		String[] fenArray = fenString.split(" ");
		
		// check if fen is valid
		if(fenArray.length != 6 || fenArray == null){
			System.err.println("Invalid fen: " + fenString);
			//return null;
		}
		
		// create a chess game
		ChessGame aChessGame = new ChessGame();
		// create a chess board
		ChessBoardAsCharArray aChessBoard = new ChessBoardAsCharArray();
		
		// get board position from fen
		int iterationIndex = 0;
		int x = 0; //board x-coordinate, horizontal
		int y = 0; //board y-coordinate, vertical
		while(fenArray[0].length() != iterationIndex){
			switch (fenArray[0].charAt(iterationIndex++)){
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
		//chessBoard.show();
		
		// set board of game
		aChessGame.setBoard(aChessBoard);
		
		// get turn color from fen
		if(fenArray[1].equals("w")) aChessGame.getChessGameEffectsData().setIsWhitesTurn(true);
		else aChessGame.getChessGameEffectsData().setIsWhitesTurn(false);
		
		// get castling availability from fen
		String aCastlingSymbolic = fenArray[2];
		if(aCastlingSymbolic.contains("K")){
			aChessGame.getChessGameEffectsData().setIsWhitesKingSideCastlingAllowed(true);
		}
		if(aCastlingSymbolic.contains("Q")){
			aChessGame.getChessGameEffectsData().setIsWhitesQueenSideCastlingAllowed(true);
		}
		if(aCastlingSymbolic.contains("k")){
			aChessGame.getChessGameEffectsData().setIsBlacksKingSideCastlingAllowed(true);
		}
		if(aCastlingSymbolic.contains("q")){
			aChessGame.getChessGameEffectsData().setIsBlacksQueenSideCastlingAllowed(true);
		}
		
		// get en Passant existence from fen
		aChessGame.getChessGameEffectsData().setEnPassantSymbolicTarget(fenArray[3]);
		
		// get Half-moves number from fen
		aChessGame.getChessGameEndData().setHalfMovesNumber(Integer.parseInt(fenArray[4]));
		
		// get Full-moves number from fen
		aChessGame.getChessGameEndData().setFullMovesNumber(Integer.parseInt(fenArray[5]));
		
		//chessBoard.showInfo();
		
		theChessGame = aChessGame;
		//return aChessGame;
	}
	/*
	 * Convert chess game state to fen
	 */
	public static String convertChessGameStateToFen(ChessGame theChessGame){
		String fen = "";
		
		// Add Board positions to fen
		int emptyCellsNumber = 0;
		for(int y = 0; y < 8; y++)
			for(int x = 0; x < 8; x++){
				if(theChessGame.getBoard().getAbstractChessPieceatAtXY(y, x)!= null){
					if(theChessGame.getBoard().getAbstractChessPieceatAtXY(y, x).equals(ChessPieceAbstractEnum.WHITE_ROOK) || 
						theChessGame.getBoard().getAbstractChessPieceatAtXY(y, x).equals(ChessPieceAbstractEnum.WHITE_KNIGHT) ||
						theChessGame.getBoard().getAbstractChessPieceatAtXY(y, x).equals(ChessPieceAbstractEnum.WHITE_BISHOP) ||
						theChessGame.getBoard().getAbstractChessPieceatAtXY(y, x).equals(ChessPieceAbstractEnum.WHITE_PAWN) ||
						theChessGame.getBoard().getAbstractChessPieceatAtXY(y, x).equals(ChessPieceAbstractEnum.WHITE_QUEEN) ||
						theChessGame.getBoard().getAbstractChessPieceatAtXY(y, x).equals(ChessPieceAbstractEnum.WHITE_KING) ||
						theChessGame.getBoard().getAbstractChessPieceatAtXY(y, x).equals(ChessPieceAbstractEnum.BLACK_ROOK) || 
						theChessGame.getBoard().getAbstractChessPieceatAtXY(y, x).equals(ChessPieceAbstractEnum.BLACK_KNIGHT) ||
						theChessGame.getBoard().getAbstractChessPieceatAtXY(y, x).equals(ChessPieceAbstractEnum.BLACK_BISHOP) ||
						theChessGame.getBoard().getAbstractChessPieceatAtXY(y, x).equals(ChessPieceAbstractEnum.BLACK_PAWN) ||
						theChessGame.getBoard().getAbstractChessPieceatAtXY(y, x).equals(ChessPieceAbstractEnum.BLACK_QUEEN) ||
						theChessGame.getBoard().getAbstractChessPieceatAtXY(y, x).equals(ChessPieceAbstractEnum.BLACK_KING)){
					//System.out.println("Figure on (y,x)=" + y + "," + x + " is: " + theChessGame.getBoard().getFigureOnXY(y, x));
					if(emptyCellsNumber > 0){fen += emptyCellsNumber; emptyCellsNumber = 0;}
					fen += ChessPieceSymbolicForm.convertAbstractChessmanToSymbolic(theChessGame.getBoard().getAbstractChessPieceatAtXY(y, x));
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
		if(theChessGame.getChessGameEffectsData().getIsWhitesTurn()){fen += " w";}else{fen += " b";}
		
		// add castling availability info
		String aCastlingAvailabilitySymbolic = "";
		
		if(theChessGame.getChessGameEffectsData().getIsWhitesKingSideCastlingAllowed()){aCastlingAvailabilitySymbolic += "K";}
		if(theChessGame.getChessGameEffectsData().getIsWhitesQueenSideCastlingAllowed()){aCastlingAvailabilitySymbolic += "Q";}
		if(theChessGame.getChessGameEffectsData().getIsBlacksKingSideCastlingAllowed()){aCastlingAvailabilitySymbolic += "k";}
		if(theChessGame.getChessGameEffectsData().getIsBlacksQueenSideCastlingAllowed()){aCastlingAvailabilitySymbolic += "q";}
		if(aCastlingAvailabilitySymbolic.equals("")){aCastlingAvailabilitySymbolic = "-";}
		
		fen += " " + aCastlingAvailabilitySymbolic;
		
		// add en passant existence info
		fen += " " + theChessGame.getChessGameEffectsData().getEnPassantSymbolicTarget();
		
		// add Half-moves number info
		fen += " " + theChessGame.getChessGameEndData().getHalfMovesNumber();
				
		// add Full-moves number info
		fen += " " + theChessGame.getChessGameEndData().getFullMovesNumber();
				
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
