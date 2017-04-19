package levonberberyan.chesstournamentorganizer.chessgame;

import levonberberyan.chesstournamentorganizer.chessmove.ChessMove;
import levonberberyan.chesstournamentorganizer.chessmove.ChessMoveTypeChecker;
import levonberberyan.chesstournamentorganizer.chessmove.ChessMoveTypeEnum;

public class ChessGameEffectsData implements ChessGameEffectsDataI{
	/*
	 * Register Promotion Effect
	 */
	public void registerPromotionEffect(){
		//*
	}
	/*
	 * Register En Passant Effect
	 */
	public void registerEnPassantEffect(){
		//*
	}
	/**
	 * Register Check Effect
	 */
	public void registerCheckEffect(){
		if(getIsWhitesTurn()) setIsBlacksCheck(true);
		else setIsWhitesCheck(true);
	}
	/**
	 * Register Castling Effect
	 */
	public void registerCastlingEffect(ChessMove theChessMove){
		switch(theChessMove.getMoveType()){
			case CASTLING_WHITES_KING_SIDE: setIsWhitesCastlingAvailable(false);
			case CASTLING_WHITES_QUEEN_SIDE: setIsWhitesCastlingAvailable(false);
			case CASTLING_BLACKS_KING_SIDE: setIsBlacksCastlingAvailable(false);
			case CASTLING_BLACKS_QUEEN_SIDE: setIsBlacksCastlingAvailable(false);
			default: break;
		}
	}
	/**
	 * Register Game effects for move
	 */
	public void registerGameEffects(ChessMove theChessMove){		
		// check type of the chess move
		ChessMoveTypeEnum aMoveType = ChessMoveTypeChecker.checkMoveType(theChessMove);
		
		// register effects according to chess move type
		switch(aMoveType){
			case MOVEMENT: break;
			case ATTACK: break;
			case PROMOTION: registerPromotionEffect();
			case EN_PASSANT_ATTACK: registerEnPassantEffect();
			case CHECK_EFFECT: registerCheckEffect();
			case CASTLING_WHITES_KING_SIDE: registerCastlingEffect(theChessMove);
			case CASTLING_WHITES_QUEEN_SIDE: registerCastlingEffect(theChessMove);
			case CASTLING_BLACKS_KING_SIDE: registerCastlingEffect(theChessMove);
			case CASTLING_BLACKS_QUEEN_SIDE: registerCastlingEffect(theChessMove);
		}
		
		// change turn color
		this.setIsWhitesTurn(!this.getIsWhitesTurn());
	}
	/**
	 * Default Constructor
	 */
	public ChessGameEffectsData(){}
	/**
	 * Getters, Setters
	 */
	//Check getters, setters
	public void setIsWhitesCheck(boolean theIsWhitesCheck){isWhitesCheck = theIsWhitesCheck;}
	public boolean getIsWhitesCheck(){return isWhitesCheck;}
	public void setIsBlacksCheck(boolean theIsBlacksCheck){isBlacksCheck = theIsBlacksCheck;}
	public boolean getIsBlacksCheck(){return isBlacksCheck;}
	//En passant symbolic target getter, setter
	public String getEnPassantSymbolicTarget() {return this.enPassantSymbolicTarget;}
	public void setEnPassantSymbolicTarget(String theEnPassantSymbolicTarget) {this.enPassantSymbolicTarget = theEnPassantSymbolicTarget;}
	//Castling getters, setters
	public boolean getIsBlacksCastlingAvailable(){
		if(this.blacksKingSideCastlingIsAllowed || this.blacksQueenSideCastlingIsAllowed){return true;}
		return false;
	}
	public void setIsBlacksCastlingAvailable(boolean theIsBlacksCastlingAvailable){
		this.blacksKingSideCastlingIsAllowed = theIsBlacksCastlingAvailable;
		this.blacksQueenSideCastlingIsAllowed = theIsBlacksCastlingAvailable;
	}
	public boolean getIsWhitesCastlingAvailable(){
		if(this.whitesKingSideCastlingIsAllowed || this.whitesQueenSideCastlingIsAllowed){return true;}
		return false;
	}
	public void setIsWhitesCastlingAvailable(boolean theIsWhitesCastlingAvailable){
		this.whitesKingSideCastlingIsAllowed = theIsWhitesCastlingAvailable;
		this.whitesQueenSideCastlingIsAllowed = theIsWhitesCastlingAvailable;
	}
	//Castling Info Getters, Setters
	public boolean getIsWhitesKingSideCastlingAllowed() {return this.whitesKingSideCastlingIsAllowed;}
	public void setIsWhitesKingSideCastlingAllowed(boolean theIsWhitesKingSideCastlingAllowed) {this.whitesKingSideCastlingIsAllowed = theIsWhitesKingSideCastlingAllowed;}
	public boolean getIsWhitesQueenSideCastlingAllowed() {return this.whitesQueenSideCastlingIsAllowed;}
	public void setIsWhitesQueenSideCastlingAllowed(boolean theIsWhitesQueenSideCastlingAllowed) {this.whitesQueenSideCastlingIsAllowed = theIsWhitesQueenSideCastlingAllowed;}
	public boolean getIsBlacksKingSideCastlingAllowed() {return this.blacksKingSideCastlingIsAllowed;}
	public void setIsBlacksKingSideCastlingAllowed(boolean theIsBlacksKingSideCastlingAllowed) {this.blacksKingSideCastlingIsAllowed = theIsBlacksKingSideCastlingAllowed;}
	public boolean getIsBlacksQueenSideCastlingAllowed() {return this.blacksQueenSideCastlingIsAllowed;}
	public void setIsBlacksQueenSideCastlingAllowed(boolean theIsBlacksQueenSideCastlingAllowed) {this.blacksQueenSideCastlingIsAllowed = theIsBlacksQueenSideCastlingAllowed;}
	//Turn color getter, setter
	public boolean getIsWhitesTurn(){return isWhitesTurn;}
	public void setIsWhitesTurn(boolean theIsWhitesTurn){isWhitesTurn = theIsWhitesTurn;}
	/**
	 * Private Fields
	 */
	//Check
	private boolean isWhitesCheck = false;
	private boolean isBlacksCheck = false;
	//En Passant Symbolic Target
	//(If first pawn moves two cells it's previous cell can be 
	//attacked and pawn will be killed)
	private String enPassantSymbolicTarget = "-";
	//Castling Info
	private boolean whitesKingSideCastlingIsAllowed = false;
	private boolean whitesQueenSideCastlingIsAllowed = false;
	private boolean blacksKingSideCastlingIsAllowed = false;
	private boolean blacksQueenSideCastlingIsAllowed = false;
	//Game Turn Color
	private boolean isWhitesTurn = true;
}
