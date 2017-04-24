package levonberberyan.chesstournamentorganizer.chesstutor;

import java.io.IOException;
import java.util.ArrayList;

import levonberberyan.chesstoolbylevon.chesstutor.SolverTutorJsonHandler;
import levonberberyan.chesstoolbylevon.chesstutor.SolverTutorRequestsHandler;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleTutorDemoTest {
	@Ignore
	@Test
	public void getConceptListRequest() throws IOException{
		String aDomain = "100.80.249.89:8080";
		
		
		String aUrl = "http://" + aDomain + "/concepts/home.action?type=conceptList&value=composite";
		String aResponse = SolverTutorRequestsHandler.sendGetRequest(aUrl);
		System.out.println(aResponse);
		
		assertTrue(true);
	}
	
	@Ignore
	@Test
	public void extractConceptsList() throws IOException{
		String aJsonString = "{'ConceptList' : [{'type' : 'c', 'parent' : 'FieldUnderCheck', 'name' : 'FieldUnderCheck'},{'type' : 'c', 'parent' : 'PawnNotAttacked', 'name' : 'pawnNotUnderAttack'},{'type' : 'c', 'parent' : 'Figure', 'name' : 'King'},{'type' : 'c', 'parent' : 'RetiepostC', 'name' : 'RetiePostC2'},{'type' : 'c', 'parent' : 'Figure', 'name' : 'Knight'},{'type' : 'c', 'parent' : 'bpuc', 'name' : 'bpuc'},{'type' : 'c', 'parent' : 'FieldUnderCheck', 'name' : 'FieldUnderCheckOfPawn'},{'type' : 'c', 'parent' : 'tc5', 'name' : 'tc5'},{'type' : 'c', 'parent' : 'FieldUnderCheck', 'name' : 'fieldUnderCheckOfKing'},{'type' : 'c', 'parent' : 'FieldUnderCheckOfPawn', 'name' : 'FieldUnderCheckOfPawn2'},{'type' : 'c', 'parent' : 'FieldUnderCheckOfPawn', 'name' : 'FieldUnderCheckOfPawn1'},{'type' : 'c', 'parent' : 'noBlackPawn', 'name' : 'noBlackPawn'},{'type' : 'c', 'parent' : 'Field', 'name' : 'Figure'},{'type' : 'c', 'parent' : 'FieldUnderCheck', 'name' : 'FieldUnderCheckOfKnight'},{'type' : 'c', 'parent' : 'NoBlackPawn', 'name' : 'NoBlackPawn'},{'type' : 'c', 'parent' : 'PawnNotAttacked', 'name' : 'PawnIsProtected'},{'type' : 'c', 'parent' : 'WhitePawnIsGood', 'name' : 'WhitePawnIsGood'},{'type' : 'c', 'parent' : 'noPawn', 'name' : 'noPawn'},{'type' : 'c', 'parent' : 'PawnNotAttacked', 'name' : 'PawnNotAttacked'},{'type' : 'c', 'parent' : 'pawnUnderAttack', 'name' : 'pawnUnderAttack'},{'type' : 'c', 'parent' : 'pawnUnderAttack', 'name' : 'blackPawnUnderAttack'},{'type' : 'c', 'parent' : 'noKnight', 'name' : 'noKnight'},{'type' : 'c', 'parent' : 'FieldUnderCheckOfKnight', 'name' : 'FieldUnderCheckOfKnight1'},{'type' : 'c', 'parent' : 'RetiepostC', 'name' : 'RetiepostC'},{'type' : 'c', 'parent' : 'fieldUnderCheckOfKing', 'name' : 'fieldUnderCheckOfKing8'},{'type' : 'c', 'parent' : 'Field', 'name' : 'Field'},{'type' : 'c', 'parent' : 'Check', 'name' : 'Check'},{'type' : 'c', 'parent' : 'Figure', 'name' : 'Pawn'},{'type' : 'c', 'parent' : 'fieldUnderCheckOfKing', 'name' : 'fieldUnderCheckOfKing3'},{'type' : 'c', 'parent' : 'fieldUnderCheckOfKing', 'name' : 'fieldUnderCheckOfKing2'},{'type' : 'c', 'parent' : 'fieldUnderCheckOfKing', 'name' : 'fieldUnderCheckOfKing1'},{'type' : 'c', 'parent' : 'fieldUnderCheckOfKing', 'name' : 'fieldUnderCheckOfKing7'},{'type' : 'c', 'parent' : 'fieldUnderCheckOfKing', 'name' : 'fieldUnderCheckOfKing6'},{'type' : 'c', 'parent' : 'fieldUnderCheckOfKing', 'name' : 'fieldUnderCheckOfKing5'},{'type' : 'c', 'parent' : 'fieldUnderCheckOfKing', 'name' : 'fieldUnderCheckOfKing4'},{}]}";
		ArrayList<String> aJsonExtractedResult = SolverTutorJsonHandler.extractJsonValuesByKey(aJsonString, "name");
		for(String name: aJsonExtractedResult)
		System.out.println(name);
		
		assertTrue(true);
	}
	
	@Ignore
	@Test
	public void learnConceptRequest() throws IOException{
		String aDomain = "100.80.249.89:8080";
		String aConceptName = "FieldUnderCheck";
		
		String aUrl = "http://" + aDomain + "/concepts/home.action?type=conceptName&value=" + aConceptName;
		String aResponse = SolverTutorRequestsHandler.sendGetRequest(aUrl);
		System.out.println(aResponse);
		
		assertTrue(true);
	}
	
	@Ignore
	@Test
	public void extractConceptResponse() throws IOException{
		String aJsonString = "{'name':'FieldUnderCheck','description':'temporary unavailabe description','parent':'','virtual':'true','negated':'false','specifications':[{'name':'FieldUnderCheckOfPawn'},{'name':'FieldUnderCheckOfKnight'},{'name':'fieldUnderCheckOfKing'}],'type':'concept','connections':[{'name':'Figure'},{'name':'Field'}],'regularities':[]}";
		ArrayList<String> aJsonExtractedResult = SolverTutorJsonHandler.extractJsonValuesByKey(aJsonString, "virtual");
		System.out.println(aJsonExtractedResult.get(0));
		if(aJsonExtractedResult.get(0).contains("true")){
			ArrayList<String> aNames = SolverTutorJsonHandler.extractJsonValuesByKey(aJsonString, "name");
			for(String name: aNames){
				System.out.println(name);
			}
		} else if (aJsonExtractedResult.get(0).contains("false")){
			ArrayList<String> aNames = SolverTutorJsonHandler.extractJsonValuesByKey(aJsonString, "name");
			for(String name: aNames){
				System.out.println(name);
			}
		}
		
		System.out.println("parent: " + SolverTutorJsonHandler.extractJsonValuesByKey(aJsonString, "parent"));
		
		assertTrue(true);
	}
	
	@Ignore
	@Test
	public void conceptExampleRequest() throws IOException{
		String aDomain = "100.80.249.89:8080";
		String aConceptName = "Mate";
		
		String aUrl = "http://" + aDomain + "/concepts/home.action?type=example&value=" + aConceptName;
		String aResponse = SolverTutorRequestsHandler.sendGetRequest(aUrl);
		System.out.println(aResponse);
		
		assertTrue(true);
	}
	
	@Ignore
	@Test
	public void extractConceptExampleResponse() throws IOException{
		String aJsonString = "{'exists':'true', 'fen':'8/8/8/8/4k3/8/3N4/8'}";
		ArrayList<String> aJsonExtractedResult = SolverTutorJsonHandler.extractJsonValuesByKey(aJsonString, "fen");
		
		System.out.println(aJsonExtractedResult.get(0));
		
		
		
		assertTrue(true);
	}
}
