package levonberberyan.chesstournamentorganizer.chesstutor;

import java.util.ArrayList;

public class SolverTutorJsonHandler {
	public static ArrayList<String> extractJsonValuesByKey(String theJsonString, String theKey){
		/*JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(theJsonString);
		JsonObject rootObj = element.getAsJsonObject(); //since you know it's a JsonObject
		ArrayList<String> values = new ArrayList<String>();
		
		
		//JsonObject obj = null;
		for (Map.Entry<String,JsonElement> entry : rootObj.entrySet()) {
		    //JsonArray array = entry.getValue().getAsJsonObject().getAsJsonArray("ConceptList");
		    //for (JsonElement codeHolder : array) {
		    //	values.add(codeHolder.getAsJsonObject().getAsJsonPrimitive("code").getAsInt());
		    //}
			values.add(entry.getValue().getAsString());
		}
		return values;*/
		
		/*Set<Map.Entry<String, JsonElement>> entries = obj.entrySet();//will return members of your object
		
		String result = "";
		
		for (Map.Entry<String, JsonElement> entry: entries) {
			System.out.println(entry.getKey());
			if(entry.getKey().contains(theKey)){
		    	result += "|" + entry.getValue();
			}
		}

		return result;*/
		/*Pattern p = Pattern.compile(theKey + "'");
		Matcher m = p.matcher(theJsonString);
		while (m.find()) {
		    System.out.println();
		}*/
		
		//removes all whitespaces and non-visible characters
		theJsonString = theJsonString.replaceAll("\\s+","");
		
		/*int index = theJsonString.indexOf(theKey);
	    while (index >=0){
	        //System.out.println("Index : "+index);
	    	System.out.println(theJsonString.substring(index + theKey.length() + 5, theJsonString.indexOf("'")));
	        index = theJsonString.indexOf(theKey, index+theKey.length())   ;
	    }*/
		ArrayList<String> values = new ArrayList<String>();
		while(theJsonString.indexOf(theKey) > 0){
			theJsonString = theJsonString.substring(theJsonString.indexOf(theKey) + theKey.length() + 3);
			//System.out.println(theJsonString);
			values.add(theJsonString.substring(0, theJsonString.indexOf("'")));
		}
		return values;
	}
}
