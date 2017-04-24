package levonberberyan.chesstoolbylevon.chessengine;

public interface ChessEngineI {
	void writeLineToEngine(String theLine);
	String readLineFromEngine();
	void destroyEngineSession();
}
