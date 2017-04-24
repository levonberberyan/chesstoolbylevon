package levonberberyan.chesstoolbylevon.chesspiece;

public enum ChessPieceAbstractEnum {
	WHITE_KING,
	WHITE_QUEEN,
	WHITE_ROOK,
	WHITE_BISHOP,
	WHITE_KNIGHT,
	WHITE_PAWN,
	BLACK_KING,
	BLACK_QUEEN,
	BLACK_ROOK,
	BLACK_BISHOP,
	BLACK_KNIGHT,
	BLACK_PAWN;
	
	/*
	public String toString(){
    	switch(this){
        	case WHITE_KING :
        		return "WHITE_KING";
        	case WHITE_QUEEN :
        		return "WHITE_QUEEN";
        	case WHITE_ROOK :
        		return "WHITE_ROOK";
        }
        return null;
    }

    public static ChessmenAbstractEnum valueOf(Class<ChessmenAbstractEnum> enumType, String value){
        if(value.equalsIgnoreCase(WHITE_KING.toString()))
            return ChessmenAbstractEnum.WHITE_KING;
        else if(value.equalsIgnoreCase(WHITE_QUEEN.toString()))
            return ChessmenAbstractEnum.WHITE_QUEEN;
        else if(value.equalsIgnoreCase(WHITE_ROOK.toString()))
            return ChessmenAbstractEnum.WHITE_ROOK;
        else
            return null;
    }
    */
}
