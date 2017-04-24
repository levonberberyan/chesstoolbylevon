package tmp;

import levonberberyan.chesstoolbylevon.chessmove.ChessMove;

public interface ChessGameEffectsDataI {
	void registerPromotionEffect();
	void registerEnPassantEffect();
	void registerCheckEffect();
	void registerCastlingEffect(ChessMove theChessMove);
	
	void registerGameEffects(ChessMove theChessMove);
	
	void setIsWhitesCheck(boolean theIsWhitesCheck);
	boolean getIsWhitesCheck();
	void setIsBlacksCheck(boolean theIsBlacksCheck);
	boolean getIsBlacksCheck();
	
	String getEnPassantSymbolicTarget();
	void setEnPassantSymbolicTarget(String theEnPassantSymbolicTarget);
	
	boolean getIsBlacksCastlingAvailable();
	void setIsBlacksCastlingAvailable(boolean theIsBlacksCastlingAvailable);
	boolean getIsWhitesCastlingAvailable();
	void setIsWhitesCastlingAvailable(boolean theIsWhitesCastlingAvailable);
	
	boolean getIsWhitesKingSideCastlingAllowed();
	void setIsWhitesKingSideCastlingAllowed(boolean theIsWhitesKingSideCastlingAllowed);
	boolean getIsWhitesQueenSideCastlingAllowed();
	void setIsWhitesQueenSideCastlingAllowed(boolean theIsWhitesQueenSideCastlingAllowed);
	boolean getIsBlacksKingSideCastlingAllowed();
	void setIsBlacksKingSideCastlingAllowed(boolean theIsBlacksKingSideCastlingAllowed);
	boolean getIsBlacksQueenSideCastlingAllowed();
	void setIsBlacksQueenSideCastlingAllowed(boolean theIsBlacksQueenSideCastlingAllowed);
	
	boolean getIsWhitesTurn();
	void setIsWhitesTurn(boolean theIsWhitesTurn);
}
