package levonberberyan.chesstoolbylevon.chesspiece;

public class ChessPieceSymbolicForm {
	//*
	/**
	 * get X coordinate by piece symbol
	 * example: X=0 for 'a'
	 */
	public static int getXFromChessmanSymbolic(char letter){
		int xPos = 0;
		switch(letter){
			case 'a':{
				xPos = 0;
				break;
			}
			case 'b':{
				xPos = 1;
				break;
			}
			case 'c':{
				xPos = 2;
				break;
			}
			case 'd':{
				xPos = 3;
				break;
			}
			case 'e':{
				xPos = 4;
				break;
			}
			case 'f':{
				xPos = 5;
				break;
			}
			case 'g':{
				xPos = 6;
				break;
			}
			case 'h':{
				xPos = 7;
				break;
			}
		}
		return xPos;
	}
	/*
	 * get Y coordinate by piece order
	 * example: Y=7 for '1'
	 */
	public static int getYFromChessmanSymbolic(char theOrderLetter){
		return 8 - Character.getNumericValue(theOrderLetter);
	}
	/*
	 * Convert Abstract Chessman Type to Symbolic Chessman
	 */
	public static char convertAbstractChessmanToSymbolic(ChessPieceAbstractEnum theChessman){
		if(theChessman != null){
			if(theChessman.equals(ChessPieceAbstractEnum.WHITE_KING)){return 'K';}
			else if(theChessman.equals(ChessPieceAbstractEnum.BLACK_KING)){return 'k';}
			else if(theChessman.equals(ChessPieceAbstractEnum.WHITE_QUEEN)){return 'Q';}
			else if(theChessman.equals(ChessPieceAbstractEnum.BLACK_QUEEN)){return 'q';}
			else if(theChessman.equals(ChessPieceAbstractEnum.WHITE_ROOK)){return 'R';}
			else if(theChessman.equals(ChessPieceAbstractEnum.BLACK_ROOK)){return 'r';}
			else if(theChessman.equals(ChessPieceAbstractEnum.WHITE_BISHOP)){return 'B';}
			else if(theChessman.equals(ChessPieceAbstractEnum.BLACK_BISHOP)){return 'b';}
			else if(theChessman.equals(ChessPieceAbstractEnum.WHITE_KNIGHT)){return 'N';}
			else if(theChessman.equals(ChessPieceAbstractEnum.BLACK_KNIGHT)){return 'n';}
			else if(theChessman.equals(ChessPieceAbstractEnum.WHITE_PAWN)){return 'P';}
			else if(theChessman.equals(ChessPieceAbstractEnum.BLACK_PAWN)){return 'p';}
		}
		return 'o';
	}
}
