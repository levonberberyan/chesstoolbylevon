package levonberberyan.chesstoolbylevon.chessengine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Paths;

import org.apache.commons.lang3.SystemUtils;

public class ChessEngineAsProcess implements ChessEngineI{
	/*
	 * Read Line from Chess Engine Output
	 */
	public String readLineFromEngine(){
		try{
			//ChessEngineAsProcess aChessEngine = (ChessEngineAsProcess)RunningChessEnginesHandler.getChessEngine(sessionId);
			return getEngineOutputReader().readLine();
		}catch(IOException theException){
			System.out.println("Problems reading line from engine as a process!");
			theException.printStackTrace();
			return null;
		}
	}
	/*
	 * Write Line to Chess Engine Input
	 */
	public void writeLineToEngine(String theLine){
		try{
			getEngineInputWriter().write(theLine);
			getEngineInputWriter().flush();
		}catch(IOException theException){
			System.out.println("Problems writing line to engine as a process!");
			theException.printStackTrace();
		}
	}
	/*
	 * Stop engine process if needed
	 */
	public void destroyEngineSession(){
		//destroy process
		getChessEngineProcess().destroy();
	}
	/*
	 * Constructors
	 */
	public ChessEngineAsProcess(String theEnginePath){
		//by default Stockfish is started as chess engine
		if(theEnginePath.equals(null) || theEnginePath.equals("")){
			try{
				//this.getClass()
				if(SystemUtils.IS_OS_WINDOWS && System.getProperty("os.arch").contains("64")) theEnginePath = Paths.get(ChessEngineAsProcess.class.getResource("/engines/stockfish7-windows.exe").toURI()).toString();
				else if(SystemUtils.IS_OS_LINUX && System.getProperty("os.arch").contains("64")) theEnginePath = Paths.get(ChessEngineAsProcess.class.getResource("/engines/stockfish7-linux").toURI()).toString();
				else if (SystemUtils.IS_OS_MAC && System.getProperty("os.arch").contains("64")) theEnginePath = Paths.get(ChessEngineAsProcess.class.getResource("/engines/stockfish7-mac").toURI()).toString();
			}catch(Exception theException){
				System.out.println("Problems with embedded engine URL");
				theException.printStackTrace();
			}
		}
		//ChessEngineAsProcess aChessEngine = new ChessEngineAsProcess();
		try{
			setChessEngineProcess(new ProcessBuilder(theEnginePath).start());
			engineOutputReader = new BufferedReader(new InputStreamReader(getChessEngineProcess().getInputStream()));
			engineInputWriter = new BufferedWriter(new OutputStreamWriter(getChessEngineProcess().getOutputStream()));
		}catch(IOException theException){
			System.out.println("Problems starting chess engine as process!");
			theException.printStackTrace();
		}
		RunningChessEnginesHandler.addNewEngine(this);
	}
	/*
	 * Chess Engine Output Reader & Input Writer Getters
	 */
	public BufferedReader getEngineOutputReader(){return engineOutputReader;}
	public BufferedWriter getEngineInputWriter(){return engineInputWriter;}
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
