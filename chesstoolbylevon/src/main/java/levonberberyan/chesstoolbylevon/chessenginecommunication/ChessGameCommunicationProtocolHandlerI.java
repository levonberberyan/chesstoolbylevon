package levonberberyan.chesstoolbylevon.chessenginecommunication;

import levonberberyan.chesstoolbylevon.chessengine.ChessEngineI;

public interface ChessGameCommunicationProtocolHandlerI {
	static String setProtocol(ChessEngineI theChessEngine){return null;}
	static void setNewGame(ChessEngineI theChessEngine){}
	static boolean checkIsReady(ChessEngineI theChessEngine){return false;}
	static String getMoveCalculations(ChessEngineI theChessEngine){return null;}
	static void setPositionFen(ChessEngineI theChessEngine, String fen){}
	static void quit(ChessEngineI theChessEngine){}
}
