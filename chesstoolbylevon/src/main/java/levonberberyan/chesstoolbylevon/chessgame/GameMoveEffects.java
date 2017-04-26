package levonberberyan.chesstoolbylevon.chessgame;

import levonberberyan.chesstoolbylevon.chessgamevalidation.GameMoveTypeEnum;
import levonberberyan.chesstoolbylevon.chessmove.ChessMove;
import levonberberyan.chesstoolbylevon.chesspiece.ChessPieceAbstract;
import levonberberyan.chesstoolbylevon.chesspiece.ChessPieceAbstractEnum;
import levonberberyan.chesstoolbylevon.chesspiece.ChessPieceSymbolicHandler;

public class GameMoveEffects {
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
					int aY = ChessPieceSymbolicHandler.getYFromPieceOrder(theChessMove.getSimpleMoveSymbolicView().charAt(3));
					int aX = ChessPieceSymbolicHandler.getXFromPieceSymbol(theChessMove.getSimpleMoveSymbolicView().charAt(2));
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
				int aY = ChessPieceSymbolicHandler.getYFromPieceOrder(theChessMove.getSimpleMoveSymbolicView().charAt(3));
				int aX = ChessPieceSymbolicHandler.getXFromPieceSymbol(theChessMove.getSimpleMoveSymbolicView().charAt(2));
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
					int aY = ChessPieceSymbolicHandler.getYFromPieceOrder(theChessMove.getSimpleMoveSymbolicView().charAt(3));
					int aX = ChessPieceSymbolicHandler.getXFromPieceSymbol(theChessMove.getSimpleMoveSymbolicView().charAt(2));
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
				int aY = ChessPieceSymbolicHandler.getYFromPieceOrder(theChessMove.getSimpleMoveSymbolicView().charAt(3));
				int aX = ChessPieceSymbolicHandler.getXFromPieceSymbol(theChessMove.getSimpleMoveSymbolicView().charAt(2));
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
			int aY = ChessPieceSymbolicHandler.getYFromPieceOrder(theChessMove.getSimpleMoveSymbolicView().charAt(3));
			int aX = ChessPieceSymbolicHandler.getXFromPieceSymbol(theChessMove.getSimpleMoveSymbolicView().charAt(2));
			// if attack move 
			if(this.getBoard().getFigureOnXY(aY, aX) != null){
				this.getBoard().registerSymbolicMove(theChessMove.getSimpleMoveSymbolicView());
				this.setHalfMovesNumber(0);
				return true;
			}
		}
		// for blacks
		else{
			int aY = ChessPieceSymbolicHandler.getYFromPieceOrder(theChessMove.getSimpleMoveSymbolicView().charAt(3));
			int aX = ChessPieceSymbolicHandler.getXFromPieceSymbol(theChessMove.getSimpleMoveSymbolicView().charAt(2));
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
