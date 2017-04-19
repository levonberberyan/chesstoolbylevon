package levonberberyan.chesstournamentorganizer.chessenginecommunication;

import levonberberyan.chesstournamentorganizer.chessenginesession.ChessEngineAsProcess;

public final class UCIChessEngineCommunicationHandler implements ChessEngineCommunication{
	/*
	 * close UCI session of engine
	 */
	public static void quit(int sessionId){
		ChessEngineAsProcess.writeLineToEngine(sessionId, "quit\n");
		try{
			Thread.sleep(2000);
		}catch(InterruptedException theException){
			System.out.println("Problems trying to wait for a second");
			theException.printStackTrace();
		}
	}
	//methods should return String, then check if the string is proper, then go to next function, else stop
	/*
	 * Set board position using fen
	 */
	public static void sayPositionFen(int sessionId, String fen){
		ChessEngineAsProcess.writeLineToEngine(sessionId, "position fen " + fen + "\n");
		try{
			Thread.sleep(1000);
		}catch(InterruptedException theException){
			System.out.println("Problems trying to wait for a second");
			theException.printStackTrace();
		}
	}
	/*
	 * Request move calculation from UCI engine
	 */
	public static String getMoveCalculations(int sessionId){
		ChessEngineAsProcess.writeLineToEngine(sessionId, "go movetime 1000\n");
		try{
			Thread.sleep(2000);
		}catch(InterruptedException theException){
			System.out.println("Problems trying to wait for a second");
			theException.printStackTrace();
		}
		String aLine = "";
		while(aLine.indexOf("bestmove") == -1){
			aLine += ChessEngineAsProcess.readLineFromEngine(sessionId);
			//System.out.println(s);
		}
		return aLine;
	}
	/*
	 * Check move calculation result type
	 */
	public static UCIMoveCalculationsResultType checkMoveCalculationsResultType(String theMoveCalculations){
		//if end of game
		if(theMoveCalculations.contains("stalemate") || theMoveCalculations.contains("mate")) {
			return UCIMoveCalculationsResultType.GAMEOVER;
		}
		
		return null;
	}
	/*
	 * Extract Move
	 */
	public static String extractMoveFromCalculations(String moveCalculations){
		//extract move from "bestmove * ponder *" String
		String move = moveCalculations.substring(moveCalculations.indexOf(" ") + 1, moveCalculations.indexOf(" ponder"));
		return move;
	}
	/*
	 * Check ready state of engine
	 */
	public static boolean checkIsReady(int sessionId){
		ChessEngineAsProcess.writeLineToEngine(sessionId, "isready\n");
		try{
			Thread.sleep(1000);
		}catch(InterruptedException theException){
			System.out.println("Problems trying to wait for a second");
			theException.printStackTrace();
		}
		if(ChessEngineAsProcess.readLineFromEngine(sessionId).equalsIgnoreCase("readyok")){return true;}
		return false;
	}
	/*
	 * Set new game to engine
	 */
	public static void setNewGame(int sessionId){
		ChessEngineAsProcess.writeLineToEngine(sessionId,"ucinewgame\n");
		try{
			Thread.sleep(1000);
		}catch(InterruptedException theException){
			System.out.println("Problems trying to wait for a second");
			theException.printStackTrace();
		}
	}
	/*
	 * Set protocol of engine to UCI
	 */
	public static String setProtocol(int sessionId){
		ChessEngineAsProcess.writeLineToEngine(sessionId, "uci\n");
		String aLine = "";
		try{
			Thread.sleep(1000);
			while((aLine += ChessEngineAsProcess.readLineFromEngine(0)).indexOf("uciok") == -1){
			}
		} catch(InterruptedException theException){
			System.out.println("Problems trying to wait for a second");
			theException.printStackTrace();
		}
		return aLine;
	}
	/*
	 * New UCI Contacter Constructor by engine process
	 */
	public UCIChessEngineCommunicationHandler(){
	}
}
