package levonberberyan.chesstoolbylevon.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import levonberberyan.chesstoolbylevon.chessboard.ChessBoardAsSwingWindow;
import levonberberyan.chesstoolbylevon.chessgamelog.FenParser;
import levonberberyan.chesstoolbylevon.chesstutor.SolverTutorJsonHandler;
import levonberberyan.chesstoolbylevon.chesstutor.SolverTutorRequestsHandler;

public class SimpleTutorDemo {
	/*
	 * Get List of Tutor Concepts
	 */
	public static void getListOfTutorConcepts(){
		//*get using LSP protocol
		System.out.println("Available Concepts for Tutor:\n" +
				"concept1\n" +
				"concept2\n" +
				"concept3");
	}
	/**
	 * Player vs Engine : Tutor mode
	 */
	public static void handlePlayerVsEngineTutor(){
		/*System.out.println("\n\nYou entered Player vs Engine Tutor mode!");
		while(true){
			// Entering tutor commands
			System.out.println("\nEnter a tutor command from list: " +
					"\ngetListOfTutorConcepts" +
					"\ngetListOfTutorStrategies" +
					"\nlearnConcept[name]" +
					"\nlearnStrategy[name]" +
					"\ntestConceptKnowledge" +
					"\ntestStrategyKnowledge" +
					"\nescape" +
					"\nexit");
			//String tutorCommand = inputScanner.nextLine();
			
			// Get List of Tutor Concepts
			if(tutorCommand.equals("getListOfTutorConcepts")){
				AppMain.getListOfTutorConcepts();
			}
			// Get List of Tutor Strategies
			else if(tutorCommand.equals("getListOfTutorStrategies")){
				//*
			}
			// Learn Concept by name
			else if(tutorCommand.contains("learnConcept")){
				//*
			}
			// Learn strategy by name
			else if(tutorCommand.contains("learnStrategy")){
				//*
			}
			// Test Concept Knowledge by name
			else if(tutorCommand.contains("testConceptKnowledge")){
				//*
			}
			// Test strategy knowledge by name
			else if(tutorCommand.contains("testStrategyKnowledge")){
				//*
			}
			// Escape from Tutor mode
			else if(tutorCommand.equals("escape")){
				System.out.println("Leaving Tutor mode!");
				break;
			}
			// Exit
			else if(tutorCommand.equals("exit")){
				AppMain.exit();
			}
			// Other input
			else{
				System.out.println("Please insert correct tutor mode command!");
			}
		}*/
	}
	/**
	 * Handle Player vs Engine mode
	 */
	public static void handlePlayerVsEngine(){
		/*System.out.println("\n\nYou entered Player vs Engine mode!");
		while(true){
			// Choosing one of 2 interaction modes: Play mode or Tutor mode
			System.out.println("\nChoose one of 2 interaction modes: Play mode (insert \"play\"), Tutor mode (insert \"tutor\")" +
					"\nYou can also enter \"escape\" command to leave Player vs Engine mode " +
					"\nexit command for closing application\r");
			//String interactionMode = inputScanner.nextLine();
					
			// Play mode
			if(interactionMode.equals("play")){
				//*
			}
			// Tutor mode
			else if(interactionMode.equals("tutor")){
				//AppMain.handlePlayerVsEngineTutor();
			}
			// Escape
			else if(interactionMode.equals("escape")){
				System.out.println("Leaving Player vs Engine mode!");
				break;
			}
			// Exit
			else if(interactionMode.equals("exit")){
				AppMain.exit();
			}
			// Other input
			else{
				System.out.println("Please insert correct interaction mode command!");
			}
		}*/
	}
	public static void run() throws IOException{
		// print info about application
		System.out.println("Welcome to Chess Tutor by Sedrak and Levon!");
		
		Scanner inputScanner = new Scanner(System.in);
		
		System.out.println("Please Insert Server Address!");
		String aDomain = inputScanner.nextLine();
		
		do{
			// Choosing one of 3 game modes: Player vs Player, Engine vs Engine, Player vs Engine 
			System.out.println("\n\nChoose one of 3 tutor modes: (Get Concept List(insert \"gcl\"), Get Concept(insert \"gc\"), Get Example(insert \"ge\")) " +
					"\nYou can also enter \"exit\" command to close the application \r");
			String gameMode = inputScanner.nextLine();
								
			// Get Concept List Mode
			if(gameMode.equals("gcl")){
				String aUrl = "http://" + aDomain + "/concepts/home.action?type=conceptList&value=composite";
				String aJsonString = SolverTutorRequestsHandler.sendGetRequest(aUrl);
				
				ArrayList<String> aJsonExtractedResult = SolverTutorJsonHandler.extractJsonValuesByKey(aJsonString, "name");
				System.out.println("Available Concepts List:\n");
				for(String name: aJsonExtractedResult)
				System.out.println(name);
			} 
			// Get Concept Mode
			else if(gameMode.equals("gc")){
				System.out.println("Input Concept Name!");
				String aConceptName = inputScanner.nextLine();
				
				String aUrl = "http://" + aDomain + "/concepts/home.action?type=conceptName&value=" + aConceptName;
				String aJsonString = SolverTutorRequestsHandler.sendGetRequest(aUrl);
				
				ArrayList<String> aJsonExtractedResult = SolverTutorJsonHandler.extractJsonValuesByKey(aJsonString, "virtual");
				System.out.println("Concept Info:\n");
				if(aJsonExtractedResult.get(0).contains("true")){
					System.out.println("Specifications Names:");
					ArrayList<String> aNames = SolverTutorJsonHandler.extractJsonValuesByKey(aJsonString, "name");
					for(String name: aNames){
						System.out.println(name);
					}
				} else if (aJsonExtractedResult.get(0).contains("false")){
					System.out.println("Connections Names:");
					ArrayList<String> aNames = SolverTutorJsonHandler.extractJsonValuesByKey(aJsonString, "name");
					for(String name: aNames){
						System.out.println(name);
					}
				}
				
				System.out.println("\nparent: " + SolverTutorJsonHandler.extractJsonValuesByKey(aJsonString, "parent"));
			} 
			// Get Example Mode
			else if(gameMode.equals("ge")){
				System.out.println("Input Concept Name!");
				String aConceptName = inputScanner.nextLine();
				
				String aUrl = "http://" + aDomain + "/concepts/home.action?type=example&value=" + aConceptName;
				String aJsonString = SolverTutorRequestsHandler.sendGetRequest(aUrl);
				
				ArrayList<String> aJsonExtractedResult = SolverTutorJsonHandler.extractJsonValuesByKey(aJsonString, "fen");
				if(aJsonExtractedResult.get(0) == null) System.out.println("No board fen for this example!");
				new ChessBoardAsSwingWindow(FenParser.convertBoardFenToChessBoardArr(
						aJsonExtractedResult.get(0)));
			}
			// Exit
			else if(gameMode.equals("exit")){
				inputScanner.close();
				AppMain.exit();
			}
			// Other input
			else{
				System.out.println("Please insert correct tutor mode command!");
			}
		}
		while(true);
	}
}
