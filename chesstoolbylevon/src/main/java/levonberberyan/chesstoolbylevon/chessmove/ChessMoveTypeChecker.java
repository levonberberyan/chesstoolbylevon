package levonberberyan.chesstoolbylevon.chessmove;

import levonberberyan.chesstoolbylevon.chessboard.ChessBoardI;

public class ChessMoveTypeChecker {
	/*
	 * Check Move Type
	 */
	public static ChessMoveTypeEnum checkMoveType(ChessMove theChessMove, ChessBoardI theBoardState){
		// *
		// 6 types of move effect:
		// 1) simple move (halfmoves and fullmoves number growth)
		// 2) simple attack move (halfmoves = 0, full move number growth)
		// 3) castling effect move (castling, king move, rooks move)
		// 4) en passant effect
		// 5) check effect move
		// 6) end effect move: checkmate, stalemate, giveup, halfmoves > 50
		
		return ChessMoveTypeEnum.MOVEMENT;
	}
	/*
	 * Check Move Type Using Stockfish
	 */
	public static ChessMoveTypeEnum checkMoveTypeForUCIMove(String theMoveInUciFormat, ChessBoardI theBoardState){
		// *We check UCI move output for movement, simple attack, promotion, en passant attack
		// castling attack using Stockfish abilities
				
		//*
		
		// *3 types of UCI move strings: others - a7a5; castling - e1g1; promotion - e7e8n
				if(theMoveInUciFormat.length() == 4){
					// castling move
					if(theMoveInUciFormat.equals("e1g1") || theMoveInUciFormat.equals("e1c1") ||	// for whites
							theMoveInUciFormat.equals("e8c8") || theMoveInUciFormat.equals("e8g8")){	// for blacks
						if(theMoveInUciFormat.equals("e1g1")){
							return ChessMoveTypeEnum.CASTLING_WHITES_KING_SIDE;
						} else if(theMoveInUciFormat.equals("e1c1")){
							return ChessMoveTypeEnum.CASTLING_WHITES_QUEEN_SIDE;
						} else if(theMoveInUciFormat.equals("e8c8")){
							return ChessMoveTypeEnum.CASTLING_BLACKS_QUEEN_SIDE;
						} else if(theMoveInUciFormat.equals("e8g8")){
							return ChessMoveTypeEnum.CASTLING_BLACKS_KING_SIDE;
						}
					}
					// simple move
					else {
						return ChessMoveTypeEnum.MOVEMENT;
					}
				} else{ // if 5
					// promotion move
					// promotion by e7e8q for promotion to queen or e7e8n for promotion to knight) 
					return ChessMoveTypeEnum.PROMOTION;
				}
				
		// *else for all if-s throw uci valid move exception
		return null;
	}
}
