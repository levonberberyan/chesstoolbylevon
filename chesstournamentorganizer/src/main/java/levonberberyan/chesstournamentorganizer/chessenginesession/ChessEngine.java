package levonberberyan.chesstournamentorganizer.chessenginesession;

public interface ChessEngine {
	static void createNewEngineSession(String path){}
	static void writeLineToEngine(int sessionId, String theLine){}
	static String readLineFromEngine(int sessionId){return null;}
	static void destroyEngineSession(int sessionId){}
}
