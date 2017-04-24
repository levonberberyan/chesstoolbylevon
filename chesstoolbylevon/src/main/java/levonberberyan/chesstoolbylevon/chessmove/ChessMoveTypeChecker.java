package levonberberyan.chesstoolbylevon.chessmove;

import levonberberyan.chesstoolbylevon.chessboard.ChessBoardAsCharArray;
import levonberberyan.chesstoolbylevon.chessboard.ChessBoardI;
import levonberberyan.chesstoolbylevon.chessgamevalidation.GameMoveTypeEnum;
import levonberberyan.chesstoolbylevon.chesspiece.ChessPieceAbstract;
import levonberberyan.chesstoolbylevon.chesspiece.ChessPieceAbstractEnum;
import levonberberyan.chesstoolbylevon.chesspiece.ChessPieceSymbolicForm;

public class ChessMoveTypeChecker {
	public static ChessMoveTypeEnum checkMoveType(ChessMove theChessMove){
		// 6 types of move effect:
		// 1) simple move (halfmoves and fullmoves number growth)
		// 2) simple attack move (halfmoves = 0, full move number growth)
		// 3) castling effect move (castling, king move, rooks move)
		// 4) en passant effect
		// 5) check effect move
		// 6) end effect move: checkmate, stalemate, giveup, halfmoves > 50
		
		return null;
	}
	
