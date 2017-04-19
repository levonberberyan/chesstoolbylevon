package levonberberyan.chesstournamentorganizer.ui;

import java.io.IOException;
import java.util.Scanner;

public class AppMain {
	/**
	 * Handle main console
	 */
	public static void handleConsole(){
		// print info about application
		System.out.println("Welcome to Chess Games Handling Tool By Levon!");
		
		// Insert command 
		System.out.println("\n\nPlease enter one of commands" +
				"\nYou can also enter \"quit\" command to close the application \r");
				
		do{
			String command = inputScanner.nextLine();
								
			/*
			 *  Handle modules command
			 */
			if(command.equals("modules")){
				System.out.println("Module Name: " + "chessEngineSession; " + "description: ");
				System.out.println("Module Name: " + "chessEngineCommunication; " + "description: ");
				System.out.println("Module Name: " + "chessmen; " + "description: ");
				System.out.println("Module Name: " + "chessBoard; " + "description: ");
				System.out.println("Module Name: " + "chessMove; " + "description: ");
				System.out.println("Module Name: " + "chessGame; " + "description: ");
				System.out.println("Module Name: " + "chessGameLogging; " + "description: ");
			} 
			/*
			 *  Handle module command
			 */
			else if(command.equals("module chessEngineSession")){
				//*
			}
			else if(command.equals("module chessEngineCommunication")){
				//*
			}
			else if(command.equals("module chessmen")){
				//*
			}
			else if(command.equals("module chessBoard")){
				//*
			}
			else if(command.equals("module chessMove")){
				//*
			}
			else if(command.equals("module chessGame")){
				//*
			}
			else if(command.equals("module chessGameLogging")){
				//*
			}
			/*
			 *  Handle module extended command
			 */
			else if(command.contains("module chessEngineSession -component ChessEngineAsProcess -function createNewEngineSession -options ")){
				//System.out.println("It works!");
			}
			/*
			 *  Handle quit command
			 */
			else if(command.equals("quit")){
				AppMain.exit();
			}
			// Handle other input
			else{
				System.out.println("Please insert correct command!");
			}
		}
		while(true);
	}
	/**
	 * Exit Application
	 */
	public static void exit(){
		inputScanner.close();
		System.out.println("Application is closing!");
		System.exit(0);
	}
	/**
	 * App main method
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException{
		AppMain.handleConsole();
		//SimpleTutorDemo.run();
	}
	/**
	 * create the Scanner for input reading
	 */
	private static Scanner inputScanner = new Scanner(System.in);
}
