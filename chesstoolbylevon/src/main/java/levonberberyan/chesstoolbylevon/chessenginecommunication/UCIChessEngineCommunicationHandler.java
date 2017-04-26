package levonberberyan.chesstoolbylevon.chessenginecommunication;

import levonberberyan.chesstoolbylevon.chessengine.ChessEngineI;

public final class UCIChessEngineCommunicationHandler implements ChessGameCommunicationProtocolHandlerI{
	/*
	 * close UCI session of engine
	 */
	public static void quit(ChessEngineI theChessEngine){
		theChessEngine.writeLineToEngine("quit\n");
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
	public static void sayPositionFen(ChessEngineI theChessEngine, String fen){
		theChessEngine.writeLineToEngine("position fen " + fen + "\n");
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
	public static String getMoveCalculations(ChessEngineI theChessEngine){
		// calculations are dependant on engine
		// stockfish: bestmove (none)
		// fruit and rybka: bestmove a1a1
		// Robolitto: bestmove NULL
		
		theChessEngine.writeLineToEngine("go movetime 1000\n");
		try{
			Thread.sleep(2000);
		}catch(InterruptedException theException){
			System.out.println("Problems trying to wait for a second");
			theException.printStackTrace();
		}
		String aLine = "";
		while(aLine.indexOf("bestmove") == -1){
			aLine += theChessEngine.readLineFromEngine();
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
	public static String extractMoveFromCalculations(String theMoveCalculations){
		// *validate move calculations String
		System.out.println("\n" + "Move Calculations String: \n" + theMoveCalculations);
		
		// If engine found the move, than it's in following format: "bestmove * [ponder *]"
		String aMoveString = "";
		
		//if all type types of move can be divided in 2 (with ponder and without)
		if(theMoveCalculations.contains("ponder")){
			aMoveString = theMoveCalculations.substring(theMoveCalculations.indexOf(" ") + 1, theMoveCalculations.indexOf(" ponder"));
		}
		else{
			// get all move info after bestmove
			aMoveString = theMoveCalculations.substring(theMoveCalculations.indexOf("bestmove ") + 9);
		}
		
		System.out.println("The Move string: " + aMoveString);
		return aMoveString;
	}
	/*
	 * Check ready state of engine
	 */
	public static boolean checkIsReady(ChessEngineI theChessEngine){
		theChessEngine.writeLineToEngine("isready\n");
		try{
			Thread.sleep(1000);
		}catch(InterruptedException theException){
			System.out.println("Problems trying to wait for a second");
			theException.printStackTrace();
		}
		if(theChessEngine.readLineFromEngine().equalsIgnoreCase("readyok")){return true;}
		return false;
	}
	/*
	 * Set new game to engine
	 */
	public static void setNewGame(ChessEngineI theChessEngine){
		theChessEngine.writeLineToEngine("ucinewgame\n");
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
	public static String setProtocol(ChessEngineI theChessEngine){
		theChessEngine.writeLineToEngine("uci\n");
		String aLine = "";
		try{
			Thread.sleep(1000);
			while((aLine += theChessEngine.readLineFromEngine()).indexOf("uciok") == -1){
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
