package levonberberyan.chesstournamentorganizer.chessenginesession;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Paths;

import org.apache.commons.lang3.SystemUtils;

public class ChessEngineAsProcess implements ChessEngine{
	/*
	 * Read Line from Chess Engine Output
	 */
	public static String readLineFromEngine(int sessionId){
		try{
			ChessEngineAsProcess aChessEngine = (ChessEngineAsProcess)RunningChessEnginesHandler.getChessEngine(sessionId);
			return aChessEngine.engineOutputReader.readLine();
		}catch(IOException theException){
			System.out.println("Problems reading line from engine as a process!");
			theException.printStackTrace();
			return null;
		}
	}
	/*
	 * Write Line to Chess Engine Input
	 */
	public static void writeLineToEngine(int sessionId, String theLine){
		try{
			ChessEngineAsProcess aChessEngine = (ChessEngineAsProcess)RunningChessEnginesHandler.getChessEngine(sessionId);
			aChessEngine.engineInputWriter.write(theLine);
			aChessEngine.engineInputWriter.flush();
		}catch(IOException theException){
			System.out.println("Problems writing line to engine as a process!");
			theException.printStackTrace();
		}
	}
	/*
	 * Stop engine process if needed
	 */
	public static void destroyEngineSession(int sessionId){
		ChessEngineAsProcess aChessEngine = (ChessEngineAsProcess)RunningChessEnginesHandler.getChessEngine(sessionId);
		aChessEngine.getChessEngineProcess().destroy();
	}
	/*
	 * Create New Chess Engine Session
	 */
	public static void createNewEngineSession(String path){
		if(path.equals(null) || path.equals("")){
			try{
				//this.getClass()
				if(SystemUtils.IS_OS_WINDOWS && System.getProperty("os.arch").contains("64")) path = Paths.get(ChessEngineAsProcess.class.getResource("/engines/stockfish7-windows.exe").toURI()).toString();
				else if(SystemUtils.IS_OS_LINUX && System.getProperty("os.arch").contains("64")) path = Paths.get(ChessEngineAsProcess.class.getResource("/engines/stockfish7-linux").toURI()).toString();
				else if (SystemUtils.IS_OS_MAC && System.getProperty("os.arch").contains("64")) path = Paths.get(ChessEngineAsProcess.class.getResource("/engines/stockfish7-mac").toURI()).toString();
			}catch(Exception theException){
				System.out.println("Problems with embedded engine URL");
				theException.printStackTrace();
			}
		}
		ChessEngineAsProcess aChessEngine = new ChessEngineAsProcess();
		try{
			aChessEngine.setChessEngineProcess(new ProcessBuilder(path).start());
			aChessEngine.engineOutputReader = new BufferedReader(new InputStreamReader(aChessEngine.getChessEngineProcess().getInputStream()));
			aChessEngine.engineInputWriter = new BufferedWriter(new OutputStreamWriter(aChessEngine.getChessEngineProcess().getOutputStream()));
		}catch(IOException theException){
			System.out.println("Problems starting chess engine as process!");
			theException.printStackTrace();
		}
		RunningChessEnginesHandler.addNewEngine(aChessEngine);
	}
	/*
	 * Constructors
	 */
	public ChessEngineAsProcess(){}
	/*
	 * Chess Engine process getter, setter
	 */
	public Process getChessEngineProcess(){return this.chessEngineProcess;}
	private void setChessEngineProcess(Process theEngineProcess){this.chessEngineProcess = theEngineProcess;}
	/*
	 * Engine Process variable
	 */
	private Process chessEngineProcess;
	private BufferedReader engineOutputReader;
	private BufferedWriter engineInputWriter;
}