	/*
	 * 
	 */
	public static ChessMoveHandler convertSymbolicMoveToChessMove(String theSymbolicMove, ChessBoardI theChessBoard){
		// if stockfish, if ribka, if others
		// we will check for stockfish
		
		// chess move var
		ChessMoveHandler aChessMove = new ChessMoveHandler();
		
		// fix the state of board before move
		aChessMove.setBoardStateBefore(theChessBoard);
		
		// chess board state after move var
		ChessBoardI aChessBoardAfterMove = new ChessBoardAsCharArray();
		aChessBoardAfterMove.setBoardMatrix(theChessBoard.getBoardMatrix());
		
		// 3 types of move: simple - a7a5; castling - e1g1; promotion - e7e8n
		if(theSymbolicMove.length() == 4){
			// castling move
			// castling is done by the kingmove e.g.: e1g1 or e8c8,
			if(theSymbolicMove.equals("e1g1") || theSymbolicMove.equals("e1c1") ||	// for whites
					theSymbolicMove.equals("e8c8") || theSymbolicMove.equals("e8g8")){	// for blacks
				if(theSymbolicMove.equals("e1g1")){
					aChessMove.setType(GameMoveTypeEnum.CASTLING_WHITES_KING_SIDE);
					
					aChessBoardAfterMove.registerSymbolicMove("e1g1");
					aChessBoardAfterMove.registerSymbolicMove("h1f1");
					aChessMove.setBoardStateAfter(aChessBoardAfterMove);
				} else if(theSymbolicMove.equals("e1c1")){
					aChessMove.setType(GameMoveTypeEnum.CASTLING_WHITES_QUEEN_SIDE);
					
					aChessBoardAfterMove.registerSymbolicMove("e1c1");
					aChessBoardAfterMove.registerSymbolicMove("a1d1");
					aChessMove.setBoardStateAfter(aChessBoardAfterMove);
				} else if(theSymbolicMove.equals("e8c8")){
					aChessMove.setType(GameMoveTypeEnum.CASTLING_BLACKS_QUEEN_SIDE);

					aChessBoardAfterMove.registerSymbolicMove("e8c8");
					aChessBoardAfterMove.registerSymbolicMove("a8d8");
					aChessMove.setBoardStateAfter(aChessBoardAfterMove);
				} else if(theSymbolicMove.equals("e8g8")){
					aChessMove.setType(GameMoveTypeEnum.CASTLING_BLACKS_KING_SIDE);

					aChessBoardAfterMove.registerSymbolicMove("e8g8");
					aChessBoardAfterMove.registerSymbolicMove("h8f8");
					aChessMove.setBoardStateAfter(aChessBoardAfterMove);
				}
			}
			// simple move
			else {
				aChessMove.setType(GameMoveTypeEnum.SIMPLE);
				aChessBoardAfterMove.registerSymbolicMove(theSymbolicMove);
				aChessMove.setBoardStateAfter(aChessBoardAfterMove);
				aChessMove.setSimpleMoveSymbolicView(theSymbolicMove);
				int aY = ChessPieceSymbolicForm.getYFromPieceOrder(theSymbolicMove.charAt(1));
				int aX = ChessPieceSymbolicForm.getXFromPieceSymbol(theSymbolicMove.charAt(0));;
				aChessMove.setMovePieceType(theChessBoard.getFigureOnXY(aY, aX));
			}
		} else{ // if 5
			// promotion move
			// promotion by e7e8q for promotion to queen or e7e8n for promotion to knight) 
			aChessMove.setType(GameMoveTypeEnum.PROMOTION);
			
			String aMoveTransition = theSymbolicMove.substring(0, 4);
			aChessBoardAfterMove.registerSymbolicMove(aMoveTransition);
			
			// piece promotion coordinate
			int aPromotionY = ChessPieceSymbolicForm.getYFromPieceOrder(theSymbolicMove.charAt(3));
			int aPromotionX = ChessPieceSymbolicForm.getXFromPieceSymbol(theSymbolicMove.charAt(2));
			
			// promotion to white queen
			if(theSymbolicMove.charAt(3) == '8' && theSymbolicMove.charAt(4) == 'q'){
				aChessBoardAfterMove.setFigureOnXY(aPromotionY, aPromotionX, ChessPieceAbstract.WHITE_QUEEN);
			}
			//promotion to white knight
			else if(theSymbolicMove.charAt(3) == '8' && theSymbolicMove.charAt(4) == 'n'){
				aChessBoardAfterMove.setFigureOnXY(aPromotionY, aPromotionX, ChessPieceAbstract.WHITE_KNIGHT);
			}
			// promotion to black queen
			if(theSymbolicMove.charAt(3) == '1' && theSymbolicMove.charAt(4) == 'q'){
				aChessBoardAfterMove.setFigureOnXY(aPromotionY, aPromotionX, ChessPieceAbstract.BLACK_QUEEN);
			}
			//promotion to black knight
			else if(theSymbolicMove.charAt(3) == '1' && theSymbolicMove.charAt(4) == 'n'){
				aChessBoardAfterMove.setFigureOnXY(aPromotionY, aPromotionX, ChessPieceAbstract.BLACK_KNIGHT);
			}
			
			aChessMove.setBoardStateAfter(aChessBoardAfterMove);
		}
		
		return aChessMove;
	}
	/*
	 * Check Castling Effect
	 */
	public boolean checkCastlingEffectAfterMove(ChessMove theChessMove){
		// for whites
		if(this.getIsWhitesTurn() && this.getIsWhitesCastlingAvailable()){
			// if castling move
			if(theChessMove.getType().equals(GameMoveTypeEnum.CASTLING_WHITES_KING_SIDE) || theChessMove.getType().equals(GameMoveTypeEnum.CASTLING_WHITES_QUEEN_SIDE)){
				this.setIsWhitesCastlingAvailable(false);
				this.incrementHalfMovesNumber();
				return true;
			}
			// if king first move disable castling (we checked whites castling is available, so first move)
			else if(theChessMove.getSimpleMoveSymbolicView().substring(0, 2).equals("e1")){
				this.setIsWhitesCastlingAvailable(false);
				this.incrementHalfMovesNumber();
				return true;
			}
			// if rooks first move disable rook side castling
			else if(theChessMove.getSimpleMoveSymbolicView().substring(0, 2).equals("h1") && this.getIsWhitesKingSideCastlingAllowed()){
				this.setIsWhitesKingSideCastlingAllowed(false);
				this.incrementHalfMovesNumber();
				return true;
			}
			else if(theChessMove.getSimpleMoveSymbolicView().substring(0, 2).equals("a1") && this.getIsWhitesQueenSideCastlingAllowed()){
				this.setIsWhitesQueenSideCastlingAllowed(false);
				this.incrementHalfMovesNumber();
				return true;
			}
		}
		// for blacks
		else if(!this.getIsWhitesTurn() && this.getIsBlacksCastlingAvailable()){
			// if castling move
			if(theChessMove.getType().equals(GameMoveTypeEnum.CASTLING_BLACKS_KING_SIDE) || theChessMove.getType().equals(GameMoveTypeEnum.CASTLING_BLACKS_QUEEN_SIDE)){
				this.setIsBlacksCastlingAvailable(false);
				this.incrementHalfMovesNumber();
				return true;
			}
			// if king first move disable castling (we checked blacks castling is available, so first move)
			else if(theChessMove.getSimpleMoveSymbolicView().substring(0, 2).equals("e8")){
				this.setIsBlacksCastlingAvailable(false);
				this.incrementHalfMovesNumber();
				return true;
			}
			// if rooks first move disable rook side castling
			else if(theChessMove.getSimpleMoveSymbolicView().substring(0, 2).equals("h8") && this.getIsBlacksKingSideCastlingAllowed()){
				this.setIsBlacksKingSideCastlingAllowed(false);
				this.incrementHalfMovesNumber();
				return true;
			}
			else if(theChessMove.getSimpleMoveSymbolicView().substring(0, 2).equals("a8") && this.getIsBlacksQueenSideCastlingAllowed()){
				this.setIsBlacksQueenSideCastlingAllowed(false);
				this.incrementHalfMovesNumber();
				return true;
			}
		}
		return false;
	}
	/*
	 * Show Castling Info
	 */
	public void showCastlingInfo(){
		System.out.println("Whites King Side Castling Availability: " + this.getIsWhitesKingSideCastlingAllowed());
		System.out.println("Whites Queen Side Castling Availability: " + this.getIsWhitesQueenSideCastlingAllowed());
		System.out.println("Blacks King Side Castling Availability: " + this.getIsBlacksKingSideCastlingAllowed());
		System.out.println("Blacks Queen Side Castling Availability: " + this.getIsBlacksQueenSideCastlingAllowed());
	}
	/*
	 * Check En Passant Effect
	 */
	public boolean checkEnPassantEffectAfterMove(ChessMove theChessMove){
		// if whites turn
		if(this.getIsWhitesTurn()){
			// if en passant available
			if(!this.getEnPassantSymbolicTarget().equals("-")){
				// if use en passant attack
				if(theChessMove.getMoveChessPiece().equals(ChessPieceAbstractEnum.WHITE_PAWN) && 
						theChessMove.getSimpleMoveSymbolicView().substring(2, 4).equals(this.enPassantSymbolicTarget)){
					int aY = ChessPieceSymbolicForm.getYFromPieceOrder(theChessMove.getSimpleMoveSymbolicView().charAt(3));
					int aX = ChessPieceSymbolicForm.getXFromPieceSymbol(theChessMove.getSimpleMoveSymbolicView().charAt(2));
					this.chessBoard.setFigureOnXY(aY + 1, aX, null);
				}
				this.setEnPassantSymbolicTarget("-");
				this.incrementHalfMovesNumber();
				return true;
			}
			// check if en passant become available after move (if chess piece is pawn and it make 2 cells move maybe en passant)
			if(theChessMove.getMoveChessPiece().equals(ChessPieceAbstractEnum.WHITE_PAWN) && 
					Character.getNumericValue(theChessMove.getSimpleMoveSymbolicView().charAt(3)) - Character.getNumericValue(theChessMove.getSimpleMoveSymbolicView().charAt(1)) == 2){
				// if there is a pawn on the left or right next to current pawn, set it as en passant target
				int aY = ChessPieceSymbolicForm.getYFromPieceOrder(theChessMove.getSimpleMoveSymbolicView().charAt(3));
				int aX = ChessPieceSymbolicForm.getXFromPieceSymbol(theChessMove.getSimpleMoveSymbolicView().charAt(2));
				String aEnPassantSymbolicTarget;
				if(this.getBoard().getFigureOnXY(aY, aX - 1) != null && this.getBoard().getFigureOnXY(aY, aX - 1).equals(ChessPieceAbstract.BLACK_PAWN) || 
						this.getBoard().getFigureOnXY(aY, aX + 1) != null && this.getBoard().getFigureOnXY(aY, aX + 1).equals(ChessPieceAbstract.BLACK_PAWN)){
					aEnPassantSymbolicTarget = theChessMove.getSimpleMoveSymbolicView().substring(2, 3) + (Character.getNumericValue(theChessMove.getSimpleMoveSymbolicView().charAt(3)) - 1);
					this.setEnPassantSymbolicTarget(aEnPassantSymbolicTarget);
					this.incrementHalfMovesNumber();
					return true;
				}
			}
		}
		// if blacks turn
		else{
			// if en passant available
			if(!this.getEnPassantSymbolicTarget().equals("-")){
				// if use en passant attack
				if(theChessMove.getMovePieceType().equals(ChessPieceAbstract.BLACK_PAWN) && 
						theChessMove.getSimpleMoveSymbolicView().substring(2, 4).equals(this.enPassantSymbolicTarget)){
					int aY = ChessPieceSymbolicForm.getYFromPieceOrder(theChessMove.getSimpleMoveSymbolicView().charAt(3));
					int aX = ChessPieceSymbolicForm.getXFromPieceSymbol(theChessMove.getSimpleMoveSymbolicView().charAt(2));
					this.chessBoard.setFigureOnXY(aY-1, aX, null);
				}
				this.setEnPassantSymbolicTarget("-");
				this.incrementHalfMovesNumber();
				return true;
			}
			// check if en passant become available after move (if chess piece is pawn and it make 2 cells move maybe en passant)
			if(theChessMove.getMovePieceType().equals(ChessPieceAbstract.BLACK_PAWN) && 
					Character.getNumericValue(theChessMove.getSimpleMoveSymbolicView().charAt(1)) - Character.getNumericValue(theChessMove.getSimpleMoveSymbolicView().charAt(3)) == 2){
				// if there is a pawn on the left or right next to current pawn, set it as en passant target
				int aY = ChessPieceSymbolicForm.getYFromPieceOrder(theChessMove.getSimpleMoveSymbolicView().charAt(3));
				int aX = ChessPieceSymbolicForm.getXFromPieceSymbol(theChessMove.getSimpleMoveSymbolicView().charAt(2));
				String aEnPassantSymbolicTarget;
				if(this.getBoard().getFigureOnXY(aY, aX - 1) != null && this.getBoard().getFigureOnXY(aY, aX - 1).equals(ChessPieceAbstract.WHITE_PAWN) || 
						this.getBoard().getFigureOnXY(aY, aX + 1) != null && this.getBoard().getFigureOnXY(aY, aX + 1).equals(ChessPieceAbstract.WHITE_PAWN)){
					aEnPassantSymbolicTarget = theChessMove.getSimpleMoveSymbolicView().substring(2, 3) + (Character.getNumericValue(theChessMove.getSimpleMoveSymbolicView().charAt(3)) + 1);
					this.setEnPassantSymbolicTarget(aEnPassantSymbolicTarget);
					this.incrementHalfMovesNumber();
					return true;
				}
			}
		}
		return false;
	}
	/*
	 * Show En passant Info
	 */
	public void showEnPassantInfo(){
		System.out.println("En passant available: " + this.getEnPassantSymbolicTarget());
	}
	/*
	 * Check if simple attack effect
	 */
	public boolean checkSimpleAttackEffectAfterMove(ChessMove theChessMove){
		// for whites
		if(this.getIsWhitesTurn()){
			int aY = ChessPieceSymbolicForm.getYFromPieceOrder(theChessMove.getSimpleMoveSymbolicView().charAt(3));
			int aX = ChessPieceSymbolicForm.getXFromPieceSymbol(theChessMove.getSimpleMoveSymbolicView().charAt(2));
			// if attack move 
			if(this.getBoard().getFigureOnXY(aY, aX) != null){
				this.getBoard().registerSymbolicMove(theChessMove.getSimpleMoveSymbolicView());
				this.setHalfMovesNumber(0);
				return true;
			}
		}
		// for blacks
		else{
			int aY = ChessPieceSymbolicForm.getYFromPieceOrder(theChessMove.getSimpleMoveSymbolicView().charAt(3));
			int aX = ChessPieceSymbolicForm.getXFromPieceSymbol(theChessMove.getSimpleMoveSymbolicView().charAt(2));
			// if attack move 
			if(this.getBoard().getFigureOnXY(aY, aX) != null){
				this.getBoard().registerSymbolicMove(theChessMove.getSimpleMoveSymbolicView());
				this.setHalfMovesNumber(0);
				return true;
			}
		}
		return false;
	}
}
