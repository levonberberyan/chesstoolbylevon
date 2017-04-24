package levonberberyan.chesstoolbylevon.chessengine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ChessEngineAsWebGetResource implements ChessEngineI{
	/*
	 * Writes line to chess engine
	 */
	public static void writeLineToEngine(int sessionId, String theLine) {
		try{
			ChessEngineAsWebGetResource aChessEngine = (ChessEngineAsWebGetResource)RunningChessEnginesHandler.getChessEngine(sessionId);
			URL obj = new URL(aChessEngine.getUrl());
			HttpURLConnection aConnection = (HttpURLConnection) obj.openConnection();
		
			// optional default is GET
			aConnection.setRequestMethod("GET");

			BufferedReader in = new BufferedReader(
					new InputStreamReader(aConnection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			//save result
			aChessEngine.setResponse(response.toString());
		} catch(Exception theException){
			System.out.println("Problems connecting to URL");
			theException.printStackTrace();
		}
	}
	/*
	 * Reads line from chess engine
	 */
	public static String readLineFromEngine(int sessionId) {
		ChessEngineAsWebGetResource aChessEngine = (ChessEngineAsWebGetResource)RunningChessEnginesHandler.getChessEngine(sessionId);
		return aChessEngine.getResponse();
	}
	/*
	 * Closes session with chess engine
	 */
	public static void destroyEngineSession() {
		
	}
	/*
	 * Creates new chess engine session using web requests
	 */
	public static void createNewEngineSession(String path){
		
	}
	/*
	 * Constructor, that make session for connecting to Web Api by URL
	 */
	public ChessEngineAsWebGetResource(){
		
	}
	/*
	 * Getters, Setters
	 */
	public String getResponse() {return this.response;}
	public void setResponse(String theResponse) {this.response = theResponse;}
	public String getUrl() {return this.url;}
	public void setUrl(String theUrl) {this.url = theUrl;}
	/* 
	 * Resource URL
	 */
	private String url;
	private String response;
}
