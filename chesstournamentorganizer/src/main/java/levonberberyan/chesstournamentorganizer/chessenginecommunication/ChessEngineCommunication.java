package levonberberyan.chesstournamentorganizer.chessenginecommunication;

public interface ChessEngineCommunication {
	static String setProtocol(int sessionId){return null;}
	static void setNewGame(int sessionId){}
	static boolean checkIsReady(int sessionId){return false;}
	static String getMoveCalculations(int sessionId){return null;}
	static void setPositionFen(int sessionId, String fen){}
	static void quit(int sessionId){}
}
